package model;

import javafx.scene.image.Image;
import java.io.InputStream;

public class ImageField {
    private Image [][] fieldImage;
    ImageField(int size){
        fieldImage = new Image[size][size];
    }
    public Image fromField(int i, int j) {
        return fieldImage[i][j];
    }
    void setImage(int i, int j, Image image)  {
        fieldImage[i][j] = image;
    }
    Image getImage(int num) {
        switch (num) {
            case 2 : {
                InputStream image = getClass().getResourceAsStream("/images/num2.png");
                return new Image(image);
            }
            case 4 : {
                InputStream image = getClass().getResourceAsStream("/images/num4.png");
                return new Image(image);
            }
            case 8 : {
                InputStream image = getClass().getResourceAsStream("/images/num8.png");
                return new Image(image);
            }
            case 16 : {
                InputStream image = getClass().getResourceAsStream("/images/num16.png");
                return new Image(image);
            }
            case 32 : {
                InputStream image = getClass().getResourceAsStream("/images/num32.png");
                return new Image(image);
            }
            case 64 :  {InputStream image = getClass().getResourceAsStream("/images/num64.png");
                return new Image(image);
            }
            case 128 : {
                InputStream image = getClass().getResourceAsStream("/images/num128.png");
                return new Image(image);
            }
            case 256 : {
                InputStream image = getClass().getResourceAsStream("/images/num256.png");
                return new Image(image);
            }
            case 512 :
            {
                InputStream image = getClass().getResourceAsStream("/images/num512.png");
                return new Image(image);
            }
            case 1024 : {
                InputStream image = getClass().getResourceAsStream("/images/num1024.png");
                return new Image(image);
            }
            case 2048 : {
                InputStream image = getClass().getResourceAsStream("/images/num2048.png");
                return new Image(image);
            }
        }
        InputStream image = getClass().getResourceAsStream("/images/empty.png");
        return new Image(image);
    }
}

