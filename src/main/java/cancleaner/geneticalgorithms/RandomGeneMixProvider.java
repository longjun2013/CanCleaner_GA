package cancleaner.geneticalgorithms;

import java.util.ArrayList;
import java.util.List;

public class RandomGeneMixProvider {
    public int getGeneBreakPosition() {
        return (int) (Math.random() * 3 * 3 * 3 * 3 * 3);
    }

    public List<GeneChange> getGeneChangePosition() {
        ArrayList<GeneChange> geneChanges = new ArrayList<GeneChange>();
        int changeCount = (int) (Math.random() * 5);

        for (int i = 0; i < changeCount; i++) {
            geneChanges.add(new GeneChange(getGeneBreakPosition() + 1, (int) (Math.random() * 6)));
        }
        return geneChanges;
    }

    public int getRandomIndex(int size) {
        return (int) (Math.random()* size);
    }

    public static class GeneChange {
        private int position;
        private int newValue;

        GeneChange(int position, int newValue) {
            this.position = position;
            this.newValue = newValue;
        }

        public int getPosition() {
            return position;
        }

        public int getNewValue() {
            return newValue;
        }
    }
}
