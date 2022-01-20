
public class Game {

  private final IFrame[] scoreBoard = new IFrame[10];
  private static final int DEFAULT_MAXIMUM_ROLLS = 2;
  private int currentFrame = 0;
  private int rollCount;

  public void addRoll(int pins) throws GameOverException {
    if(!over()) {

      checkIfReachedMaximumRollsPerFrame();
      checkIfCurrentFrameIsNull();

      spareHandler(checkForSpare(), scoreBoard, currentFrame, pins);
      strikeHandler(checkForStrike(), scoreBoard, currentFrame, pins);
      insertScore(pins);

      checkForPossibleThirdRoll(pins);
    } else {
      throw new GameOverException("Game is already finished.");
    }
  }

  public int totalScore() {
    int totalScore = 0;
    for (IFrame IFrame : scoreBoard){
      if(IFrame != null)
        totalScore += IFrame.getScore();
    }
    return totalScore;
  }

  public IFrame[] frames(){
    return scoreBoard;
  }

  public boolean over() {
    return (currentFrame == 9 && rollCount == DEFAULT_MAXIMUM_ROLLS && scoreBoard[currentFrame].getPinsRolled().length == DEFAULT_MAXIMUM_ROLLS) ||
        (currentFrame == 9 && rollCount == 3 && scoreBoard[currentFrame].isBonusRoll());
  }

  private void checkForPossibleThirdRoll(int pins) {
    if(scoreBoard[currentFrame] != null && currentFrame == 9 && (pins == 10 || scoreBoard[currentFrame].getScore() == 10)){
      int newMaximumRolls = 3;
      int firstRoll = scoreBoard[currentFrame].getPinsRolled()[0];
      int secondRoll = scoreBoard[currentFrame].getPinsRolled()[1];

      scoreBoard[currentFrame] = new Frame(newMaximumRolls);
      scoreBoard[currentFrame].addPinToScore(firstRoll, 0);
      scoreBoard[currentFrame].addPinToScore(secondRoll, 1);
    }
  }

  private void insertScore(int pins) {
    if(pins < 10){
      scoreBoard[currentFrame].addPinToScore(pins, rollCount);
      rollCount++;
    }

    if(pins == 10){
      scoreBoard[currentFrame].addPinToScore(pins, rollCount);
      currentFrame++;
    }
  }

  private void spareHandler(boolean checkForBonus, IFrame[] game, int currentFrame, int pins) {
    if(checkForBonus){
      game[currentFrame - 1].addBonusToScore(pins);
    }
  }

  private void strikeHandler(boolean checkForBonus, IFrame[] game, int currentFrame, int pins) {
    if(checkForBonus){
      game[currentFrame - 1].addBonusToScore(pins);
    }
  }

  private void checkIfCurrentFrameIsNull() {
    if(scoreBoard[currentFrame] == null) {
      scoreBoard[currentFrame] = new Frame(DEFAULT_MAXIMUM_ROLLS);
      rollCount = 0;
    }
  }

  private void checkIfReachedMaximumRollsPerFrame() {
    if(rollCount == DEFAULT_MAXIMUM_ROLLS && currentFrame != 9)
      currentFrame++;
  }

  private boolean checkForStrike() {
    if(currentFrame != 0) {
      IFrame previousIFrame = scoreBoard[currentFrame - 1];
      return previousIFrame.isFullScoreLastFrame() && rollCount < 2 && (previousIFrame.rollIsZero(0) || previousIFrame.rollIsZero(1));
    }
    return false;
  }

  private boolean checkForSpare() {
    if(currentFrame != 0) {
      IFrame previousIFrame = scoreBoard[currentFrame - 1];
      return previousIFrame.isFullScore() && !previousIFrame.rollIsZero(0) && !previousIFrame.rollIsZero(1);
    }
    return false;
  }

}
