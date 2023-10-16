package challenges;

import data.FetchData;
import domain.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarOpsFarazTest {

    private static List<Car> cars;
    @BeforeEach
    void setUp() throws IOException {
        cars = FetchData.getCarList();
    }

    @AfterEach
    void tearDown() {
        cars=null;
    }

    @Test
    void findFirstCar() {
        Car firstCar = cars.get(0);
        assertEquals(firstCar, CarOpsFaraz.findFirstCar(cars));
    }

    @Test
    void findAny() {

        assertEquals(cars.get(0), CarOpsFaraz.findAny(cars));
    }

    @Test
    void removeDuplicatesBasedOnMakeAndModel() {
        List<Car> uniquesBasedOnMakeAndModel = new ArrayList<>();
        Map<String,String> makeToModelMap = new HashMap<>();
        for(Car car : cars){
           if(makeToModelMap.containsKey(car.getMake())){
               if(!makeToModelMap.get(car.getMake()).equals(car.getModel())){
                   makeToModelMap.put(car.getMake(),car.getModel());
                   uniquesBasedOnMakeAndModel.add(car);
               }
           }else {
               makeToModelMap.put(car.getMake(),car.getModel());
               uniquesBasedOnMakeAndModel.add(car);
           }
        };
        System.out.println(CarOpsDonato.sortByMakeThenModel(uniquesBasedOnMakeAndModel));
        uniquesBasedOnMakeAndModel = CarOpsDonato.sortByMakeThenModel(uniquesBasedOnMakeAndModel);
        List<Car> carsWithDuplicatesRemoved = CarOpsFaraz.removeDuplicatesBasedOnMakeAndModel(cars);
        carsWithDuplicatesRemoved = CarOpsDonato.sortByMakeThenModel(carsWithDuplicatesRemoved);

        for(int i = 0;i<carsWithDuplicatesRemoved.size();i++) {
            Car car1 = carsWithDuplicatesRemoved.get(i);
            Car car2 = uniquesBasedOnMakeAndModel.get(i);
            assertTrue(car1.getMake().equals(car2.getMake())&&car1.getModel().equals(car2.getModel()));
        }
    }

    @Test
    void partitionCarsIntoAboveAndBelowNPrice() {
        double N = 100_000;

        List<Car> carsBelowNPrice = cars.stream().filter(car->car.getPrice()<N).toList();
        List<Car> carsAboveNPrice = cars.stream().filter(car->car.getPrice()>N).toList();

        List<List<Car>> carsPartitionedByPrice = CarOpsFaraz.partitionCarsIntoAboveAndBelowNPrice(cars,N);

        assertEquals(carsBelowNPrice,carsPartitionedByPrice.get(0));
        assertEquals(carsAboveNPrice,carsPartitionedByPrice.get(1));
    }

    @Test
    void calculateTotalPriceByMake() {
        Map<String, List<Car>> makeToCarMap = CarOpsDonato.groupByMake(cars);

        Map<String, Double> makeToTotalPriceMap = CarOpsFaraz.calculateTotalPriceByMake(cars);
        makeToCarMap.forEach((make, cars)->{
           double sumOfPrices = Math.floor(cars.stream().mapToDouble(x->x.getPrice()).sum());
           double sumOfPricez = Math.floor(makeToTotalPriceMap.get(make));
           assertEquals(sumOfPrices, sumOfPricez);
        });
    }

    @Test
    void joinCarNamesIntoAString() {
        String carNames = "";
        for(int i = 0;i<cars.size();i++){
            Car car = cars.get(i);
            if(i<cars.size()-1)
            carNames += car.getMake() + " " + car.getModel() + " " + car.getYear() + ", ";
            else
                carNames+= car.getMake()+" "+ car.getModel() + " " + car.getYear();
        }
        assertEquals(carNames, CarOpsFaraz.joinCarNamesIntoAString(cars));
    }

    @Test
    void peekAndPrint() {
        CarOpsFaraz.peekAndPrint(cars);
    }

    @Test
    void averagePricePerMake() {
        Map<String, Double> makeToAverageMap = CarOpsFaraz.averagePricePerMake(cars);
      Map<String, List<Car>> carsGroupedByMake = CarOpsDonato.groupByMake(cars);
      carsGroupedByMake.forEach((make, cars)->{
         double averagePrice = makeToAverageMap.get(make);
         double averagePrize = carsGroupedByMake.get(make).stream().mapToDouble(car->car.getPrice()).average().getAsDouble();
         assertEquals(averagePrize,averagePrice);


      });
    }

    @Test
    void concatenateAllCarDetails() {
        String concatenatedCarDetails = CarOpsFaraz.concatenateAllCarDetails(cars);
        String concatenatedCarDetailz = "";
        for(int i = 0;i<cars.size();i++){
            if(i<cars.size()-1){
                concatenatedCarDetailz+=cars.get(i).toString() + "\n";
            }else {
                concatenatedCarDetailz+=cars.get(i);
            }
        }
        assertEquals(concatenatedCarDetails,concatenatedCarDetailz);
    }

    @Test
    void findNewestCar() {
        int latestYear = 2013;
        assertEquals(CarOpsFaraz.findNewestCar(cars).getYear(),latestYear);
    }
}