package stateMachines;

public class stateMachineAlgorithm2 {

    private final String[] inputs;
    private final String inputString;

    public stateMachineAlgorithm2(String[] inputs, String inputString) {
        this.inputs = inputs;
        this.inputString = inputString;
    }

    public void stateMachine() {
        StringBuilder output = new StringBuilder();
        String state = "Alpha";

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < inputString.length(); j++) {
                switch (state) {
                    case "Alpha": {
                        switch (inputString.charAt(j)) {
                            case 'A': {
                                output.append("1");
                                state = "Beta";
                                break;
                            }
                            case 'B': {
                                output.append("0");
                                state = "Delta";
                                break;
                            }
                            case 'C': {
                                output.append("1");
                                state = "Gamma";
                                break;
                            }
                        }
                        break;
                    }
                    case "Beta": {
                        switch (inputString.charAt(j)) {
                            case 'A': {
                                output.append("1");
                                state = "Alpha";
                                break;
                            }
                            case 'B': {
                                output.append("0");
                                state = "Delta";
                                break;
                            }
                            case 'C': {
                                output.append("1");
                                state = "Gamma";
                                break;
                            }
                        }
                        break;
                    }
                    case "Gamma": {
                        switch (inputString.charAt(j)) {
                            case 'A': {
                                output.append("1");
                                state = "Alpha";
                                break;
                            }
                            case 'B': {
                                output.append("0");
                                state = "Gamma";
                                break;
                            }
                            case 'C': {
                                output.append("1");
                                state = "Beta";
                                break;
                            }
                        }
                        break;
                    }
                    case "Delta": {
                        switch (inputString.charAt(j)) {
                            case 'A': {
                                output.append("1");
                                state = "Alpha";
                                break;
                            }
                            case 'B': {
                                output.append("0");
                                state = "Beta";
                                break;
                            }
                            case 'C': {
                                output.append("1");
                                state = "Delta";
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            System.out.println(output.toString());
        }
    }

    public static void main(String[] args) {
        String inputString = "BBAACBC";

        stateMachineAlgorithm2 stateMachine = new stateMachineAlgorithm2(new String[] {"A", "B", "BRC"}, inputString);
        stateMachine.stateMachine();
    }
}
