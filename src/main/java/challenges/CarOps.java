package challenges;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.FetchData;
import domain.Car;
import util.ComparatorCarsByPriceAscending;
import util.ComparatorCarsByPriceDescending;
import util.ComparatorCarsByYearAscending;

public class CarOps {
    public static void main(String[] args) throws IOException {
       List<List<Car>> cars = CarOps.partitionCarsIntoAboveAndBelowNPrice(FetchData.getCarList(), 50_000);
        System.out.println(cars.get(0));
        System.out.println(cars.get(1));
    }
    //	41.Find First Car: Find the first car in the list.
//	42.Find Any Car: Find any car in the list.
//	43.Remove Duplicates: Remove duplicate cars from the list based on make and model.
//	44.Partition Cars by Price: Partition the cars into two groups based on whether their price is above a certain value.
//	45.Calculate Total Price by Make: Calculate the total price of cars for each make.
//	46.Join Car Names into a String: Join the names of all cars into a single comma-separated string.
//	47.Peek and Print: Use peek to print the details of each car in the stream.
//	48.Average Price by Make: Calculate the average price of cars for each make.
//	49.Concatenate All Car Details: Concatenate all car details into a single string.
//	50.Find the Newest Car: Find the newest (latest year) car in the list.

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



}
