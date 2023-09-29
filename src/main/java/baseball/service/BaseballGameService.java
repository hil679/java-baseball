package baseball.service;

import java.util.List;
import java.util.Map;

public class BaseballGameService {
    //initial
    public static void initReturnList(Map<String, Integer> returnList){
        returnList.put("strike", 0);
        returnList.put("ball", 0);
    }

    //check answer
    public static boolean checkAnswer(String answer, String userAnswer){//map의 strike가 3인가로도 할 수 있다.
        if(answer.equals(userAnswer))
            return true;
        return false;
    }

    public static String getStringNumFromList(List<String> answer){
        String returnValue = "";
        for(String num : answer){
            returnValue += num;
        }
        return returnValue;
    }

    //check strike and ball
    public static void checkStrikeAndBall (Map<String, Integer> returnList, List<String> answer, String userAnswer){

        for(int i = 0; i < userAnswer.length(); i++){
            String compareAnswerNumIndex = answer.get(i);
            String userAnswerOneString = userAnswer.substring(i, i+1);
            if(checkStrike(compareAnswerNumIndex, userAnswerOneString)){
                plusStrike(returnList);
            }else if(checkBall(answer, userAnswerOneString)){
                plusBall(returnList);
            }
        }
    }
    private static boolean checkStrike (String compareAnswerNumIndex, String userAnswerOneString){
        if(compareAnswerNumIndex.equals(userAnswerOneString)){
            return true;
        }
        return false;
    }

    private static void plusStrike (Map<String, Integer> returnList){
        returnList.put("strike", returnList.get("strike") + 1);
    }

    private static boolean checkBall (List<String> answer, String userAnswerOneString){
        if(answer.contains(userAnswerOneString)){
            return true;
        }
        return false;
    }

    private static void plusBall (Map<String, Integer> returnList){
        returnList.put("ball", returnList.get("ball") + 1);
    }

    //print
    public static void printResult(Map<String, Integer> returnList){
        String result = "";
        int ball = returnList.get("ball");
        int strike = returnList.get("strike");
        if(strike == 0 && ball == 0){
            result = "낫싱";
        }
        else {
            result = checkStrikeAndBallResultPrint(ball, strike);
        }
        System.out.println(result);
    }

    private static String checkStrikeAndBallResultPrint(int ball, int strike){
        String result = "";

        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }

        return result;
    }
}
