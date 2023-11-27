package vladproduction.com.File_Definition;

import java.io.File;

public class Main02 {
    public static void main(String[] args) {
        File file = new File("*:\\***\\directory");
        System.out.println(file);
        boolean exists = file.exists();
        System.out.println("exists=" + exists);
        String parent = file.getParent();
        System.out.println("parent=" + parent);
        String name = file.getName();
        System.out.println("name=" + name);
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath=" + absolutePath);
        System.out.println("--------check is dir------------");
        boolean isDirectory = file.isDirectory();
        System.out.println("isDirectory=" + isDirectory);
        System.out.println("--------look inside dir------------");
        File[] files = file.listFiles();
        assert files != null;
        System.out.println("files.length (count files)=" + files.length);
        for (int i = 0; i < files.length; i++) {
            File item = files[i];
            System.out.println(i+1 + " = " + item.getName());
        }
    }
}
