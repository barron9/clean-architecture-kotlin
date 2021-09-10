package usecases;


import IO.fordatalayer.IDataLayer;
import IO.forpresentation.IPresentation;
import model.UserRepository;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public abstract class BusinessUseCase<T extends HashMap> implements IPresentation<T> {
    Executor executor = Executors.newFixedThreadPool(5);
    IDataLayer urepo = new UserRepository();

    public CompletableFuture<T> getUsers() {
        return  CompletableFuture.supplyAsync(() -> (T)urepo.getusers(),executor).thenApply(result -> {
          return result;
        });
    }
}
