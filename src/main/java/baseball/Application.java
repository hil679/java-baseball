package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static Map<String, Integer> returnList = new HashMap<>();
//    List<String> answer = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<String> answer = getRandomAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        String checkOnGoing = "1";
        while(checkOnGoing.equals("1")){
            //초기화
            initReturnList();

            //입력
            String userAnswer = enterNum();

            //결과
            checkStrikeAndBall(answer, userAnswer);
            printResult(returnList);

            //확인
            if(checkAnswer(getStringNumFromList(answer), userAnswer)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                checkOnGoing = Console.readLine();
                answer = getRandomAnswer();
            }
        }

        }

    public static List<String> getRandomAnswer(){
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            answer.add(String.valueOf(Randoms.pickNumberInRange(0,9)));
        }
        return answer;
    }

    public static void initReturnList(){
        returnList.put("strike", 0);
        returnList.put("ball", 0);
    }

    public static String enterNum(){
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void checkStrikeAndBall (List<String> answer, String userAnswer){

        for(int i = 0; i < userAnswer.length(); i++){
            String compareAnswerNumIndex = answer.get(i);
            String userAnswerOneString = userAnswer.substring(i, i+1);
            if(checkStrike(compareAnswerNumIndex, userAnswerOneString)){
                plusStrike();
            }else if(checkBall(answer, userAnswerOneString)){
                plusBall();
            }
        }
    }

    public static boolean checkStrike (String compareAnswerNumIndex, String userAnswerOneString){
        if(compareAnswerNumIndex.equals(userAnswerOneString)){
            return true;
        }
        return false;
    }

    public static void plusStrike (){
        returnList.put("strike", returnList.get("strike") + 1);
    }

    public static boolean checkBall (List<String> answer, String userAnswerOneString){
        if(answer.contains(userAnswerOneString)){
            return true;
        }
        return false;
    }

    public static void plusBall (){
        returnList.put("ball", returnList.get("ball") + 1);
    }

    public static String checkStrikeAndBallResultPrint(int ball, int strike){
        String result = "";

        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }

        return result;
    }

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
}
