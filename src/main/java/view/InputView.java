package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "경주할 자동차 이름을 입력하십시오.";
    private static final String READ_COUNT_MESSAGE = "시도할 횟수를 입력하십시오.";

    private final InputValidator inputValidator;
    private final Scanner scanner;

    public InputView(final InputValidator inputValidator, final Scanner scanner) {
        this.inputValidator = inputValidator;
        this.scanner = scanner;
    }

    public List<String> readCarNames() {
        System.out.println(READ_NAMES_MESSAGE);
        String input = scanner.nextLine();
        return inputValidator.validateNames(input);
    }

    public int readCount() {
        System.out.println(READ_COUNT_MESSAGE);
        String input = scanner.nextLine();
        return inputValidator.validateCount(input);
    }

}
