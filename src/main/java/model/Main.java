package model;


import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
    private static int size = 4;
    private static Field field = new Field(size);
    private static ImageField imageField = new ImageField(size);
    private static Random random = new Random();
    private static boolean isMoved;
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
    public  void left() throws FileNotFoundException {
        for (int j = 0; j < size; j++) {
            for (int i = 1 ; i < size ; i++) {
                if (field.getCell(i,j) > 0) {
                    while (i - 1  > -1  && field.getCell(i - 1,j ) == 0) {
                        set(i - 1, j , field.getCell(i, j));
                        set(i,j,0);
                        i -= 1;
                        isMoved = true;
                    }
                }
            }
        }
        for (int j = 0; j < size; j++) {
            for (int i = 1 ; i < size; i++) {
                if (field.getCell(i,j) > 0) {
                    if (field.getCell(i - 1 , j) == field.getCell(i,j)) {
                        set(i -1 , j , field.getCell(i,j) * 2);
                        set(i,j, 0);
                        score += field.getCell(i,j) * 2;
                        int x = i;
                        int y = j;
                        while (x + 1 < 4 && field.getCell(x + 1 , y) > 0) {
                            set(x,y, field.getCell(x + 1 , y));
                            set(x + 1,y,0);
                            x += 1;
                            isMoved = true;
                        }
                    }
                }
            }
        }
        if (isMoved) addCell();

    }
    public  void right() throws FileNotFoundException {
        for (int j = 0; j < size; j++) {
            for (int i = size -2  ; i > -1; i--) {
                if (field.getCell(i,j) > 0) {
                    while (i + 1  < 4  && field.getCell(i + 1, j ) == 0) {
                        set(i + 1 , j , field.getCell(i, j));
                        set(i, j, 0);
                        i += 1;
                        isMoved = true;
                    }
                }
            }
        }
        for (int j = 0; j < size; j++) {
            for (int i = size -2  ; i > -1 ; i--) {
                if (field.getCell(i,j) > 0) {
                    if (field.getCell(i+1, j) == field.getCell(i,j)) {
                        set(i+1, j, field.getCell(i,j) * 2);
                        set(i,j,0);
                        score += field.getCell(i,j) * 2;
                        int x = i;
                        int y = j;
                        while ( x - 1 > -1 && field.getCell(x - 1, y) > 0) {
                            set(x, y , field.getCell(x - 1, y ));
                            set(x - 1,y,0);
                            x -= 1;
                            isMoved = true;
                        }
                    }
                }
            }
        }
        if (isMoved)  addCell();
    }
    public  void up() throws FileNotFoundException {
        for (int i = 0; i < size; i++) {
            for (int j = 1 ; j < size ; j++) {
                if (field.getCell(i,j) > 0) {
                    while (j - 1  > - 1   && field.getCell(i, j -1 ) == 0) {
                        set(i , j -1 , field.getCell(i, j));
                        set(i, j, 0);
                        j -= 1;
                        isMoved = true;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 1 ; j < size  ; j++) {
                if (field.getCell(i,j) > 0) {
                    if (field.getCell(i, j - 1 ) == field.getCell(i,j)) {
                        set(i, j - 1, field.getCell(i,j) * 2);
                        set(i,j,0);
                        score += field.getCell(i,j) * 2;
                        int x = i;
                        int y = j;
                        while ( y + 1 < 4 && field.getCell(x , y + 1) > 0 ) {
                            set(x , y , field.getCell(x , y + 1));
                            set(x,y +1 ,0);
                            y += 1;
                            isMoved = true;
                        }
                    }
                }
            }
        }
        if (isMoved)  addCell();
    }
    public void down() throws FileNotFoundException {
        for (int i = 0 ; i < size; i++) {
            for (int j = size -2 ; j > -1 ; j--) {
                if (field.getCell(i,j) > 0) {
                    while (j + 1 < 4  && field.getCell(i, j + 1 ) == 0) {
                        set(i, j + 1  , field.getCell(i, j));
                        set(i, j, 0);
                        j += 1;
                        isMoved = true;
                    }
                }
            }
        }
        for (int i = 0 ; i < size; i++) {
            for (int j = size -2 ; j > -1 ; j--) {
                if (field.getCell(i,j) > 0) {
                    if (field.getCell(i, j + 1) == field.getCell(i,j)) {
                        set(i, j+1 , field.getCell(i,j) * 2);
                        set(i,j,0);
                        score += field.getCell(i,j) * 2;
                        int x = i;
                        int y = j;
                        while (y - 1 > - 1 && field.getCell(x, y - 1) > 0) {
                            set(x, y , field.getCell(x , y - 1));
                            set(x ,y - 1,0);
                            y -= 1;
                            isMoved = true;
                        }
                    }
                }
            }
        }
        if (isMoved)  addCell();
    }
    public   boolean gameOver() {
        for (int i = 1; i < size -1; i++) {
            for (int j = 1; j < size -1 ; j++) {
                if ((field.getCell(i,j) > 0 ) && (field.getCell(i,j) != field.getCell(i + 1,j))
                        && (field.getCell(i,j) != field.getCell(i,j + 1))) {
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
