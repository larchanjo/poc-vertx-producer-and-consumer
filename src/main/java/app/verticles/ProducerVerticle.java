package app.verticles;

import app.Application;
import app.EventBusProperties;
import app.domain.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import lombok.Builder;
import lombok.NonNull;
import lombok.val;

@Builder
public class ProducerVerticle extends AbstractVerticle {

  private static Logger logger = LoggerFactory.getLogger(ConsumerVerticle.class);
  private final Integer numberOfMessages;

  public ProducerVerticle(@NonNull Integer numberOfMessages) {
    this.numberOfMessages = numberOfMessages;
  }

  @Override
  public void start(Future<Void> startFuture) throws JsonProcessingException {
    for (int counter = 1; counter <= numberOfMessages; counter++) {
      val channel = EventBusProperties.MESSAGE_CHANNEL;
      val message = Message.builder().build();

      logger.info(String.format("ProducerVerticle - Sending %s to %s", message, channel));
      getVertx().eventBus().send(channel, Application.OBJECT_MAPPER.writeValueAsString(message));
    }
  }

}
