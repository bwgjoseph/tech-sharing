Example

```java
// must declare @Aspect
@Aspect
public class AroundExample {
    // Perform some action before and after the method
    @Around("com.bwgjoseph.app.*Service()")
    public Object timer(ProceedingJoinPoint pjp) throws Throwable {
        // perform some action before the method run
        StopWatch clock = new StopWatch("Profiling Start");
        // method run
        Object retVal = pjp.proceed();
        // perform some action after the method run
        clock.stop();
        log.info("Profiling Stop, took {}", stopWatch.getTotalTimeMillis());

        // return
        return retVal;
    }
}
```
