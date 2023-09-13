package eddie.dev.rs.moduleiv;

import reactor.core.publisher.Mono;

public class SubscriptionTypes {

    public static void main(String[] args) {
        //publisher
        Mono<String> mono = Mono.just("test")
                .map(item -> item.toUpperCase());

        // first type of subscription (simpler one)
        mono.subscribe(); // nothing happens

        // second type of subscription (with callbacks)
        mono.subscribe(
                item -> System.out.println(item), //onNext
                error -> System.err.println(error.getMessage()), //onError
                () -> System.out.println("Completed 2") //onComplete
        );

        // third type of subscription (when error happens)
        mono.map(item -> {
            throw new RuntimeException("Exception happened 3");
        }).subscribe(
                item -> System.out.println(item), //onNext
                error -> System.err.println(error.getMessage()), //onError
                () -> System.out.println("Completed 3") //onComplete
        );
    }
}
