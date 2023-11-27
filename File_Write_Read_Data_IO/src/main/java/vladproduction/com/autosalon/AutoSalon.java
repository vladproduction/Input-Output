package vladproduction.com.autosalon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AutoSalon implements Serializable {

    public List<Car> carList = new ArrayList<>();
    public String autoSalonName;

    public Car toStringList(List<Car> carList){
        Car item = null;
        System.out.println(autoSalonName+":");
        for (int i = 0; i<carList.size(); i++){
            item = carList.get(i);
            System.out.println(i+1+") "+item.name+"; "+item.price);
        }
        return item;
    }

    @Override
    public String toString() {
        return autoSalonName+":"+ "\n"
                +"\t"+carList;
    }
}
