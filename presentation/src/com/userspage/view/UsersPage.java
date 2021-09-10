package com.userspage.view;

import com.loginpage.view.IPage;
import com.userspage.viewmodel.ViewModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class UsersPage<U,T extends Stage> extends Scene implements IPage<U,T>{
    ViewModel vm;
    private Stage _stage;
    TableView tableView;
    public UsersPage(Parent parent, double v, double v1) {
        super(parent, v, v1);
          tableView = new TableView();

        TableColumn<User, String> column1 = new TableColumn<>("name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<User, String> column2 = new TableColumn<>("authkey");
        column2.setCellValueFactory(new PropertyValueFactory<>("authkey"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        VBox vbox = new VBox(tableView);
        this.setRoot(vbox);
        //this._stage = parent.;
        setupMVVM();
    }
    void setupMVVM() {
        vm = new ViewModel<IPage>();
        vm.setpresenter(this);
        try {
            vm.run();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public void res(U args) {
  ((HashMap)args).forEach((k,v)->
  {
      tableView.getItems().add(new User(k.toString(), v.toString()));

  });

    }
}
