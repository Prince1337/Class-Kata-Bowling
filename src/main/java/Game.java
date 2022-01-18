
public class Game {

  private final Frame[] game = new Frame[10];
  private int currentFrame = 0;
  private int rollCount;

  public void addRoll(int pins){
    int capacity = 2;

    if(rollCount == capacity && currentFrame != 9)
      currentFrame++;

    if(game[currentFrame] == null) {
      game[currentFrame] = new Frame(capacity);
      rollCount = 0;
    }

    if(checkForSpare()){
      game[currentFrame - 1].addBonus(pins);
    }

    if(checkForStrike()){
      game[currentFrame - 1].addBonus(pins);
    }

    if(pins < 10){
      game[currentFrame].addPin(pins, rollCount);
      rollCount++;
    }

    if(pins == 10){
      game[currentFrame].addPin(pins, rollCount);
      currentFrame++;
    }

    if(game[currentFrame] != null && currentFrame == 9 && (pins == 10 || game[currentFrame].getScore() == 10)){
      int firstRoll = game[currentFrame].getPinsRolled()[0];
      int secondRoll = game[currentFrame].getPinsRolled()[1];

      game[currentFrame] = new Frame(3);
      game[currentFrame].addPin(firstRoll, 0);
      game[currentFrame].addPin(secondRoll, 1);
    }
  }

  private boolean checkForStrike() {
    return currentFrame != 0 && game[currentFrame] != null && game[currentFrame - 1].getScore() >= 10 && (game[currentFrame - 1].getPinsRolled()[0] == 0 || game[currentFrame - 1].getPinsRolled()[1] == 0 && rollCount != 2);
  }

  private boolean checkForSpare() {
    return currentFrame != 0 && game[currentFrame - 1].getScore() == 10 && game[currentFrame - 1].getPinsRolled()[0] != 0 && game[currentFrame - 1].getPinsRolled()[1] != 0;
  }

  public Frame[] frames(){
    return game;
  }

  public int totalScore() {
    int totalScore = 0;
    for (Frame frame : game){
      if(frame != null)
        totalScore += frame.getScore();
    }
    return totalScore;
  }

  public boolean over() {
    return (currentFrame == 9 && rollCount == 2 && game[currentFrame].getPinsRolled().length == 2) ||
        (currentFrame == 9 && rollCount == 3 && game[currentFrame].getPinsRolled().length == 3);
  }




}
