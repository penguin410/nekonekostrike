package info.penguincat.service.nekonekostrike;

import com.google.inject.Singleton;
import info.penguincat.domain.SimpleTweetModel;
import lombok.NonNull;
import twitter4j.Status;

/**
 * Created by @penguin_410 on 2016/03/18.
 */
@Singleton
public class SimpleTweetModelService {
    public SimpleTweetModel create(@NonNull Status status) {
        return SimpleTweetModel
                .builder()
                .userName(status.getUser().getName())
                .tweetText(status.getText())
                .build();
    }
}
