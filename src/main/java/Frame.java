
public class Frame {

  private int[] pinsRolled;
  private int score; // Punktzahl nur dieses Frame

  public Frame() {
    pinsRolled = new int[3];
    score = 0;
  }

  public int[] getPinsRolled() {
    return pinsRolled;
  }

  public int getScore() {
    for (int i: pinsRolled) {
      score += i;
    }
    return score;
  }

  @Override
  public String toString() {
    return "(" + pinsRolled + "," + score + ")";
  }
}
