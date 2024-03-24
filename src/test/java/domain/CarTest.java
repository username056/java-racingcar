package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    @DisplayName("move 메서드는 4 이상인 경우 전진, 3 이하인 경우 정지")
    void should_move_when_valueIsMoreThanFour(final int value, final int position) {
        Car car = new Car("aaa");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("isSamePosition 메서드는 위치 다르면 false 반환")
    void should_returnFalse_when_positionIsNotSame() {
        Car car = new Car("aaa");
        car.move(Integer.MAX_VALUE);

        boolean result = car.isSamePosition(new Car("aaa2"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isSamePosition 메서드는 위가 같으면 true 반환")
    void should_returnSame_when_positionIsSame() {
        Car car = new Car("aaa");

        boolean result = car.isSamePosition(new Car("aaa2"));

        assertThat(result).isTrue();
    }
}
