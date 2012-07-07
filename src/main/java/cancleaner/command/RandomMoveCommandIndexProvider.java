package cancleaner.command;

public class RandomMoveCommandIndexProvider {
    public int getCommandIndex() {
        return (int) (Math.random() * 4);
    }
}
