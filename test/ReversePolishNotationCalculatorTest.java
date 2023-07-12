import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Хорошие тесты=) общее покрытие: Class - 100% Method - 100% Line - 100% - ты молодец!
//Хорошая практика выносить классы тестирования в отдельный путь с названием test помеченных соответствующим образом
//можно объединять несколько проверок схожего функционала в одном тесте - так нагляднее и компактнее
//не хватает проверки на присутсвие более чем одного пробела в нотации
//я бы добавил еще проверки для всех действий с переполнением значений. Калькулятор ограничен пределом int
//и было бы неплохо посмотреть как он себя поведет при переполнении


public class ReversePolishNotationCalculatorTest {

    private static ReversePolishNotationCalculator reversePolishNotationCalculator;

    //достаточно выполнить один раз @BeforeAll - класс ReversePolishNotationCalculator не имеет полей
    //и его состояние при выполнении любого типа операций не будет изменяться
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

    //Нужно переименовать shouldCalculateAdditionMinus -> shouldCalculateSubtraction
    @Test
    public void shouldCalculateAdditionMinus() {

        int factResult = reversePolishNotationCalculator.calculatePolishNotation("2 3 -");
        int expectedResult = -1;

        assertEquals(expectedResult, factResult);
    }

    //тоже для shouldCalculateAdditionNegativeNumberUmn1 -> shouldCalculateMultiplication
    //Addition - сложение с англ названия следующих методов могут быть непонятны
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