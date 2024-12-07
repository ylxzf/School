package intelliQueue;

public class IntelliQueueDDS implements IntelliQueueInterface{
    //adding
    private IntelliQueueElement qin;
    //removing
    private IntelliQueueElement qout;
    public IntelliQueueDDS() {
        this.qin = null;
        this.qout = null;
    }

    public void setQin(IntelliQueueElement qin) {
        this.qin = qin;
    }

    public void setQout(IntelliQueueElement qout) {
        this.qout = qout;
    }

    public IntelliQueueElement getQin() {
        return qin;
    }

    public IntelliQueueElement getQout() {
        return qout;
    }

    @Override
    public void add(int a) {
        IntelliQueueElement tmp = new IntelliQueueElement(a);

        if (isEmpty()){
            setQout(tmp);
        }
        else {
            getQin().setNext(tmp);
        }
        setQin(tmp);

    }

    @Override
    public int remove() {
        IntelliQueueElement tmp = getQout();

        if (getQin() == getQout()) {
            setQin(null);
        } else if (isEmpty()) {
            throw new IntelliQueueException();
        }

        setQout(getQout().getNext());

        return tmp.getData();
    }

    @Override
    public boolean isEmpty() {
        return getQin() == null;
    }
}
