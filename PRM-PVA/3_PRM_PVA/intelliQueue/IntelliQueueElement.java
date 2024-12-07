package intelliQueue;

public class IntelliQueueElement {

    private int data;
    private IntelliQueueElement next;
    public IntelliQueueElement(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public IntelliQueueElement getNext() {
        return next;
    }

    public void setNext(IntelliQueueElement next) {
        this.next = next;
    }
}