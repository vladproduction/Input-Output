package vladproduction.com.autosalon;

import java.io.*;
import java.util.List;

public class DataHelper {

    //File
    //ObjectOutputStream - write
    //ObjectInputStream - read
    public void write(Car car, File file){
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)) {
            out.writeObject(car);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Car read(File file){
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileInputStream)){
            return (Car) in.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void writeCarList(List<Car> cars, File file){
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ){
            out.writeObject(cars);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public List<Car> readCarList(File file){
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileInputStream)){
            return (List<Car>) in.readObject();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
