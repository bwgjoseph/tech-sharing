Prefer using `this`

```java
public class UserService {
    private final ProfileService profileService;

    public UserService(ProfileService profileService) {
        // reduce ambiguity
        this.profileService = profileService;
    }

    public boolean checkProfileExist(User user) {
        // clearer indication of class variable
        return this.profileService.profileExist(user.getUsername());
    }
}
```