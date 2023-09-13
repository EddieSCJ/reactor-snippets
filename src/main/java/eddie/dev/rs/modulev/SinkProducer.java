package eddie.dev.rs.modulev;

import reactor.core.publisher.FluxSink;
import reactor.core.publisher.SynchronousSink;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

public class SinkProducer<S> implements Consumer<S> {

    private S fluxSink;

    private Function<S, Void> sinkGenerator;


    public SinkProducer() {}

    public SinkProducer(Function sinkGenerator) {
        this.sinkGenerator = sinkGenerator;
    }

    @Override
    public void accept(S fluxSink) {
        this.fluxSink = fluxSink;
        try {
            this.produce();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void produce() throws Exception {
        sinkGenerator.apply(fluxSink);
    }

}
