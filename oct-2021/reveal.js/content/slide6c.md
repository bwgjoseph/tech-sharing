##### Publishing Events

Provides a <u>ApplicationEventPublisher</u> to publish events

```java
@Service
public class EmailService {
    private final ApplicationEventPublisher publisher;

    public EmailService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void processEmail() {
        // publish custom event
        this.publisher.publishEvent(new EmailEvent());
    }
}
```
