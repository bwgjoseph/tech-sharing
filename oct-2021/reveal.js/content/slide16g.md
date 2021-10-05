Declare interface instead of implementation

```java
public class UserService {
    // don't do this
    public HashMap<String, String> getUserMap() {
        // some implementation
        return someMap;
    }

    // do this
    public Map<String, String> getUserMap() {
        // some implementation
        return someMap;
    }
}
```