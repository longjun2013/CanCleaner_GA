package cancleaner.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LogWriter {
    public void write(String fileName, String contents) {
        File file = new File("log/" + fileName);
        try {
            FileUtils.writeStringToFile(file, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
