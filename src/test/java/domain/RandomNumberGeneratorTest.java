package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("generate 메서드는 0부터 9사이의 숫자를 무작위로 생성")
    void should_returnNumber_betweenZeroToNine_when_generate() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        assertThat(numberGenerator.generate()).isBetween(0, 9);
    }
}
