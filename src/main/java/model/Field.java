package model;

class Field {
    private int [][] field;
    Field(int size) {
        field = new int[size][size];
    }
    int getCell(int i, int j) {
        return field[i][j];
    }
    void setCell(int i, int j, int num)  {
        field[i][j] = num;
    }
}
