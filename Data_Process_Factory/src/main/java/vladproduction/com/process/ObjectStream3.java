package vladproduction.com.process;



import vladproduction.com.Car;
import vladproduction.com.DataProcess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStream3 implements DataProcess {

    File file = new File("src/main/java/vladproduction/com/carList.txt");

    @Override
    public void save(List<Car> carList) {
        List<Car> cars = new ArrayList();
        cars.addAll(carList);
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outPut = new ObjectOutputStream(fileOutputStream)){
            outPut.writeObject(cars);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> load() {
        System.out.println("\t///ObjectStream DataProcess///");
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inPut = new ObjectInputStream(fileInputStream)){
            Object result = inPut.readObject();
            List<Car> cars = (List<Car>) result;
            return cars;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
