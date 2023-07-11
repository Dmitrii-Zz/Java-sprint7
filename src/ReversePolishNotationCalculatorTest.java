import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationCalculatorTest {

    private static ReversePolishNotationCalculator reversePolishNotationCalculator;

    @BeforeEach
    public void beforeEach() {

        reversePolishNotationCalculator = new ReversePolishNotationCalculator();
    }

    @Test
    public void shouldCalculateAdditionPlusPlus() {

        int factResult = reversePolishNotationCalculator.calculatePolishNotation("1 2 3 + +");
        int expectedResult = 6;

        assertEquals(expectedResult, factResult);
    }

    @Test
    public void shouldCalculateAdditionMinus() {

        int factResult = reversePolishNotationCalculator.calculatePolishNotation("2 3 -");
        int expectedResult = -1;

        assertEquals(expectedResult, factResult);
    }

    @Test
    public void shouldCalculateAdditionNegativeNumberUmn1() {

        int factResult = reversePolishNotationCalculator.calculatePolishNotation(" -2 3 *");
        int expectedResult = -6;

        assertEquals(expectedResult, factResult);
    }

    @Test
    public void shouldCalculateAdditionNegativeNumberUmn2() {

        int factResult = reversePolishNotationCalculator.calculatePolishNotation(" -2 -3 *");
        int expectedResult = 6;

        assertEquals(expectedResult, factResult);
    }

    @Test
    public void shouldCalculateAdditionNegativeMinusPlusUmn() {

        int factResult = reversePolishNotationCalculator.calculatePolishNotation(" -2 3 2 1 - + *");
        int expectedResult = -8;

        assertEquals(expectedResult, factResult);
    }

    @Test
    public void shouldCalculateAdditionPositiveUmnPlusMinus() {

        int factResult = reversePolishNotationCalculator.calculatePolishNotation(" 5 3 2 1 * + -");
        int expectedResult = 0;

        assertEquals(expectedResult, factResult);
    }
}