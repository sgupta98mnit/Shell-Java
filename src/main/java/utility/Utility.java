package utility;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

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


}
