import org.junit.jupiter.api.Test;


import java.util.Arrays;

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

  @Test
  void addNinthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);

    Frame frame = game.frames()[4];

    int[] expectedFrame = new int[]{10, 0};
    int expectedScore = 10;
    int expectedTotalScore = 59;
    System.out.println(Arrays.toString(game.frames()));


    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertEquals(expectedTotalScore, game.totalScore());

    assertFalse(game.over());
  }

  @Test
  void addTenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);

    Frame frame = game.frames()[5];

    int[] expectedFrame = new int[]{0, 0};
    int expectedScore = 0;
    int expectedTotalScore = 59;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addEleventhRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);

    Frame frame = game.frames()[5];

    int[] expectedFrame = new int[]{0, 1};
    int expectedScore = 1;
    int expectedTotalScore = 61;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addTwelfthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);

    Frame frame = game.frames()[6];

    int[] expectedFrame = new int[]{7, 0};
    int expectedScore = 7;
    int expectedTotalScore = 68;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addThirteenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);
    game.addRoll(3);

    Frame frame = game.frames()[6];

    int[] expectedFrame = new int[]{7, 3};
    int expectedScore = 10;
    int expectedTotalScore = 71;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addFourteenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);
    game.addRoll(3);
    game.addRoll(6);

    Frame frame = game.frames()[7];

    int[] expectedFrame = new int[]{6, 0};
    int expectedScore = 6;
    int expectedTotalScore = 83;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addFifteenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);
    game.addRoll(3);
    game.addRoll(6);
    game.addRoll(4);

    Frame frame = game.frames()[7];

    int[] expectedFrame = new int[]{6, 4};
    int expectedScore = 10;
    int expectedTotalScore = 87;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addSixteenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);
    game.addRoll(3);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(10);

    Frame frame = game.frames()[8];

    int[] expectedFrame = new int[]{10, 0};
    int expectedScore = 10;
    int expectedTotalScore = 107;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addSeventeenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);
    game.addRoll(3);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(10);
    game.addRoll(2);


    Frame frame = game.frames()[9];

    int[] expectedFrame = new int[]{2, 0};
    int expectedScore = 2;
    int expectedTotalScore = 111;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addEighteenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);
    game.addRoll(3);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(10);
    game.addRoll(2);
    game.addRoll(8);


    Frame frame = game.frames()[9];

    int[] expectedFrame = new int[]{2, 8, 0};
    int expectedScore = 10;
    int expectedTotalScore = 127;

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertFalse(game.over());
  }

  @Test
  void addNinteenthRoll(){
    game = new Game();

    game.addRoll(1);
    game.addRoll(4);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(5);
    game.addRoll(5);
    game.addRoll(10);
    game.addRoll(0);
    game.addRoll(1);
    game.addRoll(7);
    game.addRoll(3);
    game.addRoll(6);
    game.addRoll(4);
    game.addRoll(10);
    game.addRoll(2);
    game.addRoll(8);
    game.addRoll(6);


    Frame frame = game.frames()[9];

    int[] expectedFrame = new int[]{2, 8, 6};
    int expectedScore = 16;
    int expectedTotalScore = 133;
    System.out.println(Arrays.toString(game.frames()));

    assertEquals(expectedTotalScore, game.totalScore());

    assertArrayEquals(expectedFrame, frame.getPinsRolled());
    assertEquals(expectedScore, frame.getScore());
    assertTrue(game.over());
  }






}