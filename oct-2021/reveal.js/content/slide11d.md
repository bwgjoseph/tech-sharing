##### Logging

```yaml
logging.level.root=warn
logging.level.org.springframework.web=debug

// group different package logs together for easier control
logging.group.tomcat=org.apache.catalina,org.apache.coyote,org.apache.tomcat
logging.level.tomcat=trace

// predefined by Spring
logging.group.web=debug
logging.group.sql=warn
```