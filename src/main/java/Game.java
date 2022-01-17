
public class Game {

  private final Frame[] frames = new Frame[10];
  private int currentFrame = 0;
  private int rollCount;

  public void addRoll(int pins){
    int capacity = 2;

    if(rollCount == capacity)
      currentFrame++;

    if(frames[currentFrame] == null) {
      frames[currentFrame] = new Frame(capacity);
      rollCount = 0;
    }



    if(pins < 10){
      frames[currentFrame].addPin(pins, rollCount);
      rollCount++;
    }

    if(pins == 10){
      currentFrame++;
    }
  }

  public Frame[] frames(){
    return frames;
  }

  public int totalScore() {
    int totalScore = 0;
    for (Frame frame : frames){
      if(frame != null)
        totalScore += frame.getScore();
    }
    return totalScore;
  }

  public boolean over() {
    return false;
  }




}
