package info.penguincat.inject.service;

import com.google.inject.Singleton;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 * Created by @penguin_410 on 2016/03/15.
 */
@Singleton
public class TwitterStreamServiceImpl implements TwitterStreamService {
    private final TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

    public TwitterStreamServiceImpl() {
        this.twitterStream.user();
    }

    public void addStatusListener(StatusListener listener) {
        this.twitterStream.addListener(listener);
    }

    public void removeStatusListener(StatusListener listener) {
        this.twitterStream.removeListener(listener);
    }
}
