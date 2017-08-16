package com.usabb.utils;

import javax.net.ssl.*;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.PixelGrabber;
import java.io.*;
import java.net.URL;

/**
 * Utility methods used to interact with images.
 */
public class ImageUtils {

    private static final boolean equals(final int[] data1, final int[] data2) {
        final int length = data1.length;
        if (length != data2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (data1[i] != data2[i]) {
                //If the alpha is 0 for both that means that the pixels are 100%
                //transparent and the color does not matter. Return false if
                //only 1 is 100% transparent.
                if ((((data1[i] >> 24) & 0xff) == 0) && (((data2[i] >> 24) & 0xff) == 0)) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static final int[] getPixels(final BufferedImage img, final File file) {

        final int width = img.getWidth();
        final int height = img.getHeight();
        int[] pixelData = new int[width * height];

        final Image pixelImg;
        if (img.getColorModel().getColorSpace() == ColorSpace.getInstance(ColorSpace.CS_sRGB)) {
            pixelImg = img;
        } else {
            pixelImg = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_sRGB), null).filter(img, null);
        }
        final PixelGrabber pg = new PixelGrabber(pixelImg, 0, 0, width, height, pixelData, 0, width);
        try {
            if (!pg.grabPixels()) {
                throw new RuntimeException();
            }
        } catch (final InterruptedException ie) {
            throw new RuntimeException(file.getPath(), ie);
        }
        return pixelData;
    }

    /**
     * Gets the {@link BufferedImage} from the passed in {@link File}.
     *
     * @param file The <code>File</code> to use.
     * @return The resulting <code>BufferedImage</code>
     */
    @SuppressWarnings("unused")
    final static BufferedImage getBufferedImage(final File file) {
        Image image;
        try (final FileInputStream inputStream = new FileInputStream(file)) {
            // ImageIO.read(file) is broken for some images
            image = Toolkit.getDefaultToolkit().createImage(file.getCanonicalPath());
            //forces the image to be rendered
            new ImageIcon(image);
        } catch (final Exception e2) {
            throw new RuntimeException(file.getPath(), e2);
        }
        final BufferedImage converted = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2d = converted.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return converted;
    }

    /**
     * Compares file1 to file2 to see if they are the same based on a visual
     * pixel by pixel comparison. This has issues with marking images different
     * when they are not. Works perfectly for all images.
     *
     * @param file1 First file to compare
     * @param file2 Second image to compare
     * @return <code>true</code> if they are equal, otherwise
     * <code>false</code>.
     */
    private final static boolean visuallyCompareJava(final File file1, final File file2) {
        return equals(getPixels(getBufferedImage(file1), file1), getPixels(getBufferedImage(file2), file2));
    }

    /**
     * Compares file1 to file2 to see if they are the same based on a visual
     * pixel by pixel comparison. This has issues with marking images different
     * when they are not. Works perfectly for all images.
     *
     * @param file1 Image 1 to compare
     * @param file2 Image 2 to compare
     * @return <code>true</code> if both images are visually the same.
     */
    public final static boolean visuallyCompare(final File file1, final File file2) {
        if (file1 == file2) {
            return true;
        }
        boolean answer = visuallyCompareJava(file1, file2);
        return answer;
    }

    public final static boolean compareImages(final File fileOrigin, final File tmpFile, final String fileUrl) {
        File imageFromSite = tmpFile;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllX509TrustManager()}, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String string, SSLSession ssls) {
                    return true;
                }
            });
            URL url = new URL(fileUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(imageFromSite);
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
            File imageFromScr = fileOrigin;
            return visuallyCompare(imageFromScr, imageFromSite);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            imageFromSite.delete();
        }
    }

    public static String getFileNameWithExtension(String fileName, String folderPath) {
        String path = folderPath;
        File folder = new File(path);
        File[] files = folder.listFiles();
        String nameFile = new String();
        String nameWithOutExtension;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                nameWithOutExtension = files[i].getName().substring(0, files[i].getName().lastIndexOf('.'));
                if (nameWithOutExtension.equalsIgnoreCase(fileName))
                    nameFile = files[i].getName();
            }
        }
        return nameFile;
    }
}
