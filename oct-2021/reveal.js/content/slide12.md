# Spring Boot Actuator

---

- Monitor Application via Metrics and Endpoints
  - health, metrics, env, loggers, etc
- Ability to create custom `@WebEndpoint`
- Can enable/disable via properties configuration

```yaml
management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.exclude=env,beans
```


