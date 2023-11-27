package vladproduction.com.football_team;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    //File
    //DataOutputStream - write
    //DataInputStream - read
    File file = new File(
            "src/main/java/vladproduction/com/football_team/Inter.txt");

    public void write(List<Inter> squadList) throws Exception{

        System.out.println("write method from dataHelper work");
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            DataOutputStream out = new DataOutputStream(fileOutputStream)){
            out.writeInt(squadList.size());
            for(int i=0;i<squadList.size();i++){
                Inter player = squadList.get(i);
                out.writeUTF(player.name);
                out.writeInt(player.number);
            }
        }

    }

    public List<Inter> read()throws Exception{

        System.out.println("read method from dataHelper work");
        List<Inter> squadList = new ArrayList();

        try(FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fileInputStream)){
            int size = in.readInt();
            for (int i=0;i<size;i++){
                String namePlayer = in.readUTF();
                int numberPlayer = in.readInt();
                Inter player = new Inter();
                player.name=namePlayer;
                player.number=numberPlayer;
                squadList.add(player);
            }
            return squadList;
        }
    }
}
