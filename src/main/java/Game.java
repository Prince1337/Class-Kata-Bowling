
public class Game {

  private Frame[] frames = new Frame[10];
  private int currentFrame = 0;
  private int rollCount;

  public void addRoll(int pins){
    if(frames[currentFrame] == null) {
      frames[currentFrame] = new Frame();
      rollCount = 0;
    }

    frames[currentFrame].getPinsRolled()[rollCount] = pins;
    rollCount++;
    if(pins == 10){
      currentFrame++;
    }
  }

  public Frame[] frames(){
    return frames;
  }

  public int totalScore() {
    return 0;
  }

  public boolean over() {
    return false;
  }




}
