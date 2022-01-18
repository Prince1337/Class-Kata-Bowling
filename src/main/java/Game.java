
public class Game {

  private final Frame[] game = new Frame[10];
  private int currentFrame = 0;
  private int rollCount;

  public void addRoll(int pins){
    int capacity = 2;

    if(rollCount == capacity)
      currentFrame++;

    if(game[currentFrame] == null) {
      game[currentFrame] = new Frame(capacity);
      rollCount = 0;
    }



    if(pins < 10){
      game[currentFrame].addPin(pins, rollCount);
      rollCount++;
    }

    if(pins == 10){
      currentFrame++;
    }
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
    return false;
  }




}
