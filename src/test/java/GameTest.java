import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameTest {

  Game game;

  @Test
  void addFirstRoll(){
    game = new Game();

    game.addRoll(1);
    Frame frame = game.frames()[0];

    int[] expectedFrame = new int[]{1};
    int expectedScore = 1;

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
  }
}