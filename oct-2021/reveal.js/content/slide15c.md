Prefer RuntimeException and centralized error handling via @ExceptionHandler

```java
@RestController
public class ProfileController {
    @PostMapping("/profile")
    public Profile createProfile(@Valid Profile profile) {
        // always return success message
        // leave error to @ExceptionHandler
        return repository.create(profile);
    }
}

@ControllerAdvice
public class ProfileControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handle(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(Error::getFieldName, Error::getDefaultMessage));
    }
}
```