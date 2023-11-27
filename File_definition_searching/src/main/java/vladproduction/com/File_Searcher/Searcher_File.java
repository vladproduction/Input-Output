package vladproduction.com.File_Searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Searcher_File {
    public List<File> searchFiles(String directory, String searchCriteria) {
        List<File> resultList = new ArrayList<File>();
        File file = new File(directory);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File items : files) {
                String itemName = items.getName();
                if (itemName.endsWith(searchCriteria)) {
                    resultList.add(items);
                }
            }
        }
        return resultList;
    }
}
