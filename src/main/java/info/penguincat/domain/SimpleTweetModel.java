package info.penguincat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * Created by @penguin_410 on 2016/03/18.
 */
@Value
@Builder
@AllArgsConstructor
public class SimpleTweetModel {
    String tweetText;
    String userName;
}
