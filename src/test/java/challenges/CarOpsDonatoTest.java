package challenges;

import data.FetchData;
import domain.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CarOpsDonatoTest {
   private static List<Double> pricesInDescendingOrder = new ArrayList<>(
            Arrays.asList(239045.51,239035.69,239030.37,238054.9,238050.98,237701.07,237623.22,237233.86,237206.4,237044.7,236667.28,236216.49,236074.51,235831.05,235726.84,235445.87,235345.71,234940.73,233453.5,233432.3,233328.56,233252.86,233196.16,232841.79,232715.12,232586.19,232568.32,232166.82,231942.67,231454.15,231258.34,230000.01,228800.03,228704.12,228682.62,228450.79,228330.78,227245.9,226557.57,226166.93,225943.17,225550.43,224797.55,223612.34,223297.88,223068.36,222890.04,222358.85,221494.84,220774.32,220750.27,220578.43,220276.79,219945.86,219349.38,219210.36,219076.51,218606.83,217854.06,217765.51,217640.24,217079.3,216839.56,215951.34,215102.78,214915.72,214880.47,214748.65,214263.16,214151.99,213186.46,213033.17,212869.39,211517.63,210484.88,210484.76,208811.97,208750.46,208612.38,208365.31,207650.4,207533.65,207500.08,207484.15,206362.38,206240.87,206095.11,205818.19,205781.48,204084.79,203505.31,201830.48,201369.97,200636.5,200622.07,200326.44,200269.11,200163.34,199489.72,199127.47,198948.94,198886.16,197957.63,197793.91,197095.87,195825.22,195117.98,194432.71,194388.55,192995.7,192952.97,192696.65,192523.98,190892.23,190401.01,190338.01,190061.14,189461.72,189240.61,189181.52,188643.84,188632.29,188276.92,187673.02,187550.93,187484.16,187270.05,186579.99,186576.25,186454.11,186272.59,186271.49,185861.82,185700.4,184865.81,184527.63,184444.75,184302.17,183481.6,182960.74,182904.79,182688.86,182277.94,181926.57,179655.71,179301.83,178038.85,177909.41,177096.18,176659.22,176608.12,176374.75,176236.46,176137.11,174961.54,174868.83,174483.84,174069.35,173951.57,173679.69,173630.0,172993.68,171887.01,170812.97,170662.84,170358.26,170275.83,170254.16,170203.51,169938.88,169308.77,169198.87,168998.66,168714.83,167185.35,167151.13,166625.13,165570.87,164838.51,164753.36,163274.59,163157.26,162701.46,162354.31,161487.08,161228.85,161167.82,161121.11,159879.14,158331.01,158241.41,157684.78,157564.92,157219.4,157189.77,156851.57,156515.59,156412.07,155852.87,154123.82,154065.63,153821.72,153371.46,153227.72,152959.78,152624.01,152613.4,152430.34,152154.34,151678.67,151339.73,150856.05,150493.49,150476.76,149765.5,147468.45,147380.22,146845.06,145445.92,144954.72,144938.95,143667.92,143612.87,141305.53,140015.04,139581.1,139355.04,139331.48,138724.93,137806.16,136289.64,135578.52,135518.17,134606.04,134173.22,133614.4,133308.76,132543.86,131817.61,131181.46,130283.67,129331.21,128961.88,128868.73,128486.75,128482.77,127929.2,127021.23,126715.66,126694.72,126587.5,126457.92,125920.3,125830.34,125421.8,124961.23,124948.44,124488.72,124351.68,123997.2,123291.09,122832.8,122653.94,122468.87,120684.26,119457.85,118856.87,117968.14,117758.35,116274.23,114551.76,114490.28,114105.03,113706.63,113222.23,113161.35,112601.1,112429.19,111924.7,111761.69,109655.46,109355.72,109326.74,109109.61,109107.29,108006.38,106852.01,105918.05,105790.95,105723.42,105488.59,105223.19,104891.93,104527.68,103995.01,103964.32,103624.7,103313.8,102597.28,102317.38,102303.04,101704.19,101680.98,100234.16,99985.26,99443.2,99140.31,98907.93,98784.6,98417.73,98314.68,97975.64,97409.65,97109.24,96916.66,96792.67,96656.53,94551.16,94149.26,93856.76,92313.63,91641.21,91637.68,90986.65,90490.02,90311.36,89802.52,89612.16,89310.76,88539.81,88398.28,87791.25,87302.49,87291.48,87160.02,86096.85,85884.48,85627.81,85457.33,84684.57,84561.9,84139.7,84046.84,84034.67,83234.7,82561.6,81882.48,81876.33,81847.44,81596.13,80882.22,80527.58,80344.04,79632.07,79294.37,79290.04,78987.0,78779.77,78503.73,77756.21,77541.61,77448.42,77239.67,77063.06,77015.55,76843.4,76684.73,76093.73,75377.28,74530.14,74504.11,74320.45,73878.84,73722.65,73697.97,73160.45,73027.85,72222.76,72038.65,71898.5,71764.95,71426.0,69891.89,69384.02,68558.36,67834.82,67761.1,66658.94,66423.28,66079.15,65816.72,65332.08,65266.95,65245.75,64079.89,64062.9,62751.66,60772.91,60467.82,60356.33,59557.9,59102.48,58695.46,58579.38,58460.17,58424.51,56310.79,55806.26,55178.55,55022.2,54754.6,54087.59,54066.48,53959.57,53779.59,53122.87,51972.48,51912.63,51664.11,51412.82,51249.12,51179.24,50497.12,49326.36,49003.22,48738.14,48624.43,48567.43,48442.04,47756.91,47516.25,46879.33,46705.81,46623.34,46616.66,46031.21,45228.36,43656.01,43368.88,43059.71,42845.03,42830.49,42472.04,42329.06,41011.64,41009.99,40907.72,40562.86,40544.47,39939.86,39789.72,39489.11,39469.88,38601.26,37921.43,37831.01,37728.85,37676.72,37526.9,36774.27,36112.33,35533.65,35149.16,34123.1,34005.0,33866.85,33516.8,32704.65,32410.5,32284.17,32259.8,29945.4,29876.02,29812.18,29063.12,28631.46,28462.88,27651.12,27248.48,25989.35,25904.84,25664.05,25617.29,25300.58,24730.81,24420.02,24410.7,24106.97,23192.99,22175.15,22062.56,21811.64,21490.47,21425.45,20895.42,20857.21,20828.52,20501.78,20214.87,20055.27
            ));
    private static List<Car> cars;

    @BeforeEach
    void setUp() {
        try {
            cars = FetchData.getCarList();
        } catch (IOException e) {
            System.out.println("Problem fetching data. Stack trace:");
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        cars = null;
    }

    //    Filter by Make: Filter the list of cars to only include cars with a specific make.
    @Test
    void filterByMake() {
        String make = "Ford";
        assertFalse(cars.stream().allMatch(x -> x.getMake().equals(make)));
        assertTrue(CarOpsDonato.filterByMake(cars, make).stream().allMatch(x -> x.getMake().equals(make)));
    }
//    Filter by Year: Filter the list of cars to only include cars from a specific year.

    @Test
    void filterByYear() {
        int year = 1999;
        assertFalse(cars.stream().allMatch(x -> x.getYear() == year));
        assertTrue(CarOpsDonato.filterByYear(cars, year).stream().allMatch(x -> x.getYear() == year));
    }
//    Filter by Price: Filter the list of cars to only include cars within a price range.

    @Test
    void filterByPrice() {
        double lowestPrice = 60_000;
        double highestPrice = 100_000;
        assertFalse(cars.stream().allMatch(car -> car.getPrice() >= lowestPrice && car.getPrice() <= highestPrice));
        assertTrue(CarOpsDonato.filterByPrice(cars, lowestPrice, highestPrice).stream().allMatch(car -> car.getPrice() >= lowestPrice && car.getPrice() <= highestPrice));

    }


//    Map to Model Names: Create a list of car model names from the list of cars.

    @Test
    void mapToModelNames() {

        List<String> models = new ArrayList();
        Arrays.asList("Rogue", "Land Cruiser", "Golf", "Verona", "7 Series", "Taurus", "Elantra", "Town & Country", "Fiero", "9-5", "F150", "Express", "Passport", "Cooper Clubman", "Discovery", "M", "Bravada", "C70", "350Z", "Legend", "Park Avenue", "Forester", "F250", "Murciélago", "Mini", "Escort", "Grand Caravan", "Terraza", "X6", "Sixty Special", "5 Series", "Milan", "J", "Custom Cruiser", "Daewoo Magnus", "9-3", "Arnage", "Q7", "Lumina", "Maxima", "Focus", "2500", "Neon", "Daewoo Kalos", "Montero Sport", "Premier", "Econoline E250", "Century", "500SEL", "Villager", "Phantom", "S-Class", "Mazda5", "Sephia", "GT500", "Xterra", "M-Class", "Bronco II", "Avalon", "Durango", "1500", "323", "Regal", "Talon", "DTS", "Envoy", "Eclipse", "G", "Ridgeline", "Continental GT", "Suburban 1500", "Ram Wagon B150", "SLX", "Range Rover", "RAV4", "H3", "Accord", "M3", "Tacoma", "Corolla", "Optima", "Spectra", "Jetta", "Karif", "Galant", "A4", "Truck Xtracab SR5", "Alcyone SVX", "Sunfire", "D350", "Impala", "Hombre Space", "Freelander", "5000S", "Sienna", "Blackwood", "Compass", "Excel", "Club Wagon", "Corvette", "XT", "Passat", "Summit", "Grand Prix", "Tracer", "Ranger", "Quantum", "Challenger", "SL-Class", "LR3", "Grand Vitara", "MPV", "Skylark", "Titan", "Intrepid", "6 Series", "Ram Van 1500", "Transit Connect", "B-Series Plus", "A5", "Montana SV6", "Carens", "Tahoe", "Sportage", "S-Type", "Firebird", "Metro", "Somerset", "Sierra 2500", "Ram Van B250", "S4", "V70", "Cabriolet", "Cougar", "928", "Ram 3500", "Sedona", "Patriot", "Explorer", "Navajo", "300SL", "X5", "Ram", "Pajero", "XK Series", "STS", "T100", "Forte", "Sable", "Tracker", "XLR-V", "Wrangler", "Grand Cherokee", "Camaro", "4Runner", "LS", "Esprit", "3000GT", "Stealth", "Stratus", "Ram 2500", "E350", "Escalade EXT", "Spyder", "B2000", "900", "TrailBlazer", "CR-V", "Continental Flying Spur", "Express 1500", "B2500", "Cutlass Supreme", "Sonata", "Endeavor", "Phaeton", "525", "Breeze", "Relay", "Viper", "Probe", "RX-7", "Astro", "DeVille", "Sprinter", "Escalade", "Grand Marquis", "960", "Yukon", "LX", "Rodeo", "XC70", "Xtra", "Parisienne", "Riviera", "Ram 1500", "W201", "Aura", "Reatta", "Continental", "Azera", "Marauder", "Boxster", "Outlander", "Spider", "200", "E-Series", "X-90", "88", "Mazda3", "Equinox", "Ram Wagon B250", "xD", "Pilot", "SC", "F350", "LR2", "Amanti", "Dakota", "57", "Colorado", "XG300", "190E", "W126", "Town Car", "Sonoma Club Coupe", "Prius", "Suburban 2500", "Mountaineer", "Q5", "Sidekick", "3 Series", "Scirocco", "MR2", "Cayman", "Savana 2500", "Integra", "3500", "Elan", "Stylus", "XG350", "Expedition", "Enclave", "Topaz", "Corrado", "TundraMax", "Mighty Max Macro", "Achieva", "Range Rover Sport", "GTO", "MDX", "Fiesta", "Caliber", "FX", "CL-Class", "Rainier", "QX56", "430 Scuderia", "Type 2", "Equus", "300TE", "S70", "Acclaim", "Cherokee", "98", "Voyager", "Cobalt SS", "Mazda6", "Eos", "Swift", "Matrix", "911", "Ram Wagon B350", "Prelude", "Ram Van 3500", "i-MiEV", "Esprit Turbo", "Cayenne", "Sonoma", "Vitara", "Grand Voyager", "Mirage", "Express 3500", "Cavalier", "CTS-V", "Safari", "Sequoia", "Grand Am", "Gallardo", "62", "New Yorker", "Firebird Formula", "Hemisfear", "Aveo", "E-Class", "Liberty", "Pacifica", "Volt", "Sierra", "Cirrus", "Loyale", "tC", "Aries", "G-Series G30", "Montero", "Leganza", "C-MAX Hybrid", "Concorde", "Lancer Evolution", "Highlander", "Silverado 2500", "Laser", "M6", "CX-9", "500SEC", "ES", "Diamante", "600SEC", "Miata MX-5", "Rio", "Raider", "Mighty Max", "X3", "2e", "Malibu", "C-Class", "Discovery Series II", "SRX", "Sprinter 3500", "B-Series", "SLK-Class", "Impreza", "Fusion", "Q", "G-Series 1500");

        for(Car car : cars){
            if(!models.contains(car.getModel())){
                models.add(car.getModel());

            }
        }
        assertFalse(cars.stream().allMatch(x -> x.getClass().equals(String.class)));

        assertTrue(CarOpsDonato.mapToModelNames(cars).stream().allMatch(model -> model.getClass().equals(String.class)));

        assertEquals(CarOpsDonato.mapToModelNames(cars), models);
    }

    //    Map to Upper Case Makes: Create a list of car makes in uppercase from the list of cars.
    @Test
    void mapToUppercases() {
        List<String> makes = new ArrayList<>();
        Arrays.asList("NISSAN", "TOYOTA", "VOLKSWAGEN", "SUZUKI", "BMW", "FORD", "HYUNDAI", "CHRYSLER", "PONTIAC", "SAAB", "CHEVROLET", "HONDA", "MINI", "LAND ROVER", "OLDSMOBILE", "VOLVO", "ACURA", "BUICK", "SUBARU", "LAMBORGHINI", "AUSTIN", "DODGE", "CADILLAC", "MERCURY", "INFINITI", "BENTLEY", "AUDI", "MITSUBISHI", "EAGLE", "MERCEDES-BENZ", "ROLLS-ROYCE", "MAZDA", "KIA", "GMC", "HUMMER", "MASERATI", "ISUZU", "LINCOLN", "JEEP", "JAGUAR", "GEO", "PORSCHE", "LEXUS", "LOTUS", "PLYMOUTH", "SATURN", "ALFA ROMEO", "SCION", "MAYBACH", "FERRARI", "FOOSE", "DAEWOO", "APTERA"
        );
        for(Car car : cars){
            String make = car.getMake().toUpperCase();
            if(!makes.contains(make)){

               makes.add(make);
            }
        }
        assertFalse(cars.stream().allMatch(car->car.getClass().equals(String.class)));
        assertTrue(CarOpsDonato.mapToUppercases(cars).stream().allMatch(make->make.getClass().equals(String.class)));
        assertTrue(CarOpsDonato.mapToUppercases(cars).equals(makes));
    }
    //    Sort by Year: Sort the list of cars based on the year in ascending order.

    @Test
    void sortByYear() {
        double smallestYear = 1955;
        double biggestYear = 2013;
        ArrayList<Integer> yearsInAscendingOrder = new ArrayList();
        Arrays.asList(1955, 1963, 1964, 1966, 1968, 1969, 1970, 1971, 1973, 1974, 1981, 1981, 1984, 1984, 1984, 1984, 1985, 1985, 1985, 1985, 1985, 1986, 1986, 1986, 1986, 1986, 1987, 1987, 1987, 1987, 1987, 1987, 1987, 1987, 1987, 1987, 1987, 1988, 1988, 1988, 1988, 1988, 1988, 1989, 1989, 1989, 1989, 1989, 1989, 1990, 1990, 1990, 1990, 1990, 1991, 1991, 1991, 1991, 1991, 1991, 1991, 1991, 1991, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1992, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1993, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1994, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1995, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1996, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1997, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1998, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 1999, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2000, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2001, 2002, 2002, 2002, 2002, 2002, 2002, 2002, 2002, 2002, 2002, 2002, 2002, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2003, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2005, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2006, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2007, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2008, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2009, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2010, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2011, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2012, 2013, 2013, 2013
);
for(Car car :cars){
    yearsInAscendingOrder.add(car.getYear());
}
Collections.sort(yearsInAscendingOrder);
        assertFalse(cars.get(cars.size()-1).getYear()==biggestYear || cars.get(0).getYear()==smallestYear);
        List<Car> carsSortedByYear = CarOpsDonato.sortByYear(cars);
        assertTrue(carsSortedByYear.get(0).getYear()==smallestYear && carsSortedByYear.get(cars.size()-1).getYear()==biggestYear);
        assertEquals(cars.size(),carsSortedByYear.size());
        assertEquals(cars.size(), yearsInAscendingOrder.size());

    }

    //    Sort by Price (descending): Sort the list of cars based on the price in descending order.

    @Test
    void sortByPrice() {

        double lowestPrice = 20_055.27;
        double highestPrice = 239045.51;
        assertFalse(cars.get(0).getPrice()==highestPrice&&cars.get(cars.size()-1).getPrice()==lowestPrice);
        List<Car> carsSortedByPriceDesc = CarOpsDonato.sortByPrice(cars);

        assertTrue(carsSortedByPriceDesc.get(0).getPrice()==highestPrice&&carsSortedByPriceDesc.get(carsSortedByPriceDesc.size()-1).getPrice()==lowestPrice);

        assertTrue(cars.size()==carsSortedByPriceDesc.size());
        assertTrue(cars.size()==pricesInDescendingOrder.size());



    }

    @Test
    void getHighestPricedCar() {
        double highestPrice = 239045.51;
        Car highestPricedCar = CarOpsDonato.getHighestPricedCar(cars);
        assertTrue(highestPricedCar.getPrice()==highestPrice);
    }
//    Get the Lowest Priced Car: Find the car with the lowest price.

    @Test
    void getLowestPricedCar() {
        double lowestPrice = 20_055.27;
        Car lowestPricedCar = CarOpsDonato.getLowestPricedCar(cars);
        assertEquals(lowestPricedCar.getPrice(),lowestPrice);
    }
    //
//
//    Group by Make: Group the cars by their make.
    @Test
    void groupByMake() {
        Map<String, List<Car>> makeToCarsMap = CarOpsDonato.groupByMake(cars);
        makeToCarsMap.forEach((make, cars)->{
            assertTrue(cars.stream().allMatch(car->car.getMake().equals(make)));
        });
    }

    @Test
    void mapToCarMake() {
        ArrayList<String> makes = new ArrayList<>(Arrays.asList(
                "Nissan","Toyota","Volkswagen","Suzuki","BMW","Ford","Hyundai","Chrysler","Pontiac","Saab","Ford","Chevrolet","Honda","MINI","Land Rover","BMW","Oldsmobile","Volvo","Nissan","Acura","Buick","Subaru","Ford","Lamborghini","Austin","Ford","Dodge","Buick","BMW","Cadillac","BMW","Mercury","Infiniti","Ford","Oldsmobile","Suzuki","MINI","Saab","Bentley","Audi","Chevrolet","Nissan","Ford","Chevrolet","Dodge","Pontiac","Mitsubishi","Eagle","Ford","BMW","Buick","BMW","Mercedes-Benz","Mercury","Rolls-Royce","Mercedes-Benz","Mazda","Kia","Ford","Nissan","Volkswagen","Mercedes-Benz","BMW","Ford","Toyota","Dodge","GMC","Mazda","Buick","Eagle","Cadillac","GMC","Mitsubishi","Infiniti","Honda","Bentley","Chevrolet","Dodge","Acura","Land Rover","Toyota","Hummer","Honda","BMW","Toyota","Toyota","Kia","Kia","Volkswagen","BMW","Maserati","Mitsubishi","Audi","Toyota","Dodge","Subaru","Toyota","Pontiac","Dodge","Chevrolet","Toyota","Kia","Isuzu","Toyota","Land Rover","Audi","Ford","Kia","Toyota","Lincoln","Jeep","Hyundai","Ford","Chevrolet","Subaru","Volkswagen","Eagle","Pontiac","Mercury","Ford","Volkswagen","Mitsubishi","Mercedes-Benz","Land Rover","Hyundai","Suzuki","Mazda","Buick","Nissan","Dodge","BMW","Dodge","Pontiac","Ford","Ford","Mazda","Audi","Pontiac","Kia","Chevrolet","Kia","Chevrolet","Jaguar","Pontiac","Saab","Geo","Buick","Mitsubishi","GMC","Dodge","Audi","Volvo","Volkswagen","Mercury","Porsche","Dodge","Kia","Jeep","Ford","Mazda","Mercedes-Benz","BMW","BMW","Dodge","Mitsubishi","Jaguar","Toyota","Cadillac","Toyota","Kia","Mercury","Mercury","Chevrolet","Ford","Cadillac","Jeep","Subaru","Jeep","Ford","Chrysler","Chevrolet","Toyota","Lexus","Lotus","Mitsubishi","Dodge","Dodge","Dodge","Ford","Cadillac","Maserati","Mercury","Mazda","Saab","Volkswagen","Chevrolet","Honda","Dodge","MINI","Bentley","Chevrolet","Mazda","Oldsmobile","Honda","Hyundai","BMW","Mitsubishi","Volkswagen","BMW","Oldsmobile","Kia","Plymouth","Saturn","Dodge","Ford","Mazda","Chevrolet","Cadillac","Jeep","Dodge","Cadillac","Ford","Mercury","Jeep","Audi","Volkswagen","Volvo","Jeep","Chevrolet","GMC","Kia","Lexus","Isuzu","Volvo","Toyota","Pontiac","Buick","Dodge","Mercedes-Benz","Saturn","Buick","Toyota","Kia","Lincoln","Pontiac","Hyundai","Volvo","Mercury","Mercury","Subaru","Porsche","Mitsubishi","Kia","Alfa Romeo","Chrysler","Dodge","Chevrolet","Volkswagen","Chevrolet","Ford","Ford","Pontiac","BMW","Mazda","Ford","Volkswagen","Toyota","Suzuki","Oldsmobile","Mazda","Ford","Chevrolet","Dodge","Scion","Honda","Lotus","Lexus","Ford","Nissan","BMW","Land Rover","Kia","Mazda","Dodge","Toyota","BMW","Maybach","Hummer","Chevrolet","Porsche","Jeep","Hyundai","Mercedes-Benz","Mercedes-Benz","Chevrolet","Chevrolet","Mitsubishi","Mercedes-Benz","Lincoln","Mercury","GMC","Isuzu","Toyota","Chevrolet","Chrysler","Mercury","Audi","Suzuki","Honda","BMW","Volkswagen","Lincoln","Toyota","Toyota","Porsche","GMC","Acura","Ford","GMC","Lotus","Isuzu","Hyundai","Buick","Buick","Ford","Buick","Chevrolet","Mercury","Volkswagen","Mercury","Toyota","Mitsubishi","Oldsmobile","Pontiac","Chevrolet","Land Rover","Cadillac","Pontiac","Acura","Ford","Pontiac","Chevrolet","Dodge","Ford","Chevrolet","Oldsmobile","Ford","Dodge","Geo","Infiniti","Ford","Toyota","Chevrolet","Mercedes-Benz","Honda","Suzuki","Maybach","Buick","Infiniti","Ferrari","Volkswagen","Hyundai","Isuzu","Jeep","Mercedes-Benz","Volvo","Plymouth","Jeep","Chevrolet","Oldsmobile","Plymouth","Lexus","Bentley","Chevrolet","Mazda","Buick","Volkswagen","Suzuki","Toyota","Porsche","Dodge","Honda","Dodge","Mitsubishi","Toyota","Lotus","Mitsubishi","Porsche","GMC","Dodge","Suzuki","Plymouth","GMC","Dodge","BMW","Mitsubishi","Toyota","Chevrolet","Volvo","Chevrolet","Cadillac","Pontiac","Toyota","Pontiac","Mazda","GMC","Lamborghini","Maybach","Lotus","Ford","Plymouth","Chrysler","Pontiac","Foose","Chevrolet","Geo","Mercedes-Benz","Land Rover","Isuzu","Ford","Jeep","Mitsubishi","Nissan","Chrysler","Chevrolet","Mercury","GMC","Chrysler","Subaru","Scion","Mazda","Dodge","Chevrolet","Mitsubishi","Mitsubishi","Daewoo","Ford","Chrysler","Mazda","Ford","Mitsubishi","Pontiac","Toyota","Chevrolet","Ford","BMW","Mazda","Mercedes-Benz","Scion","Lexus","Mitsubishi","Audi","Mitsubishi","Mercedes-Benz","Mazda","Toyota","Volkswagen","Chevrolet","Kia","Kia","Mitsubishi","Mitsubishi","Mitsubishi","BMW","Volkswagen","Aptera","Chevrolet","Ford","Mercedes-Benz","Land Rover","Toyota","Cadillac","Toyota","Saab","Chrysler","Chevrolet","Mercedes-Benz","Buick","Mazda","Pontiac","Mercedes-Benz","Hyundai","BMW","Infiniti","GMC","Saab","Mercury","Subaru","Porsche","Mazda","Chevrolet","Ford","Infiniti","Chevrolet","Eagle","Honda","GMC","Mitsubishi","Jaguar","Chevrolet"

        ));
        ArrayList<String> makes2 = new ArrayList<>();
        for(Car car : cars){
             makes2.add(car.getMake());
        }
        Collections.sort(makes);
        Collections.sort(makes2);
        ArrayList<String> makes3 = new ArrayList(CarOpsDonato.mapToCarMake(cars));
        Collections.sort(makes3);
        assertTrue(makes.equals(makes2));
        assertTrue(makes2.equals(makes3));
        assertTrue(makes.equals(makes3));

    }
    //
//    Count Cars by Make: Count the number of cars for each make.
//
    @Test
    void countCarsByMake() {
        Map<String, List<Car>> makeToCarMap = CarOpsDonato.groupByMake(cars);
        Map<String, Long> numberOfCarsPerMake = CarOpsDonato.countCarsByMake(cars);


        makeToCarMap.forEach((make, carz)->{
          assertEquals(numberOfCarsPerMake.get(make),carz.size());
        });

    }
    //    Average Price: Calculate the average price of all cars.
//
    @Test
    void averagePrice() {

        double averagePrice = 0;
        for(double price : pricesInDescendingOrder){
            averagePrice+=price;
        }
        averagePrice/=pricesInDescendingOrder.size();
        assertEquals(Math.round(CarOpsDonato.averagePrice(cars)),Math.round(averagePrice));

    }
    //    Sum of Prices: Calculate the sum of all car prices.
//
    @Test
    void sumOfPrices() {
        double sum = 0;
        for(double price : pricesInDescendingOrder){
            sum+=price;
        }
        assertEquals(Math.round(sum), Math.round(CarOpsDonato.sumOfPrices(cars)));
    }
    //    Any Car with Blue Color: Check if there's any car with a blue color.
//
    @Test
    void anyCarWithBlueColor() {
        boolean thereIsBlueCar = CarOpsDonato.anyCarWithBlueColor(cars);
        assertTrue(thereIsBlueCar);

    }
    //    All Cars are Expensive: Check if all cars are expensive (e.g.","price > 50000).
    @Test
    void allCarsAreExpensive() {
        assertFalse(CarOpsDonato.allCarsAreExpensive(cars));
    }

//    None Match the Condition: Check if none of the cars match a specific condition.
    @Test
    void noneMatchTheCondition() {
        assertTrue(CarOpsDonato.noneMatchTheCondition(cars, x->x.getPrice()>300_000));
    }

//    Skip First N Cars: Skip the first N cars from the list.

    @Test
    void skipTheFirstNCars() {
        int N = 50;
        List<Car> firstNCars = new ArrayList<>();
        List<Car> restOfCars = new ArrayList<>();
        for(int i = 0;i<cars.size();i++){
            if(i<N)
            firstNCars.add(cars.get(i));
            else
                restOfCars.add(cars.get(i));
        }
        List<Car> carsSkipFirstN = CarOpsDonato.skipTheFirstNCars(cars,N);
        assertEquals(restOfCars,carsSkipFirstN);
        firstNCars.forEach(car->{
           assertFalse(carsSkipFirstN.contains(car));
        });
    }
    //    Limit to N Cars: Limit the list to the first N cars.
//
    @Test
    void limitToNCars() {
        int N = 50;
        List<Car> firstNCars = new ArrayList<>();
        for(int i = 0;i<N;i++){
            firstNCars.add(cars.get(i));
        }

        List<Car> carsLimitToN = CarOpsDonato.limitToNCars(cars, N);
        assertEquals(firstNCars, carsLimitToN);
    }
    //    Distinct Colors: Get a list of distinct car colors.
//
    @Test
    void distinctColors() {
        List<String> distinctColors = new ArrayList<>(
                Arrays.asList("Green","Crimson","Aquamarine","Orange","Blue","Indigo","Yellow","Puce","Pink","Turquoise","Purple","Maroon","Teal","Fuscia","Red","Mauv","Khaki","Violet","Goldenrod"
                )
        );
        List<String>colorsDistinct = new ArrayList(CarOpsDonato.distinctColors(cars));
        Collections.sort(distinctColors);
        Collections.sort(colorsDistinct);
        assertEquals(distinctColors, colorsDistinct);

        Set<String> distinctColorz = new HashSet(cars.stream().map(x->x.getColor()).collect(Collectors.toSet()));
        distinctColors= new ArrayList<>(distinctColorz);
        Collections.sort(distinctColors);

        assertEquals(colorsDistinct,distinctColors);

    }
//    Concatenate Make and Model: Concatenate the make and model of each car.

    @Test
    void concatenateMakeAndModel() {
List<String> makesAndModelsConcatenated= new ArrayList<>(Arrays.asList("Nissan Rogue","Toyota Land Cruiser","Volkswagen Golf","Suzuki Verona","BMW 7 Series","Ford Taurus","Hyundai Elantra","Chrysler Town & Country","Pontiac Fiero","Saab 9-5","Ford F150","Chevrolet Express","Honda Passport","MINI Cooper Clubman","Land Rover Discovery","BMW M","Oldsmobile Bravada","Volvo C70","Nissan 350Z","Acura Legend","Buick Park Avenue","Subaru Forester","Ford F250","Lamborghini Murciélago","Austin Mini","Ford Escort","Dodge Grand Caravan","Buick Terraza","BMW X6","Cadillac Sixty Special","BMW 5 Series","Mercury Milan","Infiniti J","Oldsmobile Custom Cruiser","Suzuki Daewoo Magnus","Saab 9-3","Bentley Arnage","Audi Q7","Chevrolet Lumina","Nissan Maxima","Ford Focus","Chevrolet 2500","Dodge Neon","Pontiac Daewoo Kalos","Mitsubishi Montero Sport","Eagle Premier","Ford Econoline E250","Buick Century","Mercedes-Benz 500SEL","Mercury Villager","Rolls-Royce Phantom","Mercedes-Benz S-Class","Mazda Mazda5","Kia Sephia","Ford GT500","Nissan Xterra","Mercedes-Benz M-Class","Ford Bronco II","Toyota Avalon","Dodge Durango","GMC 1500","Mazda 323","Buick Regal","Eagle Talon","Cadillac DTS","GMC Envoy","Mitsubishi Eclipse","Infiniti G","Honda Ridgeline","Bentley Continental GT","Chevrolet Suburban 1500","Dodge Ram Wagon B150","Acura SLX","Land Rover Range Rover","Toyota RAV4","Hummer H3","Honda Accord","BMW M3","Toyota Tacoma","Toyota Corolla","Kia Optima","Kia Spectra","Volkswagen Jetta","Maserati Karif","Mitsubishi Galant","Audi A4","Toyota Truck Xtracab SR5","Subaru Alcyone SVX","Pontiac Sunfire","Dodge D350","Chevrolet Impala","Isuzu Hombre Space","Land Rover Freelander","Audi 5000S","Toyota Sienna","Lincoln Blackwood","Jeep Compass","Hyundai Excel","Ford Club Wagon","Chevrolet Corvette","Subaru XT","Volkswagen Passat","Eagle Summit","Pontiac Grand Prix","Mercury Tracer","Ford Ranger","Volkswagen Quantum","Mitsubishi Challenger","Mercedes-Benz SL-Class","Land Rover LR3","Suzuki Grand Vitara","Mazda MPV","Buick Skylark","Nissan Titan","Dodge Intrepid","BMW 6 Series","Dodge Ram Van 1500","Ford Transit Connect","Mazda B-Series Plus","Audi A5","Pontiac Montana SV6","Kia Carens","Chevrolet Tahoe","Kia Sportage","Jaguar S-Type","Pontiac Firebird","Geo Metro","Buick Somerset","GMC Sierra 2500","Dodge Ram Van B250","Audi S4","Volvo V70","Volkswagen Cabriolet","Mercury Cougar","Porsche 928","Dodge Ram 3500","Kia Sedona","Jeep Patriot","Ford Explorer","Mazda Navajo","Mercedes-Benz 300SL","BMW X5","Dodge Ram","Mitsubishi Pajero","Jaguar XK Series","Cadillac STS","Toyota T100","Kia Forte","Mercury Sable","Chevrolet Tracker","Cadillac XLR-V","Jeep Wrangler","Jeep Grand Cherokee","Chevrolet Camaro","Toyota 4Runner","Lexus LS","Lotus Esprit","Mitsubishi 3000GT","Dodge Stealth","Dodge Stratus","Dodge Ram 2500","Ford E350","Cadillac Escalade EXT","Maserati Spyder","Mazda B2000","Saab 900","Chevrolet TrailBlazer","Honda CR-V","Bentley Continental Flying Spur","Chevrolet Express 1500","Mazda B2500","Oldsmobile Cutlass Supreme","Hyundai Sonata","Mitsubishi Endeavor","Volkswagen Phaeton","BMW 525","Plymouth Breeze","Saturn Relay","Dodge Viper","Ford Probe","Mazda RX-7","Chevrolet Astro","Cadillac DeVille","Dodge Sprinter","Cadillac Escalade","Mercury Grand Marquis","Volvo 960","GMC Yukon","Lexus LX","Isuzu Rodeo","Volvo XC70","Toyota Xtra","Pontiac Parisienne","Buick Riviera","Dodge Ram 1500","Mercedes-Benz W201","Saturn Aura","Buick Reatta","Lincoln Continental","Hyundai Azera","Mercury Marauder","Porsche Boxster","Mitsubishi Outlander","Alfa Romeo Spider","Chrysler 200","Ford E-Series","Suzuki X-90","Oldsmobile 88","Mazda Mazda3","Chevrolet Equinox","Dodge Ram Wagon B250","Scion xD","Honda Pilot","Lexus SC","Ford F350","Land Rover LR2","Kia Amanti","Dodge Dakota","Maybach 57","Chevrolet Colorado","Hyundai XG300","Mercedes-Benz 190E","Mercedes-Benz W126","Lincoln Town Car","GMC Sonoma Club Coupe","Toyota Prius","Chevrolet Suburban 2500","Mercury Mountaineer","Audi Q5","Suzuki Sidekick","BMW 3 Series","Volkswagen Scirocco","Toyota MR2","Porsche Cayman","GMC Savana 2500","Acura Integra","GMC 3500","Lotus Elan","Isuzu Stylus","Hyundai XG350","Ford Expedition","Buick Enclave","Mercury Topaz","Volkswagen Corrado","Toyota TundraMax","Mitsubishi Mighty Max Macro","Oldsmobile Achieva","Chevrolet Metro","Land Rover Range Rover Sport","Pontiac GTO","Acura MDX","Ford Fiesta","Dodge Caliber","Geo Tracker","Infiniti FX","Mercedes-Benz CL-Class","Buick Rainier","Infiniti QX56","Ferrari 430 Scuderia","Volkswagen Type 2","Hyundai Equus","Mercedes-Benz 300TE","Volvo S70","Plymouth Acclaim","Jeep Cherokee","Oldsmobile 98","Plymouth Voyager","Chevrolet Cobalt SS","Mazda Mazda6","Volkswagen Eos","Suzuki Swift","Toyota Matrix","Porsche 911","Dodge Ram Wagon B350","Honda Prelude","Dodge Ram Van 3500","Mitsubishi i-MiEV","Lotus Esprit Turbo","Porsche Cayenne","GMC Sonoma","Suzuki Vitara","Plymouth Grand Voyager","Mitsubishi Mirage","Chevrolet Express 3500","Chevrolet Cavalier","Cadillac CTS-V","Pontiac Safari","Toyota Sequoia","Pontiac Grand Am","GMC Safari","Lamborghini Gallardo","Maybach 62","Plymouth Neon","Chrysler New Yorker","Pontiac Firebird Formula","Foose Hemisfear","Chevrolet Aveo","Mercedes-Benz E-Class","Jeep Liberty","Chrysler Pacifica","Chevrolet Volt","GMC Sierra","Chrysler Cirrus","Subaru Loyale","Scion tC","Dodge Aries","Chevrolet G-Series G30","Mitsubishi Montero","Daewoo Leganza","Ford C-MAX Hybrid","Chrysler Concorde","Mitsubishi Lancer Evolution","Toyota Highlander","Chevrolet Silverado 2500","Ford Laser","BMW M6","Mazda CX-9","Mercedes-Benz 500SEC","Lexus ES","Mitsubishi Diamante","Mercedes-Benz 600SEC","Mazda Miata MX-5","Kia Rio","Mitsubishi Raider","Mitsubishi Mighty Max","BMW X3","Aptera 2e","Chevrolet Malibu","Mercedes-Benz C-Class","Land Rover Discovery Series II","Cadillac SRX","Mercedes-Benz Sprinter 3500","Mazda B-Series","Mercedes-Benz SLK-Class","Subaru Impreza","Ford Fusion","Infiniti Q","Chevrolet G-Series 1500","Chevrolet 1500"));

        assertEquals(CarOpsDonato.concatenateMakeAndModel(cars),makesAndModelsConcatenated);
    }
}














//
//    Find First Car: Find the first car in the list.
//
//    Find Any Car: Find any car in the list.
//
//    Remove Duplicates: Remove duplicate cars from the list based on make and model.
//
//    Partition Cars by Price: Partition the cars into two groups based on whether their price is above a certain value.
//
//    Calculate Total Price by Make: Calculate the total price of cars for each make.
//
//    Join Car Names into a String: Join the names of all cars into a single comma-separated string.
//
//    Peek and Print: Use peek to print the details of each car in the stream.
//
//    Average Price by Make: Calculate the average price of cars for each make.
//
//    Concatenate All Car Details: Concatenate all car details into a single string.
//
//    Find the Newest Car: Find the newest (latest year) car in the list.