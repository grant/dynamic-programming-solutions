public class Solution implements Comparable<Solution> {
  int x; // 4 cent for 1
  int y; // 1 cent for 2
  int z; // 1 cent for 4

  public Solution(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public int compareTo(Solution b) {
    return this.x - b.x;
  }
}