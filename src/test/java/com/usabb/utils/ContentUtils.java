package com.usabb.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ${Timonov_Viacheslav} on 5/15/17.
 */
public class ContentUtils {

    /**
     * Read file line by line, and return StringBuilder for this file
     *
     * @param filePath
     * @return <code>StringBuilder</code>
     */
    public static StringBuilder readContentFile(final String filePath) {
        File contentFile = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(contentFile));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return stringBuilder;
    }

    /**
     * Delete empty values from an array
     *
     * @param list
     * @return <code>ArrayList</code>
     */
    public static ArrayList<String> getArrayWithOutEmptySpace(String[] list) {
        ArrayList<String> filteredList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equalsIgnoreCase("")) filteredList.add(list[i]);
        }
        return filteredList;
    }

    /**
     * Compare two html files. Return ArrayList with results of comparision
     *
     * @param fileName <code>String</code>
     * @param content  <code>WebElement</code>
     * @return
     */

    public static ArrayList<String> compareContent(String fileName, WebElement content) {
        ArrayList<String> results = new ArrayList<>();
        StringBuilder readContentFromFile = new StringBuilder(ContentUtils.readContentFile("src/test/resources/content/" + fileName + ".html"));
        String contentFromFileSpacesRemoved = removeSpacesAndQuotes(readContentFromFile.toString());
        String contentFromSiteSpacesRemoved = removeSpacesAndQuotes(content.getAttribute("innerHTML"));

        if (contentFromFileSpacesRemoved.equals(contentFromSiteSpacesRemoved)) {
            results.add("true");
        } else {
            Document sourceHtml = Jsoup.parse(readContentFromFile.toString());
            String textSource = sourceHtml.body().text();

            Document siteHtml = Jsoup.parse(content.getAttribute("innerHTML"));
            String textSite = siteHtml.body().text();

            String[] contentFromSite = textSite.split("\\s");
            String[] contentFromData = textSource.split("\\s");
            results.add(contentFromData.length != contentFromSite.length ? "Some information of content is missed or extra" : "true");
            int count = Math.min(contentFromData.length, contentFromSite.length);
            for (int i = 0; i < count; i++) {
                if (!contentFromSite[i].equals(contentFromData[i])) {
                    results.set(0, "Error found in:\n");
                    results.add("Expected: " + contentFromData[i] + "\n Found: " + contentFromSite[i] + "\n");
                }
            }
        }
        return results;
    }

    private static String removeSpacesAndQuotes(String s) {
        return s.replaceAll("[ \n'\"]", "");
    }
}
