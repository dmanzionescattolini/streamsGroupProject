package challenges;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.FetchData;
import domain.Car;

public class CarOps {


    public static Car findFirstCar(List<Car> cars){
        return cars.stream().findFirst().orElseThrow();
    }

    public static Car findAny(List<Car> cars){
        return cars.stream().findAny().orElseThrow();
    }

    public static List<Car> removeDuplicatesBasedOnMakeAndModel(List<Car> cars){
        List<List<String>> makeAndModel = new ArrayList<>();
        return cars.stream().filter(x->{
           if(!makeAndModel.contains(Arrays.asList(x.getMake(),x.getModel()))){
               makeAndModel.add(Arrays.asList(x.getMake(),x.getModel()));
               return true;
           }else {
               return false;
           }
        }).toList();
    }

    public static List<List<Car>> partitionCarsIntoAboveAndBelowNPrice(List<Car> cars, double N){
        return Arrays.asList(cars.stream().filter(x->x.getPrice()<=N).toList(),cars.stream().filter(x->x.getPrice()>N).toList());
    }

    public static Map<String,List<Car>> groupByMake(List<Car> cars){
        return cars.stream().collect(Collectors.groupingBy(x->x.getMake()));
    }
    public static double sumOfPrices(List<Car> cars){
        return cars.stream().mapToDouble(c->c.getPrice()).reduce((x,y)-> x+y).getAsDouble();
    }
    public static Map<String, Double> calculateTotalPriceByMake(List<Car> cars){
            Map<String, List<Car>> carsByMake = groupByMake(cars);
            Map<String, Double> totalPriceByMake = new HashMap<>();
            carsByMake.forEach((make, carz)->{
                totalPriceByMake.put(make, sumOfPrices(carz));
            });
            return totalPriceByMake;
    }

    public static String joinCarNamesIntoAString(List<Car> cars){
        return cars.stream().map(car-> car.getMake() + " " + car.getModel() + " " + car.getYear()).distinct().reduce((acc, car)->acc + ", " + car).orElse("EMPTY");
    }

    public static List<Car> peekAndPrint(List<Car> cars){
       return cars.stream().peek(x-> System.out.println(x)).toList();
    }

    public static Map<String,Double> averagePricePerMake(List<Car> cars){
        Map<String, Double> averagePrices = new HashMap<>();
        groupByMake(cars).forEach((make, carz)-> {
            averagePrices.put(make, carz.stream().map(x -> x.getPrice()).reduce((acc, next) -> (acc + next) / 2).orElse(0.00));
        });
                        return averagePrices;
        };


    public static String concatenateAllCarDetails(List<Car> cars){
        return cars.stream().map(x->x.toString()).reduce((acc, next)->acc+ "\n" + next.toString() ).orElse("EMPTY");
    }

    public static Car findNewestCar(List<Car> cars){
        int earliestYear = cars.stream().mapToInt(x->x.getYear()).max().getAsInt();
        return cars.stream().filter(x->x.getYear()==earliestYear).findFirst().get();
    }
}
