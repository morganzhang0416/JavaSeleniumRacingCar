package com.buggycar.utils;
import java.io.*;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class FileUtils {

    public static String readLastLine(String fileName) {
        String lastLine = null;

        try {
            // Create a ReversedLinesFileReader with a block size of 4KB and UTF-8 encoding
            ReversedLinesFileReader fileReader = new ReversedLinesFileReader(new File(fileName), StandardCharsets.UTF_8);

            // Read the last line of the file
            lastLine = fileReader.readLine();

            // Close the reader
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lastLine;
    }

    public static void writeUsernameToFile(String username,String fileName) {
        long timestamp = System.currentTimeMillis();
        System.out.println("Current timestamp: " + timestamp);

        try {
            // Create a FileWriter instance to append to the file
            FileWriter writer = new FileWriter("username.txt", true);

            // Append the username and timestamp value to the file
            writer.append(username + "_" + Long.toString(timestamp) + "\n");

            // Close the writer
            writer.close();

        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
}
