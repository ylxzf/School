package backTrackAlgorithms;

public class Cross {
    private final int[] cr;
    private int level;

    public Cross() {
        this.cr = new int[5];
        level = -1;
        backTrack();
    }

    public int[] getCr() {
        return cr;
    }

    public void backTrack() {
        level++;

        for (int i = 1; i <= 8; i++) {
            cr[level] = i;
            if (test()) {
                backTrack();
            }
        }

        level--;
    }

    public boolean test(){
        return switch (level) {
            case 1 -> cr[0] + cr[1] == 10;
            case 2 -> cr[0] > cr[2];
            case 3 -> cr[0] - cr[3] > 2;
            case 4 -> {
                if (cr[0] * cr[4] > 20) {
                    System.out.printf("  %d  \n", cr[1]);
                    System.out.printf("%d %d %d\n", cr[2], cr[0], cr[3]);
                    System.out.printf("  %d  \n", cr[4]);
                    System.out.println();
                }
                yield false;
            }
            default -> true;
        };

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
