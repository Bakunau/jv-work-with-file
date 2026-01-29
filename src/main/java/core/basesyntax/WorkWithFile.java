package core.basesyntax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFile {
    public void getStatistic(String fromFileName, String toFileName) {
        int supplySum = 0;
        int buySum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fromFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0].trim();
                int value = Integer.parseInt(data[1].trim());

                if (type.equals("supply")) {
                    supplySum += value;
                } else if (type.equals("buy")) {
                    buySum += value;
                }
            }
        } catch (IOException e) {
            System.out.println("Error in reading file " + fromFileName);
            return;
        }

        int result = supplySum - buySum;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(toFileName))) {
            bw.write("supply," + supplySum);
            bw.newLine();
            bw.write("buy," + buySum);
            bw.newLine();
            bw.write("result," + result);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error in writing to file " + toFileName);
        }
    }
}


