package ConcurrentProcess;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;

public class ConcurrentCollection  {

    private static ConcurrentMap<String,String>  concurrentMap=new ConcurrentHashMap<>();


    public static void main(String[] args) {

        String str=concurrentMap.putIfAbsent("123","qwe");
        String stra=concurrentMap.putIfAbsent("123","qwe");

        System.out.println(str+" "+stra);


    }




}
