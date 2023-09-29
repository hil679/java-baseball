package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    public static List<String> getRandomAnswer(){
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            answer.add(String.valueOf(Randoms.pickNumberInRange(0,9)));
        }
        return answer;
    }

}
