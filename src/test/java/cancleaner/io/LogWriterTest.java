package cancleaner.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogWriterTest {

    @Test
    public void should_write_file_to_log_folder() throws IOException {
        LogWriter logWriter = new LogWriter();
        logWriter.write("filename", "contents");

        File file = new File("log/filename");
        assertThat(file.exists(), is(true));
        assertThat(FileUtils.readFileToString(file), is("contents"));

        file.delete();
    }


}
