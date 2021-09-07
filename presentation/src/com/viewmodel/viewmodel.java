package com.viewmodel;

import com.view.Ipresentation;
import javafx.scene.Scene;

public class viewmodel {
    viewmodel v = null;
    Ipresentation t = null;

    public viewmodel() {
        v = this;
    }

    viewmodel getViewmodel() {
        return this;
    }

    public void setpresenter(Ipresentation t) {
        this.t = t;
    }

    public void setroute(Scene s){
        this.t.getStage().setScene(s);
    }

}
