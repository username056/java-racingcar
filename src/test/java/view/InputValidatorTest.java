package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {", ,", "", "  ,안녕", "abcdefg"})
    @DisplayName("validateNames 메서드는 올바른 차 이름이 아닐 시 예외 던짐")
    void should_throwException_when_invalidateNmaes(final String input) {
        assertThatThrownBy(()->inputValidator.validateNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차의 이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("validateNames 메서드는 차 이름이 올바른지 확인 후 이름 목록 반환")
    void should_returnValidNames_when_validateInput() {
        String input = "aa,bb,cc";

        List<String> result = inputValidator.validateNames(input);

        assertThat(result).containsExactly("aa", "bb", "cc");
    }

    @ParameterizedTest
    @ValueSource(strings = {"h", "Q", "한", "!", "", "-1", "0", "1.2"})
    @DisplayName("정수로 변환할 수 없거나, 1 이상의 정수가 아닌 경우 예외 던짐")
    void should_throwException_when_invalidCount(final String input) {
        assertThatThrownBy(() -> inputValidator.validateCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 정수만 가능합니다.");
    }
}
