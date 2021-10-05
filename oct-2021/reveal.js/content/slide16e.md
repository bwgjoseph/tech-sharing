Fail Fast

```java
public class UserService {
    // don't do this
    public User validateUser(User user) {
        if (user.name != null) {
            if (user.password != null) {
                processUser(user);
            } else {
                throws new Exception("no password");
            }
        } else {
            throws new Exception("no name");
        }
    }

    // much easier to see what's going on
    // also improves readability
    public User validatUser(User user) {
        if (user.name == null) throws new Exception("no name");
        if (user.password == null) throws new Exception("no password");

        // anything here onwards (usually) is positive case
        return processUser(user);
    }
}
```