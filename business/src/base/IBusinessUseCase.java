package base;


import java.util.HashMap;
import java.util.Map;

public abstract class IBusinessUseCase {

    HashMap<String, String> container = new HashMap<>();

    public Map<String, String> defaultExecute(String var1, String var2) {
        container.put(var1, var2);
        return container;
    }


    public abstract void run();

   /* public void setroute(Scene s) {
        ((Stage) (this.t.getStage())).setScene(s);
    }*/
}
