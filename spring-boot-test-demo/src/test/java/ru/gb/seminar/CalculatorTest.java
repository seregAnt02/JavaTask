package ru.gb.seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.gb.seminar.Calculator;
import ru.gb.seminar.CalculatorHistory;

public class CalculatorTest {

    @Test
    void testSum(){
        CalculatorHistory calculatorHistoryMock = Mockito.mock(CalculatorHistory.class);

        Calculator calculator = new Calculator(calculatorHistoryMock);
        int sum = calculator.sum(6, 3);
        Assertions.assertEquals(9, sum);

        Mockito.verify(calculatorHistoryMock).logSumOperation(6, 3, 9);
    }
}
