package info.penguincat.control.timeline;

import info.penguincat.domain.SimpleTweetModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.NonNull;

import java.io.IOException;

/**
 * Created by @penguin_410 on 2016/03/18.
 */
public class TweetVBox extends VBox {
    private static final String FXML_NAME = "fxml/TweetVBox.fxml";
    @FXML
    private ImageView iconImageView;
    @FXML
    private Label tweetTextLabel;
    @FXML
    private Label replyLabel;
    @FXML
    private Label favoriteLabel;
    @FXML
    private Label retweetLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label nameLabel;

    public TweetVBox(@NonNull SimpleTweetModel model) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_NAME));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.tweetTextLabel.setText(model.getTweetText());
        this.nameLabel.setText(model.getUserName());
    }

    public void update(@NonNull SimpleTweetModel model) {
        this.tweetTextLabel.setText(model.getTweetText());
        this.nameLabel.setText(model.getUserName());
    }
}
