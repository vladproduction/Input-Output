package vladproduction.com.autosalon;

import java.io.File;
import java.util.ArrayList;

public class Main_AutoSalon {
    public static void main(String[] args) {

        AutoSalon autoSalon = new AutoSalon();
        autoSalon.autoSalonName = "Auto-Salon";
        autoSalon.carList = new ArrayList();

        Car bmw = new Car();
        bmw.name="bmw";
        bmw.price=1000;
        autoSalon.carList.add(bmw);

        Car audi = new Car();
        audi.name="audi";
        audi.price=2000;
        autoSalon.carList.add(audi);

        Car volvo = new Car();
        volvo.name="volvo";
        volvo.price=3000;
        autoSalon.carList.add(volvo);

        System.out.println("toString"+autoSalon);
        System.out.println("toStringList-->");
        autoSalon.toStringList(autoSalon.carList);

        DataHelperAutoSalon dataHelperAutoSalon = new DataHelperAutoSalon();
        File autoSalonFile = new File(
                "src/main/java/vladproduction/com/autosalon/cars_example/AutoSalon_file.txt");
        dataHelperAutoSalon.writeAutoSalon(autoSalon,autoSalonFile);
        AutoSalon readAutoSalon = dataHelperAutoSalon.readAutoSalon(autoSalonFile);
        System.out.println(".readAutoSalon(autoSalonFile): "+readAutoSalon);
        System.out.println("--------");
        System.out.println(readAutoSalon.autoSalonName);
        System.out.println(readAutoSalon.carList);

    }
}
