package vladproduction.com.process;



import vladproduction.com.Car;
import vladproduction.com.DataProcess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStream2 implements DataProcess {

    File file = new File("src/main/java/vladproduction/com/carList.txt");

    @Override
    public void save(List<Car> carList) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             DataOutputStream outPut = new DataOutputStream(fileOutputStream)) {
            outPut.writeInt(carList.size());
            for (int i = 0; i < carList.size(); i++) {
                Car car = carList.get(i);
                outPut.writeUTF(car.getModel());
                outPut.writeInt(Integer.parseInt(car.getPrice()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> load() {
        System.out.println("\t///DataStream DataProcess///");
        List<Car> list = new ArrayList();
        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream inPut = new DataInputStream(fileInputStream)) {
            int size = inPut.readInt();
            for (int i = 0; i < size; i++) {
                String model = inPut.readUTF();
                int price = inPut.readInt();
                Car car = new Car();
                car.setModel(model);
                car.setPrice(price);
                list.add(car);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
