##### Listening to Events

```java
// Using interface implementation
public class WebSocketConnection implements ApplicationListener<ApplicationReadyEvent> {
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // connect to websocket server
    }
}

// Using @EventListener
public class WebSocketConnection {
    @EventListener(ApplicationReadyEvent.class)
    public void handleEvent() {
        // connect to websocket server
    }

    @EventListener
    public void handleEvent(ApplicationReadyEvent event) {
        // connect to websocket server
    }

    // Using SpEL
    @EventListener(condition = "#myEvent.user eq 'joseph.gan'")
    public void onSpecificUserEvent(MyEvent myEvent) {
        // do something
    }
}
```

