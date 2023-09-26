package baseball.service;

import camp.nextstep.edu.missionutils.Console;

public class UserService {
    public static String enterNum(){
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
