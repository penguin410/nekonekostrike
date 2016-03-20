package info.penguincat.controller;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import info.penguincat.control.TweetTextBox;
import info.penguincat.control.timeline.CustomListCell;
import info.penguincat.domain.SimpleTweetModel;
import info.penguincat.service.nekonekostrike.SimpleTweetModelService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import twitter4j.Status;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by @penguin_410 on 2016/03/14.
 */
public class NekoNekoStrikeContoroller implements Initializable {
    private final EventBus eventBus;
    private final ListView<SimpleTweetModel> listView = new ListView<>();
    private final SimpleTweetModelService simpleTweetModelService;

    @FXML
    private AnchorPane root;

    @Inject
    private NekoNekoStrikeContoroller(EventBus eventBus, SimpleTweetModelService simpleTweetModelService) {
        this.eventBus = eventBus;
        this.eventBus.register(this);
        this.simpleTweetModelService = simpleTweetModelService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox container = new VBox(new TweetTextBox(this.eventBus), this.listView);
        this.root.getChildren().add(container);
        AnchorPane.setBottomAnchor(container, 0.0);
        AnchorPane.setTopAnchor(container, 0.0);
        AnchorPane.setRightAnchor(container, 0.0);
        AnchorPane.setLeftAnchor(container, 0.0);
        this.listView.setCellFactory(param -> new CustomListCell());
    }

    @Subscribe
    public void onStatus(Status status) {
        SimpleTweetModel model = this.simpleTweetModelService.create(status);
        Platform.runLater(() -> this.listView.getItems().add(0, model));
    }
}
