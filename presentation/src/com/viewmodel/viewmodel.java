package com.viewmodel;

import base.IBusinessUseCase;
import com.view.LoginPage;


public class viewmodel extends IBusinessUseCase<LoginPage> {
    @Override
    public void run() {
        getpresenter().loginResult(this.defaultExecute("test", "defultexevute return"));
    }
}
