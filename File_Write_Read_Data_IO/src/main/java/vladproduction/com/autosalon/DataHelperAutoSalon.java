package vladproduction.com.autosalon;

import java.io.*;

public class DataHelperAutoSalon {

    public void writeAutoSalon(AutoSalon autoSalon, File file){
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)){

            out.writeObject(autoSalon);

        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public AutoSalon readAutoSalon(File file){
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileInputStream)){

            return (AutoSalon) in.readObject();

        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
