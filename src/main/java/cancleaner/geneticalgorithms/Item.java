package cancleaner.geneticalgorithms;

import cancleaner.command.CommandDispatcher;
import cancleaner.robot.Robot;
import cancleaner.robot.Square;

public class Item {
    private int generationId;
    private int id;
    private String gene;
    private int score;

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

    public void run() {
        int score = 0;
        for (int i = 0; i < 100; i++) {
            score += runOnce();
        }
        score = score / 100;
        this.score = score;
    }

    private int runOnce() {
        Square square = new Square(10, 10);
        Robot robot = square.getRobot();
        CommandDispatcher commandDispatcher = new CommandDispatcher(robot);
        for (int i = 0; i < 100; i++) {
            Integer signal = Integer.valueOf(String.valueOf(gene.charAt(robot.getSituation().getCode())));
            commandDispatcher.execute(signal);
        }
        return robot.getScore();
    }

    @Override
    public String toString() {
        return id + ":" + gene + ":" + score;
    }

    public int getScore() {
        return score;
    }
}
