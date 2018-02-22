package FunctionNote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class ArgsFuncTest {


    public static void main(String[] args) {

       Integer a=1;
       Integer b=2;
       ArgsFuncTest.soutInteger(a,b,"asd");

       List arrayList=new ArrayList();




    }

    //可变参数类型在jdk 1.5之后引用 以数组形式进行参数传递
    public static<T > void soutInteger(T...args){

        List<T> list= Arrays.asList(args);
       /* public static <T> List<T> asList(T... a) {
            return new ArrayList<>(a);
        }*/
        list.forEach(alist-> System.out.println(alist.getClass()));
        System.out.println(list);

        System.out.println(Arrays.toString(args));
       /* public static String toString(Object[] a) {
            if (a == null)
                return "null";

            int iMax = a.length - 1;
            if (iMax == -1)
                return "[]";

            StringBuilder b = new StringBuilder();
            b.append('[');
            for (int i = 0; ; i++) {
                b.append(String.valueOf(a[i]));
                if (i == iMax)
                    return b.append(']').toString();
                b.append(", ");
            }
        }*/

        
    }
}
