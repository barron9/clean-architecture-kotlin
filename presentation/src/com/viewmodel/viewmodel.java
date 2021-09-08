package com.viewmodel;

import base.IBusinessUseCase;
import com.view.LoginPage;
import javafx.stage.Stage;

import java.util.HashMap;


public class viewmodel <L extends LoginPage<HashMap<String,String>,Stage>> extends IBusinessUseCase<L> {
    @Override
    public void run() {
        getpresenter().loginResult(this.defaultExecute("test", "defultexevute return"));
    }
}
