package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"dazzle", ""})
    @DisplayName("생성자는 이름의 길이가 없거나 5보다 크면 예외 던짐")
    void should_throwException_when_invalidNameLength(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차의 이름은 1자 이상, 5자 이하여야 합니다.");
    }
}
