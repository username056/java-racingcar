package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTest {

    @Test
    @DisplayName("decrease 메서드는 횟수를 1 감소")
    void should_minusOne_when_decrease() {
        Count count = new Count(1);

        count.decrease();

        assertThat(count.getValue()).isEqualTo(0);
    }

    @ParameterizedTest(name = "isPlayable 메서드는 진행 가능 횟수가 {0}인 경우 {1}을 반환")
    @CsvSource({"1,true", "0,false"})
    void should_returnState_when_callIsPlayable(final int value, final boolean state) {
        Count count = new Count(value);

        assertThat(count.isPlayable()).isEqualTo(state);
    }
}
