package domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.from(List.of("car1", "car2", "car3"));
    }

    @Test
    @DisplayName("move 메서드는 모든 자동차들 이동시킴")
    void should_moveCars_when_move() {
        NumberGenerator numberGenerator
                = new TestNumberGenerator(Lists.newArrayList(4, 3, 5));

        cars.move(numberGenerator);

        assertThat(cars.getCars())
                .extracting("position")
                .containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("findWinner 메서드는 우승자 이름 목록 반환")
    void should_returnWInnersName_when_findWinners() {
        NumberGenerator numberGenerator
                = new TestNumberGenerator(Lists.newArrayList(4, 3, 5));
        cars.move(numberGenerator);

        List<String> result = cars.findWinners();

        assertThat(result).containsExactly("car1", "car3");
    }

    @Test
    @DisplayName("from 메서드는 이름 몰록을 받아 Cars를 반환")
    void should_returnCars_when_inputNames() {
        List<String> carNames = List.of("car1", "car2", "car3");

        Cars cars = Cars.from(carNames);

        assertThat(cars.getCars())
                .extracting("name")
                .containsExactly("car1", "car2", "car3");
    }
}
