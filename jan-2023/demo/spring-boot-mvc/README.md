# Spring Boot MVC

This project attempt to showcase a sample `Spring Boot MVC` project, and the ecosystem surrounding it.

## 5 min Intro

`Spring Framework` provides the foundation for everything there is to `Spring`. The features it provides are:

- Core
  - Dependency Injection
  - Events
  - Validation
  - SpEL (Spring Expression Language)
  - AOP
- Testing
  - TextContext Framework
- Data Access
  - Transaction
  - JDBC
  - ORM
- Spring MVC and Spring WebFlux
- Integration
  - JMS
  - JMX
  - Cache
  - Scheduling

Whereas, `Spring Boot` simplify development by

- Embedding Webserver such as `Tomcat, Jetty or Undertow`
- Provide `starter` dependencies
  - Remove boilerplate codes
- @SpringBootApplication
  - @SpringBootConfiguration
  - @EnableAutoConfiguration
  - @ComponentScan
- Provide health check, metrics, and externalized configuration
  - Actuator

## Lifecycle

![lifecycle](lifecycle.png)

- Request hits the servlet container
- Pass through a series of `Filters`
- Reaching the `DispatcherServlet` which is also known as the `Front Controller`
- Hands off the request to `Handler Mapping`
  - Define a mapping between requests and handler objects
- Pass on the request to `Handler Interceptors`
  - Perform `pre and post` action
- Pass on to `Controller`
- Pass on to `View Resolver`
- Response back to `Client`

## Annotation

### Core

- @Bean
- @Primary
- @Qualifier
- @Value
- @Configuration
- @ConfigurationProperties
- @Autowired
- @Profile
- @ComponentScan
- @Transactional

### Sterotype

- @Component
- @Service
- @Repository
- @Controller
- @RestController

### Lifecycle

- @PostContruct
- @PreDestroy

### Web

- @RequestMapping
- @RequestBody
- @GetMapping
- @PostMapping
- @PatchMapping
- @PutMapping
- @DeleteMapping
- @ExceptionHandler
- @PathVariable
- @RequestParam
- @CrossOrigin

### Configuration

- @ConditionOnClass / MissingClass
- @ConditionOnBean / MissingBean
- @ConditionOnProperty
- @Conditional

### Test

- @SpringBootTest
- @TestConfiguration
- @TestPropertySource
- @ContextConfiguration
- @WebMvcTest
- @WebFluxTest
- @JdbcTest
- @DataJpaTest
- @DataMongoTest
- @JsonTest
- @RestClientTest

## Demo

- Refer to code
- To include
  - @RestController
  - @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
  - @PathVariable, @RequestParam
  - @Valid, @Validated
  - @ControllerAdvice
  - @Cache
  - @EventListener
  - @AuthenticatedPrincipal
  - Converter
  - Interceptor
  - Filters
  - AOP
  - @WebMvcTest
  - @MongoDataTest
  - Application Properties
- Demostrate
  - Constructor Injection
  - @ConfigurationProperties
  - MapStruct
  - Lombok
  - Jackson Configuration
  - Mongo Converter
  - Custom Jackson Serializer / Deserializer
  - HandlerMethodArgumentResolver

## References

- [servlet-things-every-java-developer-must-know-servlet-container-filter-and-listener](https://medium.com/javarevisited/servlet-things-every-java-developer-must-know-servlet-container-filter-and-listener-374a460169bd)
- [spring-framework-filter-vs-dispatcher-servlet-vs-interceptor-vs-controller](https://medium.com/javarevisited/spring-framework-filter-vs-dispatcher-servlet-vs-interceptor-vs-controller-745aa34b08d8)
- [spring-3-mvc-and-interceptor-with](https://www.dineshonjava.com/spring-3-mvc-and-interceptor-with/)
- [Handler Interceptor](https://livenow14.tistory.com/61)
- [java-servlets-servlet-api-and-servlet-life-cycle](https://medium.com/@cyberblogger007/java-servlets-servlet-api-and-servlet-life-cycle-with-a-simple-demo-code-43a34c8bb785)
- [spring-boot-annotation-reference-01-a](https://foojay.io/today/spring-boot-annotation-reference-01-a/)
- [spring-boot-annotation-reference-01-b](https://foojay.io/today/spring-boot-annotation-reference-01-b/)