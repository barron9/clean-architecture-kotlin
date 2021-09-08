package com.loginpage.view;

import base.Page;
import javafx.stage.Stage;

public interface ILoginPage<T, U extends Stage> extends Page<U> {
    void loginResult(T args);
}
