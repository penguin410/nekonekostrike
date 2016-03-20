package info.penguincat.service.twitter;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import info.penguincat.domain.event.twitter4j.ScrubGeo;
import info.penguincat.domain.event.twitter4j.TrackLimitationNotice;
import lombok.Value;
import twitter4j.*;


/**
 * Created by @penguin_410 on 2016/03/15.
 */
public class TwitterStreamServiceImpl implements TwitterStreamService {
    private final TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

    @Inject
    private TwitterStreamServiceImpl(EventBus eventBus) {
        this.twitterStream.addListener(new EventBusPublisher(eventBus));
    }

    @Override
    public void user() {
        this.twitterStream.user();
    }

    @Override
    public void cleanUp() {
        this.twitterStream.cleanUp();
    }

    @Value
    private class EventBusPublisher implements StatusListener {
        private final EventBus eventBus;

        @Override
        public void onStatus(Status status) {
            this.eventBus.post(status);
        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
            this.eventBus.post(statusDeletionNotice);
        }

        @Override
        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
            this.eventBus.post(new TrackLimitationNotice(numberOfLimitedStatuses));
        }

        @Override
        public void onScrubGeo(long userId, long upToStatusId) {
            this.eventBus.post(new ScrubGeo(userId, upToStatusId));
        }

        @Override
        public void onStallWarning(StallWarning warning) {
            this.eventBus.post(warning);
        }

        @Override
        public void onException(Exception ex) {
            this.eventBus.post(ex);
        }
    }
}
