import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameTest {

  Game game;

  @Test
  void addFirstRoll(){
    game = new Game();

    game.addRoll(1);
    Frame frame = game.frames()[0];

    int[] expectedFrame = new int[]{1, 0, 0};
    int expectedScore = 1;

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addSecondRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    Frame frame = game.frames()[0];

    int[] expectedFrame = new int[]{1, 4, 0};
    int expectedScore = 5;

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addThirdRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    Frame frame = game.frames()[1];

    int[] expectedFrame = new int[]{4, 0, 0};
    int expectedScore = 4;

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }


}