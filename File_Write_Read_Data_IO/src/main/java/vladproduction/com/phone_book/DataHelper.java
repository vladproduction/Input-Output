package vladproduction.com.phone_book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    //File
    //DataOutputStream - write
    //DataInputStream - read
    File file = new File(
            "src/main/java/vladproduction/com/phone_book/PhoneList.txt");

    public void write(List<Phone> phoneList) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             DataOutputStream out = new DataOutputStream(fileOutputStream)) {
            out.writeInt(phoneList.size());
            for (int i = 0; i < phoneList.size(); i++) {
                Phone item = phoneList.get(i);
                out.writeUTF(item.model);
                out.writeInt(item.price);

            }
        }
    }

    public List<Phone> read() throws Exception {
        List<Phone> list = new ArrayList();
        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream inputStream = new DataInputStream(fileInputStream)) {
            int sizeList = inputStream.readInt();
            for (int i = 0; i < sizeList; i++) {
                String modelFile = inputStream.readUTF();
                int priceFile = inputStream.readInt();
                Phone phone = new Phone();
                phone.model = modelFile;
                phone.price = priceFile;
                list.add(phone);
            }
            return list;
        }
    }
}
