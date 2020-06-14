package model;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class MainTest {
    private Field field;
    private Main game;
    private int size = 4;


    @Test
    public void left() throws FileNotFoundException {
        for (int i = 0 ; i < size; i++) {
            for (int j = 0 ; j < size; j++) {
                field.setCell(i, j, 0);
            }
        }
        field.setCell(2,0, 2 );
        game.left();
        int [] [] f1 = {{2,0,0,0},{0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
        assertArrayEquals(f1,field);
    }
    private void assertArrayEquals(int[][] f1, Field field) {
        
    }


    @Test
    public void right() {
    }

    @Test
    public void up() {
    }

    @Test
    public void down() {
    }

    @Test
    public void gameOver() {
    }

    @Test
    public void win() {
    }
}