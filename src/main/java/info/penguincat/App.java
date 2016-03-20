package info.penguincat;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.inject.*;
import info.penguincat.service.nekonekostrike.DeadEventCaptureService;
import info.penguincat.service.twitter.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.concurrent.Executors;

/**
 * Created by @penguin_410 on 2016/03/12.
 */
public class App extends Application {
    private final Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            bind(AccessTokenService.class).to(AccessTokenServiceImpl.class);
            bind(TwitterStreamService.class).to(TwitterStreamServiceImpl.class);
            bind(TwitterAPIEventSubscribeService.class).asEagerSingleton();
            bind(EventBus.class).toInstance(new AsyncEventBus(Executors.newWorkStealingPool()));
            bind(DeadEventCaptureService.class).asEagerSingleton();
        }
    });
    @Inject
    private TwitterStreamService twitterStreamService;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("fxml/NekoNekoStrike.fxml"));
        fxmlLoader.setControllerFactory(injector::getInstance);
        AnchorPane root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        injector.injectMembers(this);
        this.twitterStreamService.user();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        this.twitterStreamService.cleanUp();
    }
}