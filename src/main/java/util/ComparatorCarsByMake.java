package util;

import domain.Car;

import java.util.Comparator;

public class ComparatorCarsByMake implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if(o1.getMake().equals(o2.getMake())){
            return o1.getModel().compareTo(o2.getModel());
        }else
        return o1.getMake().compareTo(o2.getMake());
    }
}
