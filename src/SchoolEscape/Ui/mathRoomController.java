/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolEscape.Ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static javafx.geometry.NodeOrientation.LEFT_TO_RIGHT;
import static javafx.geometry.NodeOrientation.RIGHT_TO_LEFT;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class mathRoomController implements Initializable {

    @FXML
    private TitledPane playerInventory;
    @FXML
    private ProgressBar timer;
    @FXML
    private ImageView playerIcon;
    @FXML
    private ImageView player;

    private int playerX;
    private int playerY;
    private int speed = gameConstants.speed;
    @FXML
    private ImageView topWall;
    @FXML
    private ImageView leftWall;
    @FXML
    private ImageView bottomWall;
    @FXML
    private ImageView rightWall;
    @FXML
    private ImageView topDoor;
    @FXML
    private ImageView rightDoor;
    @FXML
    private ImageView bottomDoor;
    @FXML
    private ImageView leftDoor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void playerMovement(KeyEvent event) throws IOException {
        if (player.intersects(player.sceneToLocal(bottomDoor.localToScene(bottomDoor.getBoundsInLocal())))) {
            Parent startParent = FXMLLoader.load(getClass().getResource("redHallway.fxml"));
            Scene startScene = new Scene(startParent);
            Stage startStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startStage.setScene(startScene);
            startStage.show();
        }
        if (event.getCode() == KeyCode.W) {
            if (player.intersects(player.sceneToLocal(topWall.localToScene(topWall.getBoundsInLocal())))) {
                // DO NOTHING.
            } else {
                playerY -= speed;
                movePlayer();
            }
        } else {
            if (event.getCode() == KeyCode.A) {
                if (player.intersects(player.sceneToLocal(leftWall.localToScene(leftWall.getBoundsInLocal())))) {
                    // DO NOTHING
                } else {
                    player.setNodeOrientation(RIGHT_TO_LEFT);
                    playerX -= speed;
                    movePlayer();
                }
            } else {
                if (event.getCode() == KeyCode.S) {
                    if (player.intersects(player.sceneToLocal(bottomWall.localToScene(bottomWall.getBoundsInLocal())))) {
                        // DO NOTHING.
                    } else {
                        playerY += speed;
                        movePlayer();
                    }

                } else {
                    if (event.getCode() == KeyCode.D) {
                        if (player.intersects(player.sceneToLocal(rightWall.localToScene(rightWall.getBoundsInLocal())))) {
                            // DO NOTHING.   
                        } else {
                            player.setNodeOrientation(LEFT_TO_RIGHT);
                            playerX += speed;
                            movePlayer();
                        }

                    }

                }

            }
        }
    }

    public void movePlayer() {
        player.setX(playerX);
        player.setY(playerY);

    }

}