package vladproduction.com.football_team;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

            List<Inter> squadList = new ArrayList<>();

            Inter player1 = new Inter();
            Inter player2 = new Inter();
            Inter player3 = new Inter();
            Inter player4 = new Inter();
            Inter player5 = new Inter();
            Inter player6 = new Inter();
            Inter player7 = new Inter();
            Inter player8 = new Inter();

            player1.name="Chalhanoglu";
            player1.number=10;
            player2.name="Mkhitarian";
            player2.number=22;
            player3.name="Handanovich";
            player3.number=1;
            player4.name="Dzeco";
            player4.number=9;
            player5.name="Martinez";
            player5.number=11;
            player6.name="Brozovich";
            player6.number=37;
            player7.name="Barella";
            player7.number=23;
            player8.name="Bastoni";
            player8.number=45;

            squadList.add(player1);
            squadList.add(player2);
            squadList.add(player3);
            squadList.add(player4);
            squadList.add(player5);
            squadList.add(player6);
            squadList.add(player7);
            squadList.add(player8);

            DataHelper dataHelper = new DataHelper();
            try {
                    dataHelper.write(squadList);
                    List<Inter> squadListFromFile = dataHelper.read();

                    System.out.println(squadListFromFile);

            }
            catch (Exception e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
            }

    }
}
