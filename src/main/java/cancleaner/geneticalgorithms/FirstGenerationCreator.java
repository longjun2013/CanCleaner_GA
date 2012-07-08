package cancleaner.geneticalgorithms;

import cancleaner.io.LogWriter;

import java.util.ArrayList;
import java.util.List;

public class FirstGenerationCreator {

    private LogWriter logWriter;

    public FirstGenerationCreator() {
        logWriter = new LogWriter();
    }

    public List<Item> create() {
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < 200; i++) {
            Item item = new Item(1);
            item.setId(i + 1);
            item.setGene(createRandomGen());
            items.add(item);
        }
        logWriter.write("generation_1", getContents(items));
        return items;
    }

    private String getContents(List<Item> items) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : items) {
            stringBuilder.append(item.toString());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }

    private String createRandomGen() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3 * 3 * 3 * 3 * 3; i++) {
            int commandIndex = (int) (Math.random() * 6);
            stringBuilder.append(commandIndex);
        }
        return stringBuilder.toString();
    }

    public void setLogWriter(LogWriter logWriter) {
        this.logWriter = logWriter;
    }
}
