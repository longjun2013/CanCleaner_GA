package cancleaner.geneticalgorithms;

import cancleaner.io.LogWriter;

import java.util.List;

public class GenerationRunner {

    private LogWriter logWriter;
    private List<Item> items;

    public GenerationRunner() {
        logWriter = new LogWriter();
        items = new FirstGenerationItemsCreator().create();
    }

    public void run() {
        for (Item item : items) {
            item.run();
        }
        write();
    }

    public void setLogWriter(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    private void write() {
        logWriter.write("generation_1", ItemsContentUtils.getContents(items));
    }
}
