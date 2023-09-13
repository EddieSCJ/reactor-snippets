package eddie.dev.rs.modulev;

import com.github.javafaker.Faker;
import eddie.dev.rs.utils.LoggerSubscriber;
import eddie.dev.rs.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.SynchronousSink;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class FluxGenerate {
    public static void main(String[] args) {
        SinkProducer<SynchronousSink<String>> sinkProducer = new SinkProducer<>(fluxSink -> {
            ((SynchronousSink) fluxSink).next(Faker.instance().name().fullName());
            return null;
        });

        Flux.generate(sinkProducer)
                .take(10)
                .subscribe(Util.subscriber(FluxGenerate.class, "element: "));
    }
}
