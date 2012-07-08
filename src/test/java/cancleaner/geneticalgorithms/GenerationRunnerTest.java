package cancleaner.geneticalgorithms;

import cancleaner.io.LogWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GenerationRunnerTest {

    private GenerationRunner generationRunner;
    private LogWriter mockLogWriter;

    @Before
    public void setUp() {
        generationRunner = new GenerationRunner();
        mockLogWriter = mock(LogWriter.class);
        generationRunner.setLogWriter(mockLogWriter);
    }


//    @Test
//    public void should_write_items_to_file() {
//        LogWriter mockLogWriter = mock(LogWriter.class);
//        generationRunner.setLogWriter(mockLogWriter);
//
//        generationRunner.run();
//
//        verify(mockLogWriter).write(eq("generation_1"), anyString());
//    }
}
