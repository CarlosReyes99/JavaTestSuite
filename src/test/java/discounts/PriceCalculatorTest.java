package discounts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void  return_0_when_there_are_no_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();
        Double actual= priceCalculator.getTotal();
        assertEquals((Double) 0.0, actual);
    }
    @Test
    public void  return_total_when_price_are_added() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(25.0);
        priceCalculator.addPrice(25.0);
        Double actual= priceCalculator.getTotal();
        assertEquals((Double) 50.0, actual);
    }
    @Test
    public void  return_total_with_discount() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(25.0);
        priceCalculator.addPrice(25.0);
        priceCalculator.getTotalWithDiscount(10);
        Double actual= priceCalculator.getTotal();
        assertEquals((Double) 50.0, actual);
    }
}