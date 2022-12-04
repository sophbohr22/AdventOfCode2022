package Day3;
import java.io.File;
import java.util.Scanner;

public class DayThree {
    public static void main(String[] args) throws Exception {
        File file = new File("Day3/day-three-input.txt");
        Scanner sc = new Scanner(file);
        int priority_item_sum = 0;
        while (sc.hasNextLine()) {
            String elf_a = sc.nextLine();
            String elf_b = sc.nextLine();
            String elf_c = sc.nextLine();

            // ASCII A = 65, rucksack A = 27 (subtract 38)
            // ASCII Z = 90, rucksack Z = 52 (subtract 38)
            // ASCII a = 97, rucsack a = 1 (subtract 96)
            // ASCII z = 122, rucksack z = 26 (subtract 96)
            char item = FindBadge(elf_a, elf_b, elf_c);
            if (item == ' ') {
                System.out.println("Rucksack not parsed properly...");
                continue;
            }
            int item_value;
            if (Character.isUpperCase(item)) {
                item_value = item - 38;
            } else {
                item_value = item - 96;
            }
            priority_item_sum += item_value;
        }
        System.out.println("Sum of priorities is " + priority_item_sum);
        sc.close();
    }

    static char FindBadge(String elf_a, String elf_b, String elf_c) {
      // Could optimize this by having outer loop parse through 
      // git shortest string...
      for (int i = 0; i < elf_a.length(); i++) {
        if (elf_b.contains(Character.toString(elf_a.charAt(i))) 
            && elf_c.contains(Character.toString(elf_a.charAt(i)))) {
            return elf_a.charAt(i);
        }
      }
      return ' ';
    }
}
