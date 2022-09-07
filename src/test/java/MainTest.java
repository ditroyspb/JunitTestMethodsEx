import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MainTest {

    @Test
    void taxEarningsMinusSpend() {
        //arrange
        int a = 1000, b = 400, expected = 90;

        //act
        int result = Main.taxEarningsMinusSpend(a, b);

        //assert
        assertEquals(expected, result);
    }

    @Test
    void taxEarningsMinusSpendHamcrest() {
        //arrange
        int a = 1000, b = 400;

        //act
        int result = Main.taxEarningsMinusSpend(a, b);

        //assert
        assertThat(result, equalTo(90));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void taxEarningsStreamTest(int a, int expected) {
        //act
        int result = Main.taxEarnings(a);
        //assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("sourceEarnMinSpend")
    public void taxEarningsMinusSpendStreamTest(int a, int b, int expected) {
        //act
        int result = Main.taxEarningsMinusSpend(a, b);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void taxEarnings() {
        //arrange
        int a = 1000, expected = 60;
        //act
        int result = Main.taxEarnings(a);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void taxEarningsHamcrest() {
        //arrange
        int a = 1000;

        //act
        int result = Main.taxEarnings(a);

        //assert
        assertThat(result, equalTo(60));
    }

    @Test
    void taxEarningsGreater0Hamcrest() {
        //arrange
        int a = 800;

        //act
        int result = Main.taxEarnings(a);

        //assert
        assertThat(result, is(greaterThan(0)));
    }

    @Test
    void taxEarningsMinSpendGreater0Hamcrest() {
        //arrange
        int a = 800, b = 400;

        //act
        int result = Main.taxEarningsMinusSpend(a, b);

        //assert
        assertThat(result, is(greaterThan(0)));
    }



    @BeforeEach
    public void initTest() {
        System.out.println("Test started");
    }

    @AfterEach
    public void finishTest() {
        System.out.println("Test finished");
    }

    @BeforeAll
    public static void startedTests() {
        System.out.println("Tests started");
    }

    @AfterAll
    public static void finishedTests() {
        System.out.println("Tests finished");
    }

    private static Stream<Arguments> sourceEarnMinSpend() {
        return Stream.of(
                Arguments.of(1000, 400, 90),
                Arguments.of(2000, 200, 270),
                Arguments.of(1500, 500, 150),
                Arguments.of(800, 800, 0),
                Arguments.of(500, 800, 0)
        );
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1000, 60),
                Arguments.of(2000, 120),
                Arguments.of(500, 30),
                Arguments.of(0, 0),
                Arguments.of(3000, 180)
        );
    }
}