package com.loginpage.view;

import javafx.stage.Stage;

public interface ILoginPage<T extends Stage> extends IPage<T> {
    void loginResult(T args);

}
