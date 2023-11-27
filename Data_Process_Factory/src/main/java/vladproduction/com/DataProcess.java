package vladproduction.com;

import java.util.List;

public interface DataProcess {

    void save(List<Car> carList);

    List<Car> load();


}
