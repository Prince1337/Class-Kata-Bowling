import java.util.Arrays;

public class Frame {

  private int[] pinsRolled;
  private int score; // Punktzahl nur dieses Frame
  private int capacity;

  public Frame(int capacity) {
    this.capacity = capacity;
    pinsRolled = new int[capacity];
    score = 0;
  }

  public int[] getPinsRolled() {
    return pinsRolled;
  }

  public void addPin(int pin, int rollsCount){
    pinsRolled[rollsCount] = pin;
    score += pin;
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return "(" + Arrays.toString(pinsRolled) + "," + score + ")";
  }
}
