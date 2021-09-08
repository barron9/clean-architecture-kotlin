package usecases;

import javafx.scene.Scene;

import java.util.HashMap;

public abstract class IBusinessUseCase<T extends Page> {

    HashMap<String, String> container = new HashMap<>();
    T t = null;

    public HashMap<String,String> defaultExecute(String var1,String var2 ){
        container.put(var1,var2);
        return container;
    };
    public void setpresenter(T t) {
        this.t = t;
    }
    public abstract void run();

    public void setroute(Scene s){
        this.t.getStage().setScene(s);
    }
}
