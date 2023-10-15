package util;

import domain.Car;

import java.util.Comparator;

public class ComparatorCarsByYearAscending implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getYear(),o2.getYear());
    }
}
