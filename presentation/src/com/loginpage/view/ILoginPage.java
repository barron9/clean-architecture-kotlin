package com.loginpage.view;

import javafx.stage.Stage;

public interface ILoginPage<T extends Stage> {
    void loginResult(T args);

    Stage get();
}
