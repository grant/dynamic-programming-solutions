import java.util.*;

public class Pencil {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    // Get the inputs
    ArrayList<Integer> inputs = new ArrayList<Integer>();
    boolean done = false;
    while (!done) {
      int input = s.nextInt();
      if (input == 0) {
        done = true;
      } else {
        inputs.add(input);
      }
    }

    // Go through the inputs
    for (int i = 0; i < inputs.size(); ++i) {
      int n = inputs.get(i);
      System.out.println("Case " + (i+1) + ": " + n + " pencils for " + n + " cents");
      ArrayList<Solution> solutions = getSolutions(n);
      Collections.sort(solutions);
      if (solutions.size() == 0) {
        System.out.println("No solution found.");
        System.out.println();
      } else {
        for (int j = 0; j < solutions.size(); ++j) {
          Solution sol = solutions.get(j);
          System.out.println(sol.x + " at four cents each");
          System.out.println(sol.y + " at two for a penny");
          System.out.println(sol.z + " at four for a penny");
          System.out.println();
        }
      }
    }
  }

  public static ArrayList<Solution> getSolutions(int n) {
    ArrayList<Solution> solutions = new ArrayList<Solution>();
    for (int x = 1; x <= n; ++x) {
      for (int y = 1; y <= n; ++y) {
        for (int z = 1; z <= n; ++z) {
          double cost = 4*(double)x + (0.5)*(double)y + (0.25)*(double)z;
          int numPencils = x + y + z;
          if (cost == n && numPencils == n) {
            solutions.add(new Solution(x, y, z));
          }
        }
      }
    }
    return solutions;
  }
}