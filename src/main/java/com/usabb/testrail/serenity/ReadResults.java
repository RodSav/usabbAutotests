package com.virco.testrail.serenity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Timonov_Viacheslav} on 6/19/17.
 */
public class ReadResults {

    private static final Logger logger = LoggerFactory.getLogger(ReadResults.class);

    /**
     * @param folderPath
     * @return
     */
    public List<String> getJSONFilesResults(String folderPath) {
        List<String> filesPath = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        String nameWithOutExtension;
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    try {
                        nameWithOutExtension = files[i].getName().substring(files[i].getName().lastIndexOf('.'));
                        if (nameWithOutExtension.equalsIgnoreCase(".json") && files[i].getName().length() > 60) {
                            filesPath.add(files[i].getPath());
                            logger.debug("Add json report {}", files[i].getPath());
                        }
                    } catch (StringIndexOutOfBoundsException ex) {
                        logger.debug("Found file without extension {}", (Object[]) ex.getStackTrace());
                    }

                }
            }
        } else logger.error("The folder doesn't contain files.");
        return filesPath;
    }

    /**
     * @param filePath
     * @return
     */
    public String getJSONContent(String filePath) {
        File jsonFile = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            logger.error("Cant read JSON file {}", (Object[]) e.getStackTrace());
        }
        return stringBuilder.toString();
    }

}
