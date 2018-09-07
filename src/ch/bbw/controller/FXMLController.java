package ch.bbw.controller;

import ch.bbw.model.Maze;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    VBox vbox;
    @FXML
    HBox header;
    @FXML
    Canvas canvas;
    private GraphicsContext gc;
    private double oldX, oldY;
    private Stage primaryStage;
    private Parent root;

    private double startMoveX = -1, startMoveY = -1;
    private Boolean dragging = false;
    private Rectangle moveTrackingRect;
    private Popup moveTrackingPopup;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }
    @FXML
    public void close(MouseEvent evt) {
        ((Button) evt.getSource()).getScene().getWindow().hide();
    }

    private void moveWindow(MouseEvent event, boolean moving) {
        if (moving) {
            primaryStage.setX(primaryStage.getX() + (event.getScreenX() - oldX));
            primaryStage.setY(primaryStage.getY() + (event.getScreenY() - oldY));
        }

        oldX = event.getScreenX();
        oldY = event.getScreenY();
    }

    private void draw(Maze maze) {
        for (int x = 0; x < maze.getSize(); x++) {
            for (int y = 0; y < maze.getSize(); y++) {

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        header.setOnMouseDragged(event -> moveWindow(event, true));
        header.setOnMouseMoved(event -> moveWindow(event, false));
        gc = canvas.getGraphicsContext2D();
    }    
}
