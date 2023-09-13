package eddie.dev.rs.utils;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.Disposable;

public class Util {

    public static <T> Subscriber<T> subscriber() {
        return new DefaultSubscriber<T>();
    }

    public static <T> Subscriber<T> subscriber(Class clazz, String infoLogMessage) {
        return new LoggerSubscriber<>(clazz, infoLogMessage);
    }

    public static String generateCountryName() {
        return Faker.instance().country().name();
    }


}
