package com

import com.di.DaggerAppComp
import com.cachedata.DataCacheFactory
import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import usecases.DefaultUseCase
import javax.inject.Inject


class View: Application() { // javafx window

    //add observers to get response back from viemodels methods
    // (single <T>'s or observable<T> 's from domain-interops )

    //add viemodel factory

    //call viewmodel methods upon user interaction

    //add oberservers which observes the UI/user interaction
    @Inject
    lateinit var dcf: DataCacheFactory

    @Inject
    lateinit var duc: DefaultUseCase
    private var _stage: Stage? = null

    companion object {
        init {
            println(this)

        }


    }

    init {
        DaggerAppComp.create().inject(this)
        dcf.getCar().subscribe(::println)
        duc.exec()
    }

    override fun start(primaryStage: Stage?) {
        this._stage = primaryStage!!
        setupUI()
    }

    fun setupUI() {
        val javaVersion = System.getProperty("java.version")
        val javafxVersion = System.getProperty("javafx.version")
        val l = Label("Hello, JavaFX $javafxVersion, running on Java $javaVersion.")
        val b = Button("Authorize")
        val tf = TextField()
        //tf.textProperty().bind(Bindings.convert(l.textProperty()));
        // l.textProperty().bind(Bindings.convert(tf.textProperty()));
        tf.setPromptText("email address")
        val pw = PasswordField()
        pw.promptText = "password"
        val iv2 =
            ImageView(Image("http://icons.iconarchive.com/icons/kidaubis-design/cool-heroes/128/Starwars-Stormtrooper-icon.png"))
        iv2.setFitWidth(100.0)
        iv2.setPreserveRatio(true)
        iv2.setY(50.0)
        b.setMinWidth(300.0)
        val root = GridPane()
        root.alignment = Pos.TOP_CENTER
        root.vgap = 20.0
        root.addRow(2, l)
        root.addRow(1, iv2)
        root.addRow(3, tf)
        root.addRow(4, pw)
        root.addRow(5, b)
        val scene = Scene(root, 640.0, 380.0)

        //    b.onMouseClickedProperty().bind();
        b.setOnMouseClicked { mouseEvent ->
            try {
                //new run();
                //Scene scene2 = new Scene(new GridPane(), 640, 380);
                //vm.setroute(scene2);
                //vm.run()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        _stage!!.scene = scene
        _stage!!.title = "demo"
        _stage!!.show()
    }
}