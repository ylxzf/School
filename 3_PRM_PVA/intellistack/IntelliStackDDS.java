package intellistack;

public class IntelliStackDDS implements IntelliStackInterface {

    private IntelliStackElement apex;

    public IntelliStackDDS() {
        this.apex = null;
    }

    public IntelliStackElement getApex() {
        return apex;
    }

    public void setApex(IntelliStackElement apex) {
        this.apex = apex;
    }

    @Override
    public void push(int a) {
        IntelliStackElement tmp = new IntelliStackElement(a);

        tmp.setNext(getApex());
        this.apex = tmp;
    }

    @Override
    public int pop() throws IntelliStackException{
        if (isEmpty()){
            throw new IntelliStackException();
        }

        IntelliStackElement tmp = getApex();
        apex = apex.getNext();
        return tmp.getData();
    }

    @Override
    public boolean isEmpty() {
        return apex == null;
    }
}
