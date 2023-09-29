package baseball;

import baseball.exception.Exception;
import baseball.service.BaseballGameService;
import baseball.service.ComputerService;
import baseball.service.UserService;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

//    List<String> answer = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Map<String, Integer> returnList = new HashMap<>();

        List<String> answer = ComputerService.getRandomAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        String checkOnGoing = "1";
        while(checkOnGoing.equals("1")){
            //초기화
            BaseballGameService.initReturnList(returnList);

            //입력
            String userAnswer = UserService.enterNum();
            //checkValidPatternInput
            Exception.checkInvalidInputException(userAnswer);

            //결과
            BaseballGameService.checkStrikeAndBall(returnList, answer, userAnswer);
            BaseballGameService.printResult(returnList);

            //확인
            if(BaseballGameService.checkAnswer(BaseballGameService.getStringNumFromList(answer), userAnswer)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                checkOnGoing = Console.readLine();
                Exception.checkInvalidOnGoingDecisionInputException(checkOnGoing);
                answer = ComputerService.getRandomAnswer();
            }
        }

    }
}
