package info.penguincat.service.twitter;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Created by @penguin_410 on 2016/03/20.
 */
@Slf4j
@Singleton
public class TwitterAPIEventSubscribeService {
    private final Twitter twitter = TwitterFactory.getSingleton();

    @Inject
    private TwitterAPIEventSubscribeService(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void updateStatus(StatusUpdate latestStatus) {
        try {
            this.twitter.updateStatus(latestStatus);
        } catch (TwitterException e) {
            e.printStackTrace();
            log.warn("updateStatusできない", e);
        }
    }
}
