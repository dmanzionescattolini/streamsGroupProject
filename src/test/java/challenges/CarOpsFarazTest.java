package challenges;

import data.FetchData;
import domain.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

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
        Set<Car> uniquesBasedOnMakeAndModel = new HashSet<>();
        Map<String,List<String>> makeToModelMap = new HashMap<>();
        for(Car car : cars){
           if(makeToModelMap.containsKey(car.getMake())){
               if(!makeToModelMap.get(car.getMake()).contains(car.getModel())){
                   makeToModelMap.get(car.getMake()).add(car.getModel());
                   uniquesBasedOnMakeAndModel.add(car);
               }
           }else {
               makeToModelMap.put(car.getMake(),new ArrayList(Arrays.asList(car.getModel())));
               uniquesBasedOnMakeAndModel.add(car);
           }
        };

        Set<Car> carsWithDuplicatesRemoved = CarOpsFaraz.removeDuplicatesBasedOnMakeAndModel(cars);

        System.out.println(carsWithDuplicatesRemoved.size());
        System.out.println(uniquesBasedOnMakeAndModel.size());
        System.out.println(cars.size());
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