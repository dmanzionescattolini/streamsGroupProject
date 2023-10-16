package challenges;

import java.io.IOException;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import data.FetchData;
import domain.Car;

public class CarOpsFaraz {

    public static void main(String[] args) throws IOException {
       System.out.println(CarOpsFaraz.joinCarNamesIntoAString(FetchData.getCarList()));
    }
    public static Car findFirstCar(List<Car> cars){
        return cars.stream().findFirst().orElseThrow();
    }

    public static Car findAny(List<Car> cars){
        return cars.stream().findAny().orElseThrow();
    }

    public static List<Car> removeDuplicatesBasedOnMakeAndModel(List<Car> cars){
        List<Car> uniqueCarsBasedOnMakeAndModel = new ArrayList<>();
        Map<String, List<Car>> makeAndModelToCarsMap = cars.stream().collect(Collectors.groupingBy(car->car.getMake()+ " " + car.getModel()));
        makeAndModelToCarsMap.forEach((makeAndModel,carz)->{
            uniqueCarsBasedOnMakeAndModel.add(carz.get(0));
        });
        return uniqueCarsBasedOnMakeAndModel;
    }

    public static List<List<Car>> partitionCarsIntoAboveAndBelowNPrice(List<Car> cars, double N){
        return Arrays.asList(cars.stream().filter(x->x.getPrice()<N).toList(),cars.stream().filter(x->x.getPrice()>N).toList());
    }


    public static Map<String, Double> calculateTotalPriceByMake(List<Car> cars){
            Map<String, List<Car>> carsByMake = CarOpsDonato.groupByMake(cars);
            Map<String, Double> totalPriceByMake = new HashMap<>();
            carsByMake.forEach((make, carz)->{
                totalPriceByMake.put(make, CarOpsDonato.sumOfPrices(carz));
            });
            return totalPriceByMake;
    }

    public static String joinCarNamesIntoAString(List<Car> cars){
        return cars.stream().map(car-> car.getMake() + " " + car.getModel() + " " + car.getYear()).reduce((acc, car)->acc + ", " + car).orElse("EMPTY");
    }

    public static void peekAndPrint(List<Car> cars){
        cars.stream().peek(x-> System.out.println(x)).close();
    }

    public static Map<String,Double> averagePricePerMake(List<Car> cars){
        Map<String, Double> averagePrices = new HashMap<>();
        CarOpsDonato.groupByMake(cars).forEach((make, carz)-> {
            averagePrices.put(make, carz.stream().mapToDouble(x -> x.getPrice()).average().getAsDouble());
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
