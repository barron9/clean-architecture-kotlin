package com;

import io.reactivex.Flowable;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.Callable;
//import com.view.MainGUI;
public class main implements Ibusiness{
    static data m2 = null;

    public static void main(String... args) {
        new main();
    }
    main(){
        if (m2==null)
            m2 = new data();
        //run();
       // new MainGUI();
    }
    public void run() {

        Flowable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                byte[] array = new byte[12]; // length is bounded by 7
                new Random().nextBytes(array);
                return new String(array, Charset.forName("UTF-8"));
            }
        })
                //.observeOn(Schedulers.io())
                .doOnNext(System.out::println)
                .doOnNext(System.out::println)
                .doOnNext(System.out::println)
                .doOnNext(System.out::println)
                .doOnNext(System.out::println)
                .all(m2::process)
                .subscribe();

    }
}
//  System.out.println("out");
//main2.main2("a","ads","ddd","tre");

 /*       Flowable.fromCallable(() -> {
            Thread.sleep(8000); //  imitate expensive computation
            m.gt("adsa");
            return "Done";
        })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.single())
                .blockingSubscribe(main2::main2, Throwable::printStackTrace);
*/


       /* Flowable.range(1, 10)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe( System.out::println,Throwable::printStackTrace);

*/


// Thread.sleep(2000); // <--- wait for the flow to finish

//  main2.main2("a","ads","ddd","tre");