package info.penguincat.service.nekonekostrike;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


/**
 * Created by @penguin_410 on 2016/03/18.
 */
@Slf4j
@Singleton
public class DeadEventCaptureService {
    @Inject
    private DeadEventCaptureService(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void onDeadEvent(DeadEvent deadEvent) {
        log.debug("Event is Dead! event: {}, source: {} ", deadEvent.getEvent(), deadEvent.getSource());
    }
}
