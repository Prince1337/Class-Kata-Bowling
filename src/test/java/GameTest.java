import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

  Game game;

  @BeforeEach
  void setup(){
    game = new Game();
  }

  @Test
  void testPinsAreCorrect() throws GameOverException {

    game.addRoll(1);
    game.addRoll(9);
    game.addRoll(2);
    game.addRoll(2);
    IFrame firstIFrame = game.frames()[0];
    IFrame secondIFrame = game.frames()[1];

    int[] expectedFrameFirstFrame = new int[]{1, 9};
    int[] expectedFrameSecondFrame = new int[]{2, 2};

    assertArrayEquals(expectedFrameFirstFrame, firstIFrame.getPinsRolled());
    assertArrayEquals(expectedFrameSecondFrame, secondIFrame.getPinsRolled());
  }

  @Test
  void testSpareBonus() throws GameOverException {

    game.addRoll(1);
    game.addRoll(9);
    game.addRoll(2);
    game.addRoll(2);

    IFrame firstIFrame = game.frames()[0];

    int expectedPointsFirstFrame = 12;
    int actual = firstIFrame.getScore();

    assertEquals(expectedPointsFirstFrame, actual);

  }

  @Test
  void testStrikeBonus() throws GameOverException {

    game.addRoll(10);
    game.addRoll(2);
    game.addRoll(2);

    IFrame firstIFrame = game.frames()[0];

    int expectedPointsFirstFrame = 14;
    int actual = firstIFrame.getScore();

    assertEquals(expectedPointsFirstFrame, actual);

  }

  @Test
  void testStrikeFrame() throws GameOverException {

    game.addRoll(10);
    game.addRoll(2);
    game.addRoll(2);

    IFrame firstIFrame = game.frames()[0];
    int[] expectedFrame = new int[]{10, 0};

    assertArrayEquals(expectedFrame, firstIFrame.getPinsRolled());

  }

  @Test
  void fullGame() throws GameOverException {
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

    int expectedTotalScore = 133;
    System.out.println(Arrays.toString(game.frames()));

    assertEquals(expectedTotalScore, game.totalScore());
    assertTrue(game.over());
  }

}