# Tech Sharing Oct 21

This project is created from [start.spring.io](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.5.5&packaging=jar&jvmVersion=11&groupId=com.bwgjoseph&artifactId=techsharing&name=techsharing&description=Tech%20Sharing%20Oct%2021&packageName=com.bwgjoseph.techsharing&dependencies=devtools,lombok,configuration-processor,web,data-mongodb,validation,actuator)

## Concept to bring home

### Part 1

#### ApplicationContext (Manual)

> ApplicationConfig, ProfileService, PostService, Main

```java
// add this to main class

AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
var ps = appContext.getBean("profileService", ProfileService.class); // appContext.getBean(ProfileService.class);
System.out.println(ps.getAllProfilePost(10));
// Calling close will then trigger predestroy, pdestroy, and destroy method
appContext.close();
```

#### Dependency Injection

> ProfileService

There are 3 different [methods](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-collaborators) to inject objects into classes

- [constructor-based](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-constructor-injection)
- [setter-based](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-setter-injection)
- field-based

### Part 2

#### Bean Lifecycle

> PostService, CustomBeanProcessor, ApplicationConfig

[Most recommended](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lifecycle) is to use `@PostConstruct` and `@PreDestroy` as it is least coupled to the Spring-specific interface followed by `init-method, destroyMethod` and finally `implements InitializingBean, DisposableBean`

Order of call are

1. postProcessBeforeInitialization from `BeanPostProcessor`
1. @PostConstruct from `JSR-250`
1. afterPropertiesSet() from `InitializingBean`
1. init() from `init-method`
1. @PreDestroy from `JSR-250`
1. bdestroy() from `destroyMethod`
1. destroy() from `DisposableBean`
1. postProcessAfterInitialization from `BeanPostProcessor`

### Part 3

#### Application Event

> ApplicationEventListener

- Switch over to use `SpringApplication.run`
- Add `this.profileService.getAllProfilePost(10);` to `ApplicationEventListener`
- Add `ProfileEventListener`
- Add `BeforeGetAllProfileEvent`
- Add `publisher` to `getAllProfilePost`
- Remove `@Configuration` from `ApplicationConfig`
- Add `@Service` to `PostService, ProfileService`
