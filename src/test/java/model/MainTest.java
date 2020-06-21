package model;

import org.junit.Test;

import java.io.FileNotFoundException;
import  static org.junit.Assert.*;

public class MainTest {
    private Main game = new Main();
    private void assertArrayEquals(int[][] f1, Field field) {
        int size = 4;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertEquals(f1[i][j], field.getCell(i,j));
            }
        }
    }
    @Test
    public void startGameCheck() throws FileNotFoundException {
        int[][] f2 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        game.startGame();
        Field f1 = game.getterField();
        assertArrayEquals(f2,f1);
    }
    @Test
    public void left() throws FileNotFoundException {
        int[][] f2 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        f2[0][0] = 4;
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(2,0, 2);
        f1.setCell(1, 0, 2);
        game.left();
        f1 = game.getterField();
        assertArrayEquals(f2,f1);
    }
    @Test
    public void right() throws FileNotFoundException {
        int[][] f2 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        f2[3][0] = 4;
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(1,0, 2);
        f1.setCell(2, 0, 2);
        game.right();
        f1 = game.getterField();
        assertArrayEquals(f2,f1);
    }
    @Test
    public void up() throws FileNotFoundException {
        int[][] f2 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        f2[2][0] = 4;
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(2,1, 2);
        f1.setCell(2, 2, 2);
        game.up();
        f1 = game.getterField();
        assertArrayEquals(f2,f1);
    }
    @Test
    public void down() throws FileNotFoundException {
        int[][] f2 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        f2[1][3] = 4;
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(1,2, 2);
        f1.setCell(1, 3, 2);
        game.down();
        f1 = game.getterField();
        assertArrayEquals(f2,f1);
    }

    @Test
    public void gameOver() throws FileNotFoundException {
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(0,0, 2);
        f1.setCell(1,0, 8);
        f1.setCell(2,0, 2);
        f1.setCell(3,0, 8);

        f1.setCell(0,1, 4);
        f1.setCell(1,1, 16);
        f1.setCell(2,1, 4);
        f1.setCell(3,1, 16);

        f1.setCell(0,2, 2);
        f1.setCell(1,2, 8);
        f1.setCell(2,2, 2);
        f1.setCell(3,2, 8);

        f1.setCell(0,3, 4);
        f1.setCell(1,3, 16);
        f1.setCell(2,3, 4);
        f1.setCell(3,3, 16);

            assertTrue(game.gameOver());
        }
    @Test
    public void gameOver2() throws FileNotFoundException {
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(0,0, 2);
        f1.setCell(1,0, 2);
        f1.setCell(2,0, 2);
        f1.setCell(3,0, 8);

        f1.setCell(0,1, 4);
        f1.setCell(1,1, 16);
        f1.setCell(2,1, 4);
        f1.setCell(3,1, 16);

        f1.setCell(0,2, 2);
        f1.setCell(1,2, 8);
        f1.setCell(2,2, 2);
        f1.setCell(3,2, 8);

        f1.setCell(0,3, 4);
        f1.setCell(1,3, 16);
        f1.setCell(2,3, 4);
        f1.setCell(3,3, 16);

        assertFalse(game.gameOver());
    }
    @Test
    public void win() throws FileNotFoundException {
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(3,2, 2048);
        assertTrue(game.win());
    }
    @Test
    public void win2() throws FileNotFoundException {
        game.startGame();
        Field f1 = game.getterField();
        f1.setCell(3,2, 2);
        assertFalse(game.win());
    }
}