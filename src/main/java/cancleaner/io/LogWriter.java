package cancleaner.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LogWriter {

    public static final String LOG_DIRECTORY = "log";

    public void write(String fileName, String contents) {
        String s = LOG_DIRECTORY + File.separator + fileName;
        File file = new File(s);
        try {
            FileUtils.writeStringToFile(file, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
