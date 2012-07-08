package cancleaner.geneticalgorithms;

import java.util.List;

class ItemsContentUtils {

    public static String getContents(List<Item> items) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : items) {
            stringBuilder.append(item.toString());
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
}
