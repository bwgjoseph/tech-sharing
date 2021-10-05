Use of Inversion of Control

```java
public interface ProfileDeletionEvent {
    void onDeleteProfileEvent(String profileId);
}

class ProfileService {
    private final List<ProfileDeletionEvent> profileDeletionEvent;

    public void delete(String profileId) {
        profileDeletionEvent.forEach(event -> event.onDeleteProfileEvent(profileId));
    }
}

class SolrProfileDeletion implements ProfileDeletionEvent {
    @Override
    public void onDeleteProfileEvent(String profileId) {
        // handle
    }
}

class MessageBrokerProfileDeletion implements ProfileDeletionEvent {
    @Override
    public void onDeleteProfileEvent(String profileId) {
        // handle
    }
}
```

Use <u>Event Publisher</u> works too!