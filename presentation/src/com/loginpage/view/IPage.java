package com.loginpage.view;

import javafx.stage.Stage;

public interface IPage <U,T extends Stage>{
    T get();
    void loginResult(U args);
}