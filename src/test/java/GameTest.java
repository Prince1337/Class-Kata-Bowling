import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameTest {

  Game game;

  @Test
  void addFirstRoll(){
    game = new Game();

    game.addRoll(1);
    Frame frame = game.frames()[0];

    int[] expectedFrame = new int[]{1, 0};
    int expectedScore = 1;
    int expectedTotalScore = 1;

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertEquals(expectedTotalScore, game.totalScore());
    assertFalse(game.over());
  }

  @Test
  void addSecondRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    Frame frame = game.frames()[0];

    int[] expectedFrame = new int[]{1, 4};
    int expectedScore = 5;
    int expectedTotalScore = 5;


    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedTotalScore, game.totalScore());
    assertFalse(game.over());
  }

  @Test
  void addThirdRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    Frame frame = game.frames()[1];

    int[] expectedFrame = new int[]{4, 0};
    int expectedScore = 4;
    int expectedTotalScore = 9;


    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedTotalScore, game.totalScore());
    assertEquals(expectedScore, frame.getScore());

    assertFalse(game.over());
  }

  @Test
  void addFourthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);

    Frame frame = game.frames()[1];

    int[] expectedFrame = new int[]{4, 5};
    int expectedScore = 9;
    int expectedTotalScore = 14;
    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addFithRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);


    Frame frame = game.frames()[2];

    int[] expectedFrame = new int[]{6, 0};
    int expectedScore = 6;
    int expectedTotalScore = 20;
    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addSixthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);

    Frame frame = game.frames()[2];

    int[] expectedFrame = new int[]{6, 4};
    int expectedScore = 10;
    int expectedTotalScore = 24;

    assertEquals(expectedTotalScore, game.totalScore());
    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addSeventhRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);

    Frame frame = game.frames()[3];

    int[] expectedFrame = new int[]{5, 0};
    int expectedScore = 5;
    int expectedTotalScore = 34;

    assertEquals(expectedTotalScore, game.totalScore());
    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addEighthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);

    Frame frame = game.frames()[3];

    int[] expectedFrame = new int[]{5, 5};
    int expectedScore = 10;
    int expectedTotalScore = 39;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }


}