Prefer coding to interface (not when it’s single class or when it make sense)

```java
public interface CompressionAlgorithm {
    public T compress(T data) {}
}

public class Simple implements CompressionAlgorithm {
    @Override
    public T compress(T data) {}
}

public class Advance implements CompressionAlgorithm {
    @Override
    public T compress(T data) {}
}

public class CompressionAlgorithmFactory {
    // return concrete alogrithm to use
}

public class CompressService {
    private final CompressionAlgorithmFactory compressionAlgorithmFactory;

    public CompressService(CompressionAlgorithmFactory compressionAlgorithmFactory) {
        this.CompressionAlgorithmFactory = compressionAlgorithmFactory;
    }

    public Data compress(Data data, String algorithm) {
        CompressionAlgorithm compression = this.CompressionAlgorithmFactory.getConcrete(alogrithm);
        return compression.compress(data);
    }
}
```

Strategy Pattern

---

```java
public interface CompressionAlgorithm {
    public T compress(T data) {}
}

public class Simple implements CompressionAlgorithm {
    @Override
    public T compress(T data) {}
}

public class Advance implements CompressionAlgorithm {
    @Override
    public T compress(T data) {}
}

public class CompressService {
    private final CompressionAlgorithm compressionAlgorithm;

    // doesn't care about the actual implementation as long
    // it fulfills the interface requirement
    // this allows us to switch the implmentation without
    // breaking the contract to consumer
    public CompressService(CompressionAlgorithm compressionAlgorithm) {
        this.compressionAlgorithm = compressionAlgorithm;
    }
}
```