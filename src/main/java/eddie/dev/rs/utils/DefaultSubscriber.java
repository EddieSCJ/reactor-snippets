package eddie.dev.rs.utils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Pode ser interessante saber que dá para gente usar composição também
 * e assim por exemplo, implementar logs por padrão dentro do onNext, onError e onComplete
 * por fim, chamar apenas o super.onNext() ou o subscriber.onNext() para ele executar seu trabalho
 * normalmente na pipeline
 * @param <T>
 */
public class DefaultSubscriber<T> implements Subscriber<T> {

    private String name;

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    public DefaultSubscriber() {
        this.name = "DefaultSubscriber";
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        System.out.println(name + " received: " + t);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(name + " error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " completed");
    }
}
