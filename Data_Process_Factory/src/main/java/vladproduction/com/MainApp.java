package vladproduction.com;



import vladproduction.com.process.Factory;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        DataProcess dataProcess = Factory.getTypeIOData(3);
        Car car1 = new Car("bmw",1000);
        Car car2 = new Car("mercedes",2000);
        Car car3 = new Car("audi",3000);
        Car car4 = new Car("toyota",4000);
        Car car5 = new Car("volkswagen",5000);

        List<Car> list = new ArrayList();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);

        dataProcess.save(list);
        List<Car> filePrint = dataProcess.load();
        System.out.println(filePrint);

    }
}
