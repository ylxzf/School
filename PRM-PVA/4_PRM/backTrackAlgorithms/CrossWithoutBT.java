package backTrackAlgorithms;

public class CrossWithoutBT extends Cross{
    boolean[] booked;

    public CrossWithoutBT() {
        super();
        booked = new boolean[10];
    }

    public void new_backTrack() {
        setLevel(getLevel()+1);

        for (int i = 1; i <= 8; i++) {
            if (!booked[i]) {
                getCr()[getLevel()] = i;
                booked[i] = true;
                if (test()) {
                    backTrack();
                }
            }
        }

        setLevel(getLevel()-1);
    }
}
