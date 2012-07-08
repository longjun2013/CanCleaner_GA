package cancleaner.geneticalgorithms;

import java.util.ArrayList;
import java.util.List;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;

public class MixGenerationItemsCreator {

    private RandomGeneMixProvider randomGeneMixProvider;

    public MixGenerationItemsCreator() {
        this.randomGeneMixProvider = new RandomGeneMixProvider();
    }

    public List<Item> getHalfTopItems(List<Item> items) {
        List<Item> sortedItems = sort(items, on(Item.class).getScore());
        return sortedItems.subList(items.size() / 2, items.size());
    }

    public List<Item> create(List<Item> items) {
        List<Item> newItems = new ArrayList<Item>();

        List<Item> halfTopItems = getHalfTopItems(items);

        for (int i = 0; i < halfTopItems.size(); i++) {
            Item item1 = halfTopItems.get(randomGeneMixProvider.getRandomIndex(halfTopItems.size()));
            Item item2 = halfTopItems.get(randomGeneMixProvider.getRandomIndex(halfTopItems.size()));
            List<Item> youthItems = mix(item1, item2);
            for (Item youthItem : youthItems) {
                newItems.add(changeGene(youthItem));
            }
        }
        return newItems;
    }

    public List<Item> mix(Item item1, Item item2) {
        ArrayList<Item> youthItems = new ArrayList<Item>();
        int geneBreakPosition = randomGeneMixProvider.getGeneBreakPosition();

        int parentGenerationId = item1.getGenerationId();
        Item youthItem1 = new Item(parentGenerationId + 1);
        youthItem1.setGene(item1.getGene().substring(0, geneBreakPosition) + item2.getGene().substring(geneBreakPosition, item2.getGene().length()));
        Item youthItem2 = new Item(parentGenerationId + 1);
        youthItem2.setGene(item1.getGene().substring(geneBreakPosition, item1.getGene().length()) + item2.getGene().substring(0, geneBreakPosition));

        youthItems.add(youthItem1);
        youthItems.add(youthItem2);
        return youthItems;
    }

    public void setRandomGeneMixProvider(RandomGeneMixProvider randomGeneMixProvider) {
        this.randomGeneMixProvider = randomGeneMixProvider;
    }

    public Item changeGene(Item item) {
        List<RandomGeneMixProvider.GeneChange> geneChanges = randomGeneMixProvider.getGeneChangePosition();
        for (RandomGeneMixProvider.GeneChange geneChange : geneChanges) {
            String originalGene = item.getGene();
            item.setGene(originalGene.substring(0, geneChange.getPosition() - 1) + geneChange.getNewValue() + originalGene.substring(geneChange.getPosition(), originalGene.length()));
        }
        return item;
    }
}
