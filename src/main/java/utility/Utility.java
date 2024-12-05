package utility;

import java.io.File;

public final class Utility {

    public static boolean checkDirectory(String path) {
        File file = new File(path);
        System.out.println(path + ": " + file.isDirectory());
        return file.exists() && file.isDirectory();
    }
}
