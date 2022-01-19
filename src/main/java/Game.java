
public class Game {

  private final Frame[] scoreBoard = new Frame[10];
  private static final int DEFAULT_MAXIMUM_ROLLS = 2;
  private int currentFrame = 0;
  private int rollCount;

  public void addRoll(int pins){

    checkIfReachedMaximumRollsPerFrame();
    checkIfCurrentFrameIsNull();

    spareHandler(checkForSpare(), scoreBoard, currentFrame, pins);
    strikeHandler(checkForStrike(), scoreBoard, currentFrame, pins);
    insertScore(pins);

    checkForPossibleThirdRoll(pins);
  }

  public int totalScore() {
    int totalScore = 0;
    for (Frame frame : scoreBoard){
      if(frame != null)
        totalScore += frame.getScore();
    }
    return totalScore;
  }

  public boolean over() {
    return (currentFrame == 9 && rollCount == DEFAULT_MAXIMUM_ROLLS && scoreBoard[currentFrame].getPinsRolled().length == DEFAULT_MAXIMUM_ROLLS) ||
        (currentFrame == 9 && rollCount == 3 && scoreBoard[currentFrame].bonusRoll());
  }

  private void checkForPossibleThirdRoll(int pins) {
    if(scoreBoard[currentFrame] != null && currentFrame == 9 && (pins == 10 || scoreBoard[currentFrame].getScore() == 10)){
      int newMaximumRolls = 3;
      int firstRoll = scoreBoard[currentFrame].getPinsRolled()[0];
      int secondRoll = scoreBoard[currentFrame].getPinsRolled()[1];

      scoreBoard[currentFrame] = new Frame(newMaximumRolls);
      scoreBoard[currentFrame].addPin(firstRoll, 0);
      scoreBoard[currentFrame].addPin(secondRoll, 1);
    }
  }

  private void insertScore(int pins) {
    if(pins < 10){
      scoreBoard[currentFrame].addPin(pins, rollCount);
      rollCount++;
    }

    if(pins == 10){
      scoreBoard[currentFrame].addPin(pins, rollCount);
      currentFrame++;
    }
  }

  private void spareHandler(boolean checkForBonus, Frame[] game, int currentFrame, int pins) {
    if(checkForBonus){
      game[currentFrame - 1].addBonus(pins);
    }
  }

  private void strikeHandler(boolean checkForBonus, Frame[] game, int currentFrame, int pins) {
    if(checkForBonus){
      game[currentFrame - 1].addBonus(pins);
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
      Frame previousFrame = scoreBoard[currentFrame - 1];
      return previousFrame.fullScoreLastFrame() && rollCount < 2 && (previousFrame.rollIsZero(0) || previousFrame.rollIsZero(1));
    }
    return false;
  }

  private boolean checkForSpare() {
    if(currentFrame != 0) {
      Frame previousFrame = scoreBoard[currentFrame - 1];
      return previousFrame.fullScore() && !previousFrame.rollIsZero(0) && !previousFrame.rollIsZero(1);
    }
    return false;
  }

  public Frame[] frames(){
    return scoreBoard;
  }

}
