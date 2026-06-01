package es.iesmz.tests;

import es.iesmz.entity.Time;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    static Stream<Arguments> getTimeObjects() throws Exception {
        return Stream.of(
                Arguments.of(new Time(12, 14, 15), new Time(12, 14, 16)),
                Arguments.of(new Time(12, 59, 44), new Time(12, 59, 45)),
                Arguments.of(new Time(1, 9, 59), new Time(1, 10, 0)),
                Arguments.of(new Time(17, 59, 59), new Time(18, 0, 0)),
                Arguments.of(new Time(23, 59, 59), new Time(0, 0, 0)));
    }

    @ParameterizedTest
    @MethodSource("getTimeObjects")
    void nextSecondTest(Time time, Time timeEsperado) {
        assertEquals(timeEsperado, time.nextSecond());
    }
}
