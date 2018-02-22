package FunctionNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListSetTest {

    public static void main(String[] args) {

        Set<Integer> set=new TreeSet<>();
        List<Integer> list=new ArrayList<>();

        for(int i=-3;i<3;i++){
            set.add(i);
            list.add(i);
        }

       for(int i=0;i<3;i++){

            set.remove(i);
            /**
             * list中的remove方法进行了重载,选择时需要结合API进行选择,这种重载情况在jdk api中不是很多见
             * 泛型,自动拆装箱对重载方法有一定影响,使用时需要结合api进行选择
             * */
            //list.remove(i);//Removes the element at the specified position in this list
           list.remove((Integer)i);
       }

        System.out.println(set+" "+list);// boolean remove(Object o);


    }
}
