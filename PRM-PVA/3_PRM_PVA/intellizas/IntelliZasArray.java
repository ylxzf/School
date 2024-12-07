package intellizas;

public class IntelliZasArray implements IntelliZasInterface{

    private int[] array;
    private int apex; //odkazuje na prvni volnou polozku

    public IntelliZasArray(){
        array = new int[55];
        this.apex = 0;
    }

    public int capacity(){
        return array.length;
    }

    public int howMany(){
        return apex;
    }

    @Override
    public String toString(){
        return howMany() + " / " + capacity() + ", " + howMany() * 100 / capacity() + "%";
    }

    @Override
    public void push(int a) {
        try{
            array[apex] = a;
            apex++;
        }
        catch (ArrayIndexOutOfBoundsException e){
            int[] newArray = new int[array.length + 5];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[apex] = a;
            apex++;
            array = newArray;
            System.out.println("Extending array size by 5.");
            System.out.println();
        }
    }

    @Override
    public int pop() {
        apex--;
        return array[apex];
    }

    @Override
    public boolean isEmpty() {
        return (apex == 0);
    }
}
