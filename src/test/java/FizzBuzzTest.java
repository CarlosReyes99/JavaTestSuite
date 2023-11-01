import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {


    @Test
    public void return_fizz_when_number_is_divisible_by_3() {

        assertEquals("Fizz", FizzBuzz.getValue(3));
    }
    @Test
    public void return_buzz_when_number_is_divisible_by_5() {

        assertEquals("Buzz", FizzBuzz.getValue(5));
    }
    @Test
    public void return_fizzbuzz_when_number_is_divisible_by_3_and_5() {

        assertEquals("FizzBuzz", FizzBuzz.getValue(15));
    }
}
