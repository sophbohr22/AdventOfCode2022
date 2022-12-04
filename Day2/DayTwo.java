package Day2;

import java.io.File;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) throws Exception {
      // A = Rock      |  X = I NEED TO LOSE   
      // B = Paper     |  Y = I NEED A DRAW
      // C = Scissors  |  Z = I NEED TO WIN

      // Score for each round is score for the shape selected...
      // (1 = Rock), (2 = Paper), (3 = Scissors)
      // ... plus the score for the outcome of the round
      // (0 if lost), (3 if draw), (6 if won)

      // What would your total score be if everything goes exactly 
      // according to your strategy guide?
      File file = new File("Day2/day-two-input.txt");
      Scanner sc = new Scanner(file);

      int round_score = 0;
      int outcome_score = 0;
      int total_score = 0;
      while (sc.hasNextLine()) {
        String[] round = sc.nextLine().split(" ");
        // Get outcome score
        if (round[1].equals("X")) {
            // NEED TO LOSE
            outcome_score = 0;
            if (round[0].equals("A")) {
              // they picked rock, i pick scissors
              round_score = 3;
            } else if (round[0].equals("B")) {
              // they picked paper, i pick rock
              round_score = 1;
            } else if (round[0].equals("C")) {
              // they picked scissors, i pick paper
              round_score = 2;
            }
        } else if (round[1].equals("Y")) {
            // NEED A DRAW
            outcome_score = 3;
            if (round[0].equals("A")) {
                // they picked rock
                round_score = 1;
              } else if (round[0].equals("B")) {
                // they picked paper
                round_score = 2;
              } else if (round[0].equals("C")) {
                // they picked scissors
                round_score = 3;
              }
        } else if(round[1].equals("Z")) {
            // NEED TO WIN
            outcome_score = 6;
            if (round[0].equals("A")) {
                // they picked rock, i pick paper
                round_score = 2;
              } else if (round[0].equals("B")) {
                // they picked paper, i pick scissors
                round_score = 3;
              } else if (round[0].equals("C")) {
                // they picked scissors, i pick rock
                round_score = 1;
              }
        }
        total_score += round_score + outcome_score;
      }
      System.out.println("Total score: " + total_score);
      sc.close();
    }
  }
