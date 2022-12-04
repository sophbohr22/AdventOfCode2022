package Day4;

import java.io.File;
import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) throws Exception {
        File file = new File("Day4/day-four-input.txt");
        Scanner sc = new Scanner(file);

        int count = 0;
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          String[] ranges = line.split(",");
          // ranges = ["x-y", "a-b"]
          // if x <= b && a <= y
          String[] first = ranges[0].split("-");
          String[] second = ranges[1].split("-");

          if ((Integer.parseInt(first[0]) <= Integer.parseInt(second[1])
          && Integer.parseInt(second[0]) <= Integer.parseInt(first[1]))) {
            count++;
          }
        }
        System.out.println("Count: " + count);
        sc.close();
    }
}
