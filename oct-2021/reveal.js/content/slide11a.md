##### Externalized Configuration

Read the value from the following order (with values from lower overriding earlier ones)

Total of <u>14 locations</u>

---

- ...
- application.properties (inside jar (default, profile-specific), outside jar (default, profile-specific))
- ...
- OS Environment Variable
- ...
- SPRING_APPLICATION_JSON
- Command line arguments
- ...
- @TestPropertySource
- ...