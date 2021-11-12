package Mission_3;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

    public static void updateDataSet(String Dir, String userId, boolean update, ArrayList<String> dataSet) {
        File f = new File(Dir + userId);
        try {
            FileWriter fw = new FileWriter(f, update);
            for (String data : dataSet) {
                fw.write(data + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> openDataSet(String Dir, String userId) {
        ArrayList<String> dataSet = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(Dir + userId));
            while (true) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (line == null) break;
                dataSet.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataSet;
    }
}
