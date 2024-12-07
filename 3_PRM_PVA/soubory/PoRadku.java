package soubory;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class PoRadku {
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("src/soubory/matcj.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringJoiner NUM = new StringJoiner(", ", "NUM: [", "]");
        StringJoiner CJ = new StringJoiner(", ", "CJ : [", "]");
        StringJoiner MAT = new StringJoiner(", ", "MAT: [", "]");

        int arrayLength = 490;

        int[][] All = new int[arrayLength][2];

        String line;
        int i = 0;
        while ((line= bufferedReader.readLine()) != null){
            All[i][0] = Integer.parseInt(line.split(";")[0]);
            All[i][1] = Integer.parseInt(line.split(";")[1]);
            i++;
        }

        for (int[] item : All) {
            MAT.add(String.format("%3d", item[0]));
        }
        for (int[] value : All) {
            CJ.add(String.format("%3d", value[1]));
        }

        for (int j = 0; j < 490; j++) {
            NUM.add(String.format("%3d", j+1));
        }

        System.out.println("All: " + Arrays.deepToString(All));
        System.out.println();

        System.out.println(NUM.toString());
        System.out.println(MAT.toString());
        System.out.println(CJ.toString());

        int matCheck = 0;
        int cjCheck = 0;
        int same = 0;

        ArrayList<String> matNUM = new ArrayList<>();
        ArrayList<String> cjNUM = new ArrayList<>();
        ArrayList<String> sameNUM = new ArrayList<>();

        for (int j = 0; j < arrayLength; j++) {
            if (All[j][0] < All[j][1]){
                cjCheck++;
                cjNUM.add(String.format("%3d", j+1));
            } else if (All[j][0] > All[j][1]) {
                matCheck++;
                matNUM.add(String.format("%3d", j+1));
            }
            else {
                same++;
                sameNUM.add(String.format("%3d", j+1));
            }
        }

//        for (int[] ints : All) {
//            if (ints[1] > ints[0]) {
//                cjCheck++;
//            } else if (ints[0] > ints[1]) {
//                matCheck++;
//            } else {
//                same++;
//            }
//        }

        System.out.println();
        System.out.println("MAT more: " + matCheck);
        System.out.println("CJ more : " + cjCheck);
        System.out.println("Same    : " + same);

        System.out.println();

        System.out.println("MAT more positions: " + matNUM);
        System.out.println("CJ more positions : " + cjNUM);
        System.out.println("Same positions    : " + sameNUM);

        bufferedReader.close();
    }
}
