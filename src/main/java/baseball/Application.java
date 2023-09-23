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
}
