package pl.michaeli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    final static String fileName = "test_input.txt";

    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        int result = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String textLine = bufferedReader.readLine();
            do {
                input.add(textLine);
                textLine = bufferedReader.readLine();
            } while(textLine != null);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String x: input){
            String[] dimensions = x.split("x");
            int a = Integer.parseInt(dimensions[0]);
            int b = Integer.parseInt(dimensions[1]);
            int c = Integer.parseInt(dimensions[2]);
            int field1 = a*b;
            int field2 = b*c;
            int field3 = a*c;
            result += 2 * (field1 + field2 + field3) + Math.min(Math.min(field1, field2), field3);
        }
        System.out.println(result);
    }

}
