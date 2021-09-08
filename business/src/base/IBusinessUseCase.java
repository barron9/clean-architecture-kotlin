package base;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public abstract class IBusinessUseCase<T extends Page<?>> {

    HashMap<String, String> container = new HashMap<>();
    T t = null;

    public HashMap<String, String> defaultExecute(String var1, String var2) {
        container.put(var1, var2);
        return container;
    }

    public T defaultExecute() {
        return t;
    }

    public void setpresenter(T t) {
        this.t = t;
    }

    public T getpresenter() {
        return t;
    }

    public abstract void run();

    public void setroute(Scene s) {
        ((Stage) (this.t.getStage())).setScene(s);
    }
}
