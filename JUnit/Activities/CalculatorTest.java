package examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    static Calculator calc;
    @BeforeEach
    public void setup() {
        calc = new Calculator();
    }
    @Test
    @DisplayName("Test Add")
    public void addTest(){
    calc.add(10,20);
    }

    @Test
    @DisplayName("Test Multiply")
    @Disabled("Not implemented")
    public void multiplyTest(){
        calc.multiply(2,5);
    }
}
