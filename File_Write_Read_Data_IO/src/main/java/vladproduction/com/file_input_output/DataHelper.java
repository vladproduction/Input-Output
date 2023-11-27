package vladproduction.com.file_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataHelper {
    public File file = new File("src/main/java/vladproduction/com/file_input_output/File.txt");
    //out - write
    //in - read

    //with {finally block}; not autocloseable
    public void writeData(String text){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            byte [] content = text.getBytes();
            out.write(content);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (out!=null){
                    out.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    //autocloseable; no need {finally block};
    public void write(String text){
        try(FileOutputStream out = new FileOutputStream(file)){
            byte [] content = text.getBytes();
            out.write(content);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String read(){

        try(FileInputStream in = new FileInputStream(file)){
            int size = in.available();
            byte [] content = new byte[size];
            in.read(content);
            String text = new String(content);
            return text;

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
