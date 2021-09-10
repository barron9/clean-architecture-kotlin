package usecases;


import IO.forpresentation.IPresentation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class BusinessUseCase<T> implements IPresentation<T> {
    HashMap<String, String> container = new HashMap<>();

    public Map<String, String> defaultExecute(String var1, String var2) {
        container.put(var1, var2);
        return container;
    }

    public CompletableFuture<T> execute() {
        return null;
    }

    public abstract void run();

}
