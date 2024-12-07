package stateMachines;

import java.util.Random;
import java.util.StringJoiner;

public class BinaryAdder {
    Random random = new Random();
    final String[] inputs;


    public BinaryAdder(String[] inputs) {
        this.inputs = inputs;
    }

    public void stateMachine(int numberOfGeneratedInputs){
        boolean state = false;

        for(int i = 0; i < numberOfGeneratedInputs; i++){
            String input = this.inputs[random.nextInt(this.inputs.length)];
            System.out.print(input + "->");
            String output = "";

            switch(input){
                case "00": {
                    if (!state){
                        output = "0";
                        state = false;
                    }
                    else {
                        output = "1";
                        state = false;
                    }
                    break;
                }
                case "01", "10":
                    if (!state){
                        output = "1";
                        state = false;
                    }
                    else {
                        output = "0";
                        state = true;
                    }
                    break;
                case "11":
                    if (!state){
                        output = "0";
                        state = true;
                    }
                    else {
                        output = "1";
                        state = true;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input");
            }
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        BinaryAdder binaryAdder = new BinaryAdder(new String[] {"00", "01", "10", "11"});

        binaryAdder.stateMachine(10);
    }
}
