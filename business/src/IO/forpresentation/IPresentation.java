package IO.forpresentation;

import java.util.concurrent.CompletableFuture;

public interface IPresentation<T> {
    CompletableFuture<T> execute();
}
