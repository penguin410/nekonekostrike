package info.penguincat.control;

import com.google.common.eventbus.EventBus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import twitter4j.StatusUpdate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by @penguin_410 on 2016/03/18.
 */
@Slf4j
public class TweetTextBox extends VBox implements Initializable {
    private static final String FXML_NAME = "fxml/TweetTextBox.fxml";

    //config
    private static final int TWEET_TEXT_MAX_SIZE = 140;
    private static final KeyCombination TWEET_KEY_COMBINATION = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.CONTROL_DOWN);

    private final EventBus eventBus;
    @FXML
    private TextArea tweetTextArea;
    @FXML
    private Label textSizeCountLabel;

    public TweetTextBox(@NonNull EventBus eventBus) {
        this.eventBus = eventBus;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(FXML_NAME));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.textSizeCountLabel.textProperty().bindBidirectional(this.tweetTextArea.textProperty(), new StringConverter<String>() {
            @Override
            public String toString(String sourceString) {
                return String.valueOf(TWEET_TEXT_MAX_SIZE - sourceString.length());
            }

            @Override
            public String fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    public void onKeyReleased(KeyEvent keyEvent) {
        if (TWEET_KEY_COMBINATION.match(keyEvent)) {
            final String tweetText = this.tweetTextArea.getText();
            if (0 < tweetText.length() && tweetText.length() <= TWEET_TEXT_MAX_SIZE) {
                this.eventBus.post(new StatusUpdate(tweetText));
                this.tweetTextArea.clear();
            }
        }
    }
}
