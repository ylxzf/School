package intellistack;

public interface IntelliStackInterface {
    void push(int a);
    int pop() throws IntelliStackException;
    boolean isEmpty();
}
