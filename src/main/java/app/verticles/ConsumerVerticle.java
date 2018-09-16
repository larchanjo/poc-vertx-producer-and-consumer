package app.verticles;

import app.EventBusProperties;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import lombok.Builder;
import lombok.NonNull;
import lombok.val;

@Builder
public class ConsumerVerticle extends AbstractVerticle {

  private static Logger logger = LoggerFactory.getLogger(ConsumerVerticle.class);
  private final Integer identification;

  public ConsumerVerticle(@NonNull Integer identification) {
    this.identification = identification;
  }

  @Override
  public void start(Future<Void> startFuture) {
    val channel = EventBusProperties.MESSAGE_CHANNEL;
    getVertx().eventBus().consumer(channel, message -> {
      val format = "ConsumerVerticle=[%s] - Consuming %s from %s";
      logger.info(String.format(format, identification, message.body(), channel));
    });
  }

}
