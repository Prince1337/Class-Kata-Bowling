import java.util.Arrays;

public class Frame implements IFrame {

  private final int[] pinsRolled;
  private int score; // Punktzahl nur dieses Frame

  public Frame(int capacity) {
    pinsRolled = new int[capacity];
    score = 0;
  }

  @Override
  public int[] getPinsRolled() {
    return pinsRolled;
  }

  @Override
  public void addPinToScore(int pin, int rollCount){
    pinsRolled[rollCount] = pin;
    score += pin;
  }

  @Override
  public int getScore() {
    return score;
  }

  @Override
  public void addBonusToScore(int bonus){
    this.score += bonus;
  }

  @Override
  public String toString() {
    return "(" + Arrays.toString(pinsRolled) + "," + score + ")";
  }

  @Override
  public boolean isFullScore(){
    return score == 10;
  }

  @Override
  public boolean isFullScoreLastFrame(){
    return score >= 10;
  }

  @Override
  public boolean rollIsZero(int roll){
    return pinsRolled[roll] == 0;
  }

  @Override
  public boolean isBonusRoll(){
    return pinsRolled.length == 3;
  }

}
