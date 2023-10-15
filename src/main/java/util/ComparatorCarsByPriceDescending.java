package util;

import domain.Car;

import java.util.Comparator;

public class ComparatorCarsByPriceDescending implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Double.compare(o2.getPrice(),o1.getPrice());
    }
}
