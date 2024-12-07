package stateMachines;

import java.util.Random;

public class stateMachineAlgorithm {
    String[] inputs;

    public stateMachineAlgorithm(String[] inputs) {
        this.inputs = inputs;
    }

    public void stateMachine() {
        StringBuilder output = new StringBuilder();
        String state = "Alpha";
        Random random = new Random();

        long startTime = System.currentTimeMillis();
        while (!output.toString().contains("SEX")) {
            String input = inputs[random.nextInt(inputs.length)];
            switch (state) {
                case "Alpha": {
                    switch (input) {
                        case "0": {
                            output.append("E");
                            state = "Gamma";
                            break;
                        }
                        case "1": {
                            output.append("E");
                            break;
                        }
                    }
                    break;
                }
                case "Beta": {
                    switch (input) {
                        case "0": {
                            output.append("X");
                            state = "Gamma";
                            break;
                        }
                        case "1": {
                            output.append("S");
                            state = "Alpha";
                            break;
                        }
                    }
                    break;
                }
                case "Gamma": {
                    switch (input) {
                        case "0": {
                            output.append("X");
                            state = "Gamma";
                            break;
                        }
                        case "1": {
                            output.append("S");
                            state = "Beta";
                            break;
                        }
                    }
                    break;
                }
            }
            System.out.println(output.toString());
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public void stateMachineFinder(int lowest) {
        StringBuilder output = new StringBuilder();
        String state = "Alpha";
        int i = -1;

        while (true) {
            i++;
            Random random = new Random(i);
            while(!output.toString().contains("SEX")) {
                String input = inputs[random.nextInt(inputs.length)];
                switch (state) {
                    case "Alpha": {
                        switch (input) {
                            case "0": {
                                output.append("E");
                                state = "Gamma";
                                break;
                            }
                            case "1": {
                                output.append("E");
                                break;
                            }
                        }
                        break;
                    }
                    case "Beta": {
                        switch (input) {
                            case "0": {
                                output.append("X");
                                state = "Gamma";
                                break;
                            }
                            case "1": {
                                output.append("S");
                                state = "Alpha";
                                break;
                            }
                        }
                        break;
                    }
                    case "Gamma": {
                        switch (input) {
                            case "0": {
                                output.append("X");
                                state = "Gamma";
                                break;
                            }
                            case "1": {
                                output.append("S");
                                state = "Beta";
                                break;
                            }
                        }
                        break;
                    }
                }
//                System.out.println(output);
            }
            System.out.printf("seed = %d, output_length = %d\n", i, output.length());
            if (output.length() > lowest) {
                return;
            }
            else {
                output.delete(0, output.length());
            }
        }
    }

    public static void main(String[] args) {
        stateMachineAlgorithm demo = new stateMachineAlgorithm(new String[] {"0", "1"});

        demo.stateMachine();

//        demo.stateMachineFinder(150);
    }
}
