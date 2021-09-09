package com;

import com.loginpage.view.ILoginPage;
import javafx.scene.Scene;

public abstract class GenericRouter<T extends ILoginPage> {
    T t = null;

    public void setpresenter(T t) {
        this.t = t;
    }

    public T getpresenter() {
        return t;
    }

    public void setroute(Scene s) {
        getStage().get().setScene(s);
    }

    protected T getStage() {
        return t;
    }
}

