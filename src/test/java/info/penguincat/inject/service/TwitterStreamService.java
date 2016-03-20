package info.penguincat.inject.service;

import twitter4j.StatusListener;

/**
 * Created by @penguin_410 on 2016/03/15.
 */
public interface TwitterStreamService {
    void addStatusListener(StatusListener listener);

    void removeStatusListener(StatusListener listener);
}
