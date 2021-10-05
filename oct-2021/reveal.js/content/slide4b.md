##### Inversion of Control (IoC) Container

```java
public class TechsharingApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		var ps = appContext.getBean("profileService", ProfileService.class); // appContext.getBean(ProfileService.class);
		System.out.println(ps.getAllProfilePost(10));
	}
}
```

```log
23:19:29.433 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'applicationConfig'
23:19:29.455 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'profileService'
23:19:29.464 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'postService'
9
```

<p align="left">IoC means you don't control the dependencies, let someone else (framework) control/manage it</p>