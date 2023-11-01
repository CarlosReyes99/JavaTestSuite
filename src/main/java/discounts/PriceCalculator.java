package discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private Double total =0.0;
    public Double getTotal() {


        return total;

    }

    public void addPrice(double v) {
        List<Double> priceList = new ArrayList<>();
        priceList.add(v);
        for (Double price : priceList) {
            total += price;
        }

    }

    public void getTotalWithDiscount(int i) {
        total = total - (total*(i/100));
    }
}
