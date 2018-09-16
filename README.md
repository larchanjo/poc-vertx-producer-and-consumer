# Overview

This is a simple poc using [vert.x] to create reactive java applications.


## Test

You can see in the log 5 messages created and 5 messages consumed by different consumers.

### Producers

`ProducerVerticle - Sending Message(id=6920d21c-96e9-4d54-ae0f-f731a4bd8c) to message-channel`

`ProducerVerticle - Sending Message(id=6920d21c-96e9-4d54-ae0f-f7321abd8c) to message-channel`

`ProducerVerticle - Sending Message(id=6920d21c-96e9-4d54-ae0f-f75a49bd8c) to message-channel`

`ProducerVerticle - Sending Message(id=6920d21c-96e9-4d54-ae0f-f73619bd8c) to message-channel`

`ProducerVerticle - Sending Message(id=6920d21c-96e9-4d54-ae0f-f73179bd8c) to message-channel`


### Consumers

`ConsumerVerticle=[1] - Consuming {"id":"153ac52a-e925-43d2-bc59-541e83c606a1"} from message-channel`

`ConsumerVerticle=[2] - Consuming {"id":"153ac52a-e926-43d2-bc59-541e83c606a1"} from message-channel`

`ConsumerVerticle=[2] - Consuming {"id":"153ac52a-e927-43d2-bc59-541e83c606a1"} from message-channel`

`ConsumerVerticle=[1] - Consuming {"id":"153ac52a-e928-43d2-bc59-541e83c606a1"} from message-channel`

`ConsumerVerticle=[2] - Consuming {"id":"153ac52a-e929-43d2-bc59-541e83c606a1"} from message-channel`

[vert.x]: https://vertx.io/
