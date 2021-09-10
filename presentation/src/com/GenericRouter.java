package com;

import com.loginpage.view.IPage;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class GenericRouter<T extends IPage> {
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

    protected abstract void run();

    protected T getStage() {
        return t;
    }
}

