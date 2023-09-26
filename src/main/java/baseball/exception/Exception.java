package baseball.exception;

public class Exception {
    public static void checkInvalidOnGoingDecisionInputException(String onGoingDecision){
        if(!onGoingDecision.equals("1") && !onGoingDecision.equals("2")){
            throw new IllegalArgumentException();
        }
    }

    public static void checkInvalidInputException(String userAnswer){
        if(userAnswer.length() != 3 || !userAnswer.matches("[1-9]+")){
            throw new IllegalArgumentException();
        }
    }
}
