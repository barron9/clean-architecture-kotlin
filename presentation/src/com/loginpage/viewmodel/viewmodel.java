package com.loginpage.viewmodel;

import base.IBusinessUseCase;
import com.loginpage.view.ILoginPage;
import javafx.stage.Stage;

import java.util.HashMap;


public class viewmodel <L extends ILoginPage<HashMap<String,String>,Stage>> extends IBusinessUseCase<L> {
    @Override
    public void run() {
        getpresenter().loginResult(this.defaultExecute("test", "defultexevute return"));
    }
}
