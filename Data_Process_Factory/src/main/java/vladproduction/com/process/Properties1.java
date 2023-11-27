package vladproduction.com.process;



import vladproduction.com.Car;
import vladproduction.com.DataProcess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Properties1 implements DataProcess {

    File file = new File("src/main/java/vladproduction/com/carList.txt");

    @Override
    public void save(List<Car> carList) {
        Properties carProp = new Properties();
        int size = carList.size();
        carProp.setProperty("keyProperties",""+size);
        try (FileOutputStream out = new FileOutputStream(file)){
            for (int i = 0; i < size; i++) {
                Car car = carList.get(i);
                carProp.setProperty("Model: "+i,car.getModel());
                carProp.setProperty("Price: "+i,car.getPrice());
            }
            carProp.store(out,"carList_prop");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> load() {
        System.out.println("\t///Properties DataProcess///");
        List<Car> carList = new ArrayList();
        Properties carProp = new Properties();
        try(FileInputStream inPut = new FileInputStream(file)){
            carProp.load(inPut);
            String value = carProp.getProperty("keyProperties","0");
            int size = Integer.parseInt(value);
            for(int i = 0; i<size; i++){
                String model = carProp.getProperty("Model: "+i);
                String price = carProp.getProperty("Price: "+i);
                Car car = new Car();
                car.setModel(model);
                car.setPrice(Integer.parseInt(price));
                carList.add(car);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return carList;
    }
}
