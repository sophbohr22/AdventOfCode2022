package DayOne;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

// Find the top 3 elves carrying the most calories.
// How many total Calories are the elves carrying?
public class DayOne {
  public static void main(String[] args) throws Exception {
    // Example input format:
    // 1000
    // 2000
    // 3000
    //
    // 4000
    //
    // 5000
    // 6000
    File file = new File("DayOne/day-one-input.txt");
    Scanner sc = new Scanner(file);
    
    int[] top = {0, 0, 0};
    int cur_cals = 0;
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      // If this line is empty there are no more calories to count for this elf.
      if(line.isEmpty()) {
        if (cur_cals > top[0]) {
          top[0] = cur_cals;
          Arrays.sort(top);
          System.out.println(top[0] + " " + top[1] + " " + top[2]);
        }
        // Reset the calorie count before moving onto the next elf.
        cur_cals = 0;
        continue;
      }
      cur_cals += Integer.parseInt(line);
    }
    int most_cals = IntStream.of(top).sum();
    System.out.println("Highest amount of calories: " + most_cals);
    sc.close();
  }
}