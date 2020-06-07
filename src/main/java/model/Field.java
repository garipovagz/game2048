package model;

public class Field {
    int size;
    int [][] field;
    public Field(int size) {
        this.size = size;
        field = new int[size][size];
    }
    public int getCell (int i, int j) {
        return field[i][j];
    }

    public void setCell (int i, int j, int num)  {
        field[i][j] = num;
    }
}
