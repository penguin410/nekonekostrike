package info.penguincat.domain.event.twitter4j;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Created by @penguin_410 on 2016/03/16.
 */
@Value
@AllArgsConstructor
public final class ScrubGeo {
    long userId;
    long upToStatusId;
}
