package challenges;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.FetchData;
import domain.Car;
import util.ComparatorCarsByPriceAscending;
import util.ComparatorCarsByPriceDescending;
import util.ComparatorCarsByYearAscending;

public class CarOps {


    //question 21
    public static List<Car> filterByMake(List<Car> cars,String make){

        return cars.stream().filter(x-> x.getMake().equals(make)).toList();
    }

    //question 22
    public static List<Car> filterByYear(List<Car>cars, int year){
        return cars.stream().filter(x-> x.getYear()==year).toList();
    }

    //question 23
    public static List<Car> filterByPrice(List<Car> cars, double price){
        return cars.stream().filter(x-> x.getPrice().equals(price)).toList();
    }

    //question 24
    public static List<String> mapToModelNames(List<Car> cars){
        return cars.stream().map(x->x.getModel()).distinct().toList();
    }

    //question 25
    public static List<String> mapToUppercases(List<Car> cars){
        return cars.stream().map(x->x.getMake().toUpperCase()).distinct().toList();
    }

    //question 26
    public static List<Car> sortByYear(List<Car> cars){
        return cars.stream().sorted(new ComparatorCarsByYearAscending()).toList();
    }

    //question 27
    public static List<Car> sortByPrice(List<Car> cars){
        return cars.stream().sorted(new ComparatorCarsByPriceDescending()).toList();
    }

    //question 28
    public static Car getHighestPricedCar(List<Car> cars){
        return cars.stream().max(new ComparatorCarsByPriceAscending()).get();
    }

    //question 29
    public static Car getLowestPricedCar(List<Car> cars){
        return cars.stream().min(new ComparatorCarsByPriceAscending()).get();
    }



    //question 30


    public static Map<String,List<Car>> groupByMake(List<Car> cars){
        return cars.stream().collect(Collectors.groupingBy(x->x.getMake()));
    }

    //question 31
    public static List<String> mapToCarMake(List<Car> cars){
        return cars.stream().map(x->x.getMake()).toList();
    }
    public static Map<String, Long> countCarsByMake(List<Car> cars) {

        Map<String, Long> numberOfCarsPerMake = new HashMap<>();
        mapToCarMake(cars).forEach(carMake -> {
            numberOfCarsPerMake.put(carMake, filterByMake(cars,carMake).stream().count());
        });
        return numberOfCarsPerMake;
    }

//	32.Average Price: Calculate the average price of all cars.

    public static double averagePrice(List<Car> cars){
        return cars.stream()
                .mapToDouble(d -> d.getPrice())
                .average()
                .orElse(0.0);
    }
//	33.Sum of Prices: Calculate the sum of all car prices

    public static double sumOfPrices(List<Car> cars){
        return cars.stream().mapToDouble(c->c.getPrice()).reduce((x,y)-> x+y).getAsDouble();
    }
//	34.Any Car with Blue Color: Check if there's any car with a blue color.
    public static boolean anyCarWithBlueColor(List<Car> cars){
        return cars.stream().anyMatch(car->car.getColor().equalsIgnoreCase("blue"));
    }

//	35.All Cars are Expensive: Check if all cars are expensive (e.g., price > 50000).
    public static boolean allCarsAreExpensive(List<Car> cars){
        return cars.stream().allMatch(car->car.getPrice()<=50_000);
    }


//	36.None Match the Condition: Check if none of the cars match a specific condition.

    public static boolean noneMatchTheCondition(List<Car> cars, Predicate<Car> condition){
        return cars.stream().noneMatch(condition);
    }

//	37.Skip First N Cars: Skip the first N cars from the list.
    public static List<Car> skipTheFirstNCars(List<Car> cars, int n){
        return cars.stream().skip(n).toList();

    }
//	38.Limit to N Cars: Limit the list to the first N cars.
    public static List<Car> limitToNCars(List<Car> cars, int n){
        return cars.stream().limit(n).toList();
    }
//	39.Distinct Colors: Get a list of distinct car colors.
    public static List<String> distinctColors(List<Car> cars){
        return cars.stream().map(x->x.getColor()).distinct().toList();
    }
//	40.Concatenate Make and Model: Concatenate the make and model of each car.
    public static List<String> concatenateMakeAndModel(List<Car> cars){
        return cars.stream().map(x->x.getMake()+ " " + x.getModel()).distinct().toList();
    }




}
