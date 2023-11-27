package vladproduction.com.process;


import vladproduction.com.DataProcess;

public class Factory {

    public static DataProcess getTypeIOData(int dataType) {

        DataProcess x = null;
        if (dataType == 1) {
            x = new Properties1();
        }
        if (dataType == 2) {
            x = new DataStream2();
        }
        if (dataType == 3) {
            x = new ObjectStream3();
        }
        return x;
    }
}
