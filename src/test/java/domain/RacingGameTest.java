package domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame generateRacingGame(final int count) {
        NumberGenerator numberGenerator
                = new TestNumberGenerator(Lists.newArrayList(4, 3));
        List<String> names = List.of("car1", "car2");
        return new RacingGame(numberGenerator, names, count);
    }

    @Test
    @DisplayName("play 메서드는 자동차 경주 게임 진행 후 결과 반환")
    void should_returnCarList_when_play() {
        RacingGame racingGame = generateRacingGame(1);

        List<Car> result = racingGame.play();

        assertThat(result)
                .extracting("position")
                .containsExactly(1, 0);
    }

    @Test
    @DisplayName("play 메서드 호출 시 진행 가능 횟수가 1 줄어듦")
    void should_decreaseCount_when_play() {
        RacingGame racingGame = generateRacingGame(1);

        racingGame.play();

        assertThat(racingGame.isPlayable()).isFalse();
    }

    @Test
    @DisplayName("findWinners 메서드는 우승자의 이름 목록을 반환")
    void should_returnWinnersName_when_findWinners() {
        RacingGame racingGame = generateRacingGame(1);
        racingGame.play();

        List<String> result = racingGame.findWinners();

        assertThat(result).containsExactly("car1");
    }
}
