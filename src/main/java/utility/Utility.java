package utility;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class Utility {

    public static boolean checkFileExists(String path) {
        File file = new File(path);
//        System.out.println(path + ": " + file.isFile());
        return file.isFile();
    }

    public static String checkFileExistsOnPath(String fileName) {
        String path = System.getenv("PATH");
        String[] paths = StringUtils.split(path, ":");

        for(String p : paths) {
            String filePath = p + "/" + fileName;
            if(Utility.checkFileExists(filePath)) {
                return filePath;
            }
        }
        return "";
    }

    public static String readFile(String filePath) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return line;
    }

}
