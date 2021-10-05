Spring automatically performs the validation when annotated with <u>@Valid</u> or <u>@Validated</u>

```java
@RestController
public class ProfileController {
    @PostMapping("/profile")
    public Profile createProfile(@Valid Profile profile) {
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

We can consolidate all validation error and return to client with the use of <u>@ControllerAdvice</u>