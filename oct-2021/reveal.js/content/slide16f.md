Exit Early

```java
public class UserService {
    public boolean processUser(@NonNull User user) {
        if (user.username == null || user.username.length == 0) return false;

        return true;
    }

    public List<User> transformUser(List<User> user) {
        if (user.isEmpty()) return new ArrayList<>();

        // continue
        return users;
    }
}
```