package org.atrzaska.ebiznes.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class FileUtils {
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public static String readFileAsString(String filePath) {
        try {
            StringBuffer fileData = new StringBuffer();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            char[] buf = new char[1024];
            int numRead = 0;

            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }

            reader.close();
            return fileData.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
