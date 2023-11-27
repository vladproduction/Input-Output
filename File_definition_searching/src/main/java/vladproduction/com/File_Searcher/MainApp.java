package vladproduction.com.File_Searcher;

import java.io.File;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        String directory  = "*:\\***\\directory";
        String searchCriteria = ".*";
        Searcher_File searcherFile = new Searcher_File();
        List<File> files = searcherFile.searchFiles(directory,searchCriteria);
        for (File item : files) {
            System.out.println(item);
        }
        System.out.println("list size: "+files.size());
    }
}
