import java.util.Arrays;

public class Frame {

  private final int[] pinsRolled;
  private int score; // Punktzahl nur dieses Frame
  private int capacity;

  public Frame(int capacity) {
    this.capacity = capacity;
    pinsRolled = new int[this.capacity];
    score = 0;
  }

  public int[] getPinsRolled() {
    return pinsRolled;
  }

  public void addPin(int pin, int rollCount){
    pinsRolled[rollCount] = pin;
    score += pin;
  }

  public int getScore() {
    return score;
  }

  public void addBonus (int bonus){
    this.score += bonus;
  }

  @Override
  public String toString() {
    return "(" + Arrays.toString(pinsRolled) + "," + score + ")";
  }
}
