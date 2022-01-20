public interface IFrame {
  int[] getPinsRolled();

  void addPinToScore(int pin, int rollCount);

  int getScore();

  void addBonusToScore(int bonus);

  boolean isFullScore();

  boolean isFullScoreLastFrame();

  boolean rollIsZero(int roll);

  boolean isBonusRoll();
}
