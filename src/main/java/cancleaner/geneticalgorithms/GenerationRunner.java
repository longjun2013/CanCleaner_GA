package cancleaner.geneticalgorithms;

import cancleaner.io.LogWriter;

import java.util.List;

public class GenerationRunner {

    private LogWriter logWriter;
    private List<Item> items;
    private final MixGenerationItemsCreator mixGenerationItemsCreator;

    public GenerationRunner() {
        logWriter = new LogWriter();
        items = new FirstGenerationItemsCreator().create();
        mixGenerationItemsCreator = new MixGenerationItemsCreator();
    }

    public void run() {
        while (true) {
            for (Item item : items) {
                item.run();
            }
            write();
            items = mixGenerationItemsCreator.create(items);
        }
    }

    public void setLogWriter(LogWriter logWriter) {
        this.logWriter = logWriter;
    }

    private void write() {
        logWriter.write("generation_" + items.get(0).getGenerationId(), ItemsContentUtils.getContents(items));
        System.out.println("generation_" + items.get(0).getGenerationId() + ": average score:" + getAverageScore());
    }

    private int getAverageScore() {
        int score = 0;
        for (Item item : items) {
            score += item.getScore();
        }
        return score / items.size();
    }
}
