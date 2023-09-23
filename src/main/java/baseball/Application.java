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


    }

    public static List<String> getRandomAnswer(){
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            answer.add(String.valueOf(Randoms.pickNumberInRange(0,9)));
        }
        return answer;
    }

}
