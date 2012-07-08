package cancleaner.geneticalgorithms;

public class Item {
    private int generationId;
    private int id;
    private String gene;

    public Item(int generationId) {
        this.generationId = generationId;
    }

    public int getGenerationId() {
        return generationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    @Override
    public String toString() {
        return id + ":" + gene;
    }
}
