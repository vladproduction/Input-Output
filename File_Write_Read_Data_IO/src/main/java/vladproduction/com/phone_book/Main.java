package vladproduction.com.phone_book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        phone1.model="model1";
        phone1.price=1;
        Phone phone2 = new Phone();
        phone2.model="model2";
        phone2.price=2;
        Phone phone3 = new Phone();
        phone3.model="model3";
        phone3.price=3;

        List<Phone> phoneList = new ArrayList();
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);
        System.out.println(phoneList.size());
        System.out.println("toString: "+phoneList);

        DataHelper dataHelper = new DataHelper();
        try {
            dataHelper.write(phoneList);
            List<Phone> list = dataHelper.read();
            System.out.println(list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
