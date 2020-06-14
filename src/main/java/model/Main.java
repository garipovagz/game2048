package model;


import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
    private static int size = 4;
    private static Field field = new Field(size);
    private static ImageField imageField = new ImageField(size);
    private static Random random = new Random();
    private static boolean isMoved ;
    private static int score;
    public  void startGame() throws FileNotFoundException {
        for (int i = 0 ; i < size; i++) {
            for (int j = 0 ; j < size; j++) {
                set(i,j,0);
            }
        }
        addCell();
        addCell();
    }
    private  void addCell() throws FileNotFoundException {
        for (int k = 0; k < 100; k++) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            if (field.getCell(i, j) == 0) {
                int num = (int) (Math.random() * 2);
                if ( num == 0) {
                    num = num + 4;
                } else num = num * 2;
                set(i, j, num);
                return;
            }
        }
    }
    private void move(int i, int j, int stepI, int stepJ) throws FileNotFoundException {
        if (field.getCell(i,j) > 0) {
            if (stepI == -1 || stepJ == -1) {
                while (i + stepI > -1 && j + stepJ > -1 &&  field.getCell(i + stepI, j + stepJ) == 0) {
                    set(i + stepI, j + stepJ, field.getCell(i, j));
                    set(i, j, 0);
                    i += stepI;
                    j += stepJ;
                    isMoved = true;
                }
            } else while (i + stepI < 4 && j + stepJ < 4 && field.getCell(i + stepI, j + stepJ) == 0) {
                set(i + stepI, j + stepJ, field.getCell(i, j));
                set(i, j, 0);
                i += stepI;
                j += stepJ;
                isMoved = true;
            }
        }
    }
    private void join(int i, int j, int stepI, int stepJ) throws FileNotFoundException {
        if (field.getCell(i,j) > 0) {
            if (field.getCell(i + stepI , j + stepJ) == field.getCell(i,j)) {
                set(i + stepI, j + stepJ, field.getCell(i, j) * 2);
                set(i, j, 0);
                score += field.getCell(i, j) * 2;
                int x = i;
                int y = j;
                if (stepI == - 1 || stepJ == - 1) {
                    while (x - stepI < 4 && y - stepJ < 4 && field.getCell(x  - stepI, y - stepJ) > 0) {
                        set(x, y, field.getCell(x  - stepI, y - stepJ));
                        set(x  - stepI, y - stepJ, 0);
                        x -= stepI;
                        y -= stepJ;
                        isMoved = true;
                    }
                } else while ( x - stepI > -1 && y - stepJ > -1 && field.getCell(x  - stepI, y - stepJ) > 0) {
                    set(x, y , field.getCell(x  - stepI, y - stepJ ));
                    set(x  - stepI, y - stepJ,0);
                    x -= stepI;
                    y -= stepJ;
                    isMoved = true;
                }
            }
        }
    }
    public  void left() throws FileNotFoundException {
        isMoved = false;
        for (int j = 0; j < size; j++) {
            for (int i = 1; i < size; i++) {
                move(i, j, -1, 0);
            }
            for (int i = 1; i < size; i++) {
                join(i, j, -1, 0);
            }
        }
    }
    public void addNumber() throws FileNotFoundException {
        if (isMoved) addCell();
    }

    public  void right() throws FileNotFoundException {
        isMoved = false;
        for (int j = 0; j < size; j++) {
            for (int i = size -2  ; i > -1; i--) {
               move(i,j,1,0);
            }
            for (int i = size -2  ; i > -1 ; i--) {
                join(i,j,1,0);
            }
        }
    }
    public  void up() throws FileNotFoundException {
        isMoved = false;
        for (int i = 0; i < size; i++) {
            for (int j = 1 ; j < size ; j++) {
               move(i,j,0,-1);
            }
            for (int j = 1 ; j < size  ; j++) {
               join(i,j,0, -1);
            }
        }
    }
    public void down() throws FileNotFoundException {
        isMoved = false;
        for (int i = 0 ; i < size; i++) {
            for (int j = size -2 ; j > -1 ; j--) {
                move(i,j,0,1);
            }
            for (int j = size -2 ; j > -1 ; j--) {
               join(i,j,0,1);
            }
        }
    }
    public   boolean gameOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field.getCell(i, j) == 0) {
                    return false;
                }
            }
        }
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1 ; j++) {
                if ((field.getCell(i,j) == field.getCell(i + 1,j))
                        || (field.getCell(i,j) == field.getCell(i - 1,j))
                        || (field.getCell(i,j) == field.getCell(i,j - 1))
                        || (field.getCell(i,j) == field.getCell(i,j + 1))) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean win(){
        for (int i = 0 ; i < size; i++) {
            for (int j = 0 ; j < size; j++){
                if (field.getCell(i,j) == 2048) {
                    return true;
                }
            }
        }
        return false;
    }
    private void set(int i, int j, int num) throws FileNotFoundException {
            field.setCell(i,j,num);
            imageField.setImage(i,j, imageField.getImage(num));
    }
    public ImageField setterField() {
        return imageField;
    }
}
