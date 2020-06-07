package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Field;
import model.ImageField;
import model.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class view extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Group root = new Group();
        ImageView imageStart = new ImageView( new Image(new FileInputStream("src/main/resources/images/startGame.png")));
        imageStart.setX(0);
        imageStart.setY(0);
        imageStart.setFitWidth(400);
        imageStart.setFitWidth(400);
        root.getChildren().add(imageStart);
        GridPane p = new GridPane();
        root.getChildren().add(p);
        Main game = new Main();
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Game 2048");
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    try {
                        game.startGame();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                switch (event.getCode()) {
                        case LEFT:
                            try {
                                game.left();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            break;
                        case RIGHT:
                            try {
                                game.right();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            break;
                        case UP:
                            try {
                                game.up();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            break;
                        case DOWN:
                            try {
                                game.down();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                for (int i = 0 ; i < 4 ; i++) {
                    for (int j = 0 ; j < 4 ; j++) {
                        game.setterField();
                        ImageView image = new ImageView( game.setterField().fromField(i,j));
                        image.setX(10);
                        image.setY(10);
                        image.setFitWidth(100);
                        image.setFitHeight(100);
                        p.add(image, i  ,  j);
                    }
                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
