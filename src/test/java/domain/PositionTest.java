package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    @DisplayName("Position의 초기값은 0")
    void should_initValueIsZero_when_createPosition() {
        Position position = new Position();

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("increase 메서드는 위치값 1 증가시킴")
    void should_plusOne_when_increase() {
        Position position = new Position();

        position.increase();

        assertThat(position.getValue()).isEqualTo(1);
    }
}
