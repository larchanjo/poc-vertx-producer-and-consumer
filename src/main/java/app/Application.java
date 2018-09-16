package app;

import app.verticles.ConsumerVerticle;
import app.verticles.ProducerVerticle;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Application {

  private static Logger logger = LoggerFactory.getLogger(Application.class);
  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static void main(String... arguments) {
    logger.info("Starting application");
    Vertx vertx = Vertx.vertx();

    // Producer verticles
    vertx.deployVerticle(ProducerVerticle.builder().numberOfMessages(5).build());

    // Consumer Verticles
    vertx.deployVerticle(ConsumerVerticle.builder().identification(1).build());
    vertx.deployVerticle(ConsumerVerticle.builder().identification(2).build());
  }

}
