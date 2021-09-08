package com.view;

import base.Page;
import javafx.stage.Stage;

public interface LoginPage<T, U extends Stage> extends Page<U> {
    void loginResult(T args);
}
