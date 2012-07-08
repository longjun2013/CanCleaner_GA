package cancleaner.geneticalgorithms;

import java.util.ArrayList;
import java.util.List;

class FirstGenerationItemsCreator {

    public List<Item> create() {
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < 200; i++) {
            Item item = new Item(1);
            item.setGene(createRandomGen());
            items.add(item);
        }
        return items;
    }

    private static String createRandomGen() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3 * 3 * 3 * 3 * 3; i++) {
            int commandIndex = (int) (Math.random() * 6);
            stringBuilder.append(commandIndex);
        }
        return stringBuilder.toString();
    }
}
