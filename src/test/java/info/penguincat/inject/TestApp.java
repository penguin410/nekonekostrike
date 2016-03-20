package info.penguincat.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import info.penguincat.inject.controller.TestController;
import info.penguincat.inject.repository.DomainRepository;
import info.penguincat.inject.repository.SimpleListDomainRepository;
import info.penguincat.inject.service.*;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by @penguin_410 on 2016/03/14.
 */
public class TestApp extends Application {
    private final Injector injector;

    public static void main(String[] args) {
        launch(args);
    }

    public TestApp() {
        this.injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DomainCreateService.class).to(DomainCreateServiceImpl.class);
                bind(DomainSearchService.class).to(DomainSearchServiceImpl.class);
                bind(DomainRepository.class).to(SimpleListDomainRepository.class);
                bind(TwitterStreamService.class).to(TwitterStreamServiceMock.class);
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TestController testController = injector.getInstance(TestController.class);
        primaryStage.show();
    }
}

