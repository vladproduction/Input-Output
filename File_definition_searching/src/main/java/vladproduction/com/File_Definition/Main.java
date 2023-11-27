package vladproduction.com.File_Definition;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        File file = new File("*:\\***\\file.*");
        System.out.println(file);

        boolean exists = file.exists();
        System.out.println("exists="+exists);

        String parent = file.getParent();
        System.out.println("parent="+parent);

        System.out.println("-----------file last modified-------------------");
        long lastModified = file.lastModified();
        System.out.println("lastModified as long =" + lastModified);
        System.out.println("lastModified=" + new Date(lastModified));

        System.out.println("-----------date examples-------------------");
        Date currentDate = new Date();
        System.out.println("currentDate="+currentDate);
        long currentMilliseconds = currentDate.getTime();
        System.out.println("currentMilliseconds="+currentMilliseconds);

        long time = currentDate.getTime();
        System.out.println("currentTime="+time);

        System.out.println("--------------------------------------------");
        String name = file.getName();
        System.out.println("name="+name);
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath="+absolutePath);

    }
}
