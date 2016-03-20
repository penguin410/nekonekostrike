package info.penguincat.inject.controller;

import com.google.inject.Inject;
import info.penguincat.inject.service.DomainCreateService;
import info.penguincat.inject.service.DomainSearchService;
import info.penguincat.inject.service.TwitterStreamService;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * Created by @penguin_410 on 2016/03/14.
 */
public class TestController {
    private final DomainCreateService createService;
    private final DomainSearchService searchService;
    private final TwitterStreamService twitterStreamService;

    @Inject
    private TestController(DomainCreateService createService, DomainSearchService searchService, TwitterStreamService twitterStreamService) {
        this.createService = createService;
        this.searchService = searchService;
        this.twitterStreamService = twitterStreamService;
        this.twitterStreamService.addStatusListener(new StatusListener() {
            @Override
            public void onStatus(Status status) {
                updateView();
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {

            }

            @Override
            public void onStallWarning(StallWarning warning) {

            }

            @Override
            public void onException(Exception ex) {

            }
        });
    }

    private void updateView() {
        System.out.println("updateView");
    }
}
