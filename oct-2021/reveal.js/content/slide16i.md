Prefer non inverse logic

```ts
// don't do this
const isValid = response.results.length === 0;
if (!isValid) { ... }

// do this
const hasResult = response.result.length > 0;
if (hasResult) { ... }
```