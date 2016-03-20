package info.penguincat.control.timeline;

import info.penguincat.domain.SimpleTweetModel;
import javafx.scene.control.ListCell;

/**
 * Created by @penguin_410 on 2016/03/18.
 */
// TODO: tweetVBoxのFactory化
public class CustomListCell extends ListCell<SimpleTweetModel> {
    private TweetVBox tweetVBox;

    @Override
    protected void updateItem(SimpleTweetModel item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
            setText(null);
            tweetVBox = null;
            return;
        }

        if (this.tweetVBox == null || getGraphic() == null) {
            this.tweetVBox = new TweetVBox(item);
            setGraphic(this.tweetVBox);
        } else {
            this.tweetVBox.update(item);
        }
    }
}
