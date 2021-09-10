package model;

import IO.fordatalayer.IDataLayer;

import java.util.HashMap;
import java.util.Random;

public class UserRepository<T,R extends HashMap> implements IDataLayer<R> {

    public R data;

    @Override
    public R getusers() {
        data = (R) new HashMap<String,String>();
        for (int i = 0; i < 100000; i++) {
            data.put("testuser:"+i, (new Random().nextInt(99999))+"");
        }
        return data;
    }

}
