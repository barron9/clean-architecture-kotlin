package usecases;


import IO.fordatalayer.IDataLayer;
import IO.forpresentation.IPresentation;
import model.UserRepository;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;


public abstract class BusinessUseCase<T extends HashMap> implements IPresentation<T> {

    IDataLayer urepo = new UserRepository();

    public CompletableFuture<T> execute() {
        return  CompletableFuture.supplyAsync(() -> (T)urepo.getusers());
    }


}
