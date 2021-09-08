package com.viewmodel;

import javafx.scene.Scene;
import usecases.IBusinessUseCase;
import usecases.Page;


public class viewmodel extends IBusinessUseCase<Page> {
    viewmodel v = null;
    Page t = null;

    public viewmodel() {
        v = this;
    }

    viewmodel getViewmodel() {
        return this;
    }

    @Override
    public void run() {
        this.defaultExecute("","");
    }
}
