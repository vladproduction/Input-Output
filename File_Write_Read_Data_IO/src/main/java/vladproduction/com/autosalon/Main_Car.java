package vladproduction.com.autosalon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main_Car {

    public static void main(String[] args) {
        Car car = new Car();
        car.name = "Volvo";
        car.price = 1000;
        System.out.println("toString: "+car);
        DataHelper dataHelper = new DataHelper();
        File file = new File("src/main/java/com/app/Data_Input_Output/cars_example/Car_file.txt");
        dataHelper.write(car,file);
        Car carInfo = dataHelper.read(file);
        System.out.println("read(file): "+carInfo);

        Car car2 = new Car();
        car2.name = "Toyota";
        car2.price = 2000;
        System.out.println("toString: "+car2);
        dataHelper.write(car2,file);
        carInfo = dataHelper.read(file);
        System.out.println("read(file): "+carInfo);

        System.out.println("working with List<Car> cars: ");
        List<Car> list = new ArrayList();
        list.add(car);
        list.add(car2);
        File carListFile = new File("src/main/java/com/app/Data_Input_Output/cars_example/CarList_file.txt");
        dataHelper.writeCarList(list,carListFile);
        List<Car> carListInfo = dataHelper.readCarList(carListFile);
        System.out.println(carListInfo);
    }
}
