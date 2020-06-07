package model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageField {
    int size;
    Image [][] fieldImage;
    public ImageField(int size){
        this.size = size;
        fieldImage = new Image[size][size];
    }
    public Image fromField(int i, int j) {
        return fieldImage[i][j];
    }
    public void setImage (int i, int j, Image image)  {
        fieldImage[i][j] = image;
    }
    public Image getImage (int num) throws FileNotFoundException {
        switch (num) {
            case 2 : return new Image(new FileInputStream("src/main/resources/images/num2.png")) ;
            case 4 : return new Image(new FileInputStream("src/main/resources/images/num4.png")) ;
            case 8 : return new Image(new FileInputStream("src/main/resources/images/num8.png")) ;
            case 16 : return new Image(new FileInputStream("src/main/resources/images/num16.png")) ;
            case 32 : return new Image(new FileInputStream("src/main/resources/images/num32.png")) ;
            case 64 : return new Image(new FileInputStream("src/main/resources/images/num64.png")) ;
            case 128 : return new Image(new FileInputStream("src/main/resources/images/num128.png")) ;
            case 256 : return new Image(new FileInputStream("src/main/resources/images/num256.png")) ;
            case 512 : return new Image(new FileInputStream("src/main/resources/images/num512.png")) ;
            case 1024 : return new Image(new FileInputStream("src/main/resources/images/num1024.png")) ;
            case 2048 : return new Image(new FileInputStream("src/main/resources/images/num2048.png")) ;
        }
        return new Image(new FileInputStream("src/main/resources/images/empty.png")) ;
    }
}
