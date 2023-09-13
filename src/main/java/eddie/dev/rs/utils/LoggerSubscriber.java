package eddie.dev.rs.utils;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

public class LoggerSubscriber<T> implements Subscriber<T> {

    private Logger logger;
    private String infoLogMessage;

    public LoggerSubscriber(Class clazz, String infoLogMessage) {
        this.logger = Logger.getLogger(clazz.getName());
        this.infoLogMessage = new StringBuilder(infoLogMessage).append(" ").toString();
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        logger.log(INFO, infoLogMessage + t);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.log(SEVERE, "Error happened: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        logger.log(INFO, "Completed");
    }
}
