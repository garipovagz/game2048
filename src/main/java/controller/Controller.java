package controller;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Main;
import javafx.fxml.FXML;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Controller {
    private static GridPane gridPane = new GridPane();
    private Stage stage;
    private static Main game ;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void startG() {
        game = new Main();
        Group root = new Group(gridPane);
        try {
            game.startGame();
            game.addCell();
            game.addCell();
        } catch (FileNotFoundException ignored) { }
        drawField();
        Scene scene = new Scene(root, 400, 400);
        scene.setOnKeyPressed(handler);
        stage.setScene(scene);
    }

    private static EventHandler<KeyEvent> handler = event -> {
        switch (event.getCode()) {
            case LEFT:
                try {
                    game.left();
                } catch (FileNotFoundException e) {
                }
                try {
                    game.addNumber();
                } catch (FileNotFoundException e) {

                }
                break;
            case RIGHT:
                try {
                    game.right();
                } catch (FileNotFoundException e) { }
                try {
                    game.addNumber();
                } catch (FileNotFoundException e) {

                }
                break;
            case UP:
                try {
                    game.up();
                } catch (FileNotFoundException e) { }
                try {
                    game.addNumber();
                } catch (FileNotFoundException e) {

                }
                break;
            case DOWN:
                try {
                    game.down();
                } catch (FileNotFoundException e) { }
                try {
                    game.addNumber();
                } catch (FileNotFoundException e) {

                }
                break;
        }
        if (game.gameOver()) {
            InputStream image = Controller.class.getResourceAsStream("/images/gameOver.png");
            Image im = new Image(image);
            ImageView ima = new ImageView(im);
            ima.setFitWidth(400);
            ima.setFitHeight(400);
            gridPane.add(ima, 0, 0);
            try {
                game.startGame();
            } catch (FileNotFoundException e) {
            }
            drawField();
        }
        if (game.win()) {
            InputStream image = Controller.class.getResourceAsStream("/images/win.png");
            Image im = new Image(image);
            ImageView ima = new ImageView(im);
            ima.setFitWidth(400);
            ima.setFitHeight(400);
            gridPane.add(ima, 0, 0);
            try {
                game.startGame();
            } catch (FileNotFoundException e) {
            }
            drawField();
        }
        drawField();
    };
    private static void drawField() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageView image = new ImageView(game.setterField().fromField(i, j));
                image.setX(10);
                image.setY(10);
                image.setFitWidth(100);
                image.setFitHeight(100);
                gridPane.add(image, i, j);
            }
        }
    }
}