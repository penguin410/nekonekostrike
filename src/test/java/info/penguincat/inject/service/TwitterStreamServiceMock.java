package info.penguincat.inject.service;

import com.google.inject.Singleton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import lombok.NonNull;
import twitter4j.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 定期的にonStatusイベントを発行する
 * Created by @penguin_410 on 2016/03/15.
 */
@Singleton
public class TwitterStreamServiceMock implements TwitterStreamService {
    private final List<StatusListener> listeners = new CopyOnWriteArrayList<>();

    public TwitterStreamServiceMock() {
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listeners.forEach(statusListener -> statusListener.onStatus(new Status() {
                    @Override
                    public Date getCreatedAt() {
                        return null;
                    }

                    @Override
                    public long getId() {
                        return 0;
                    }

                    @Override
                    public String getText() {
                        return null;
                    }

                    @Override
                    public String getSource() {
                        return null;
                    }

                    @Override
                    public boolean isTruncated() {
                        return false;
                    }

                    @Override
                    public long getInReplyToStatusId() {
                        return 0;
                    }

                    @Override
                    public long getInReplyToUserId() {
                        return 0;
                    }

                    @Override
                    public String getInReplyToScreenName() {
                        return null;
                    }

                    @Override
                    public GeoLocation getGeoLocation() {
                        return null;
                    }

                    @Override
                    public Place getPlace() {
                        return null;
                    }

                    @Override
                    public boolean isFavorited() {
                        return false;
                    }

                    @Override
                    public boolean isRetweeted() {
                        return false;
                    }

                    @Override
                    public int getFavoriteCount() {
                        return 0;
                    }

                    @Override
                    public User getUser() {
                        return null;
                    }

                    @Override
                    public boolean isRetweet() {
                        return false;
                    }

                    @Override
                    public Status getRetweetedStatus() {
                        return null;
                    }

                    @Override
                    public long[] getContributors() {
                        return new long[0];
                    }

                    @Override
                    public int getRetweetCount() {
                        return 0;
                    }

                    @Override
                    public boolean isRetweetedByMe() {
                        return false;
                    }

                    @Override
                    public long getCurrentUserRetweetId() {
                        return 0;
                    }

                    @Override
                    public boolean isPossiblySensitive() {
                        return false;
                    }

                    @Override
                    public String getLang() {
                        return null;
                    }

                    @Override
                    public Scopes getScopes() {
                        return null;
                    }

                    @Override
                    public String[] getWithheldInCountries() {
                        return new String[0];
                    }

                    @Override
                    public int compareTo(Status o) {
                        return 0;
                    }

                    @Override
                    public UserMentionEntity[] getUserMentionEntities() {
                        return new UserMentionEntity[0];
                    }

                    @Override
                    public URLEntity[] getURLEntities() {
                        return new URLEntity[0];
                    }

                    @Override
                    public HashtagEntity[] getHashtagEntities() {
                        return new HashtagEntity[0];
                    }

                    @Override
                    public MediaEntity[] getMediaEntities() {
                        return new MediaEntity[0];
                    }

                    @Override
                    public ExtendedMediaEntity[] getExtendedMediaEntities() {
                        return new ExtendedMediaEntity[0];
                    }

                    @Override
                    public SymbolEntity[] getSymbolEntities() {
                        return new SymbolEntity[0];
                    }

                    @Override
                    public RateLimitStatus getRateLimitStatus() {
                        return null;
                    }

                    @Override
                    public int getAccessLevel() {
                        return 0;
                    }
                }));
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    @Override
    public void addStatusListener(@NonNull StatusListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeStatusListener(@NonNull StatusListener listener) {
        this.listeners.remove(listener);
    }
}
