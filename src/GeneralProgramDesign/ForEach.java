package GeneralProgramDesign;//测试
 
import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEach {

    enum enum1 {

        A,B,C,D;
    }

    enum enum2 {

        j,q,k;
    }


    public static void main(String[] args) {

        List<enum1> list1= Arrays.asList(enum1.values());

        List<enum2> list2=Arrays.asList(enum2.values());

       /*
        Exception in thread "main" java.util.NoSuchElementException

        for(Iterator<enum1> i1 = list1.iterator(); i1.hasNext();){

            for(Iterator<enum2> i2=list2.iterator();i2.hasNext();){
                System.out.println(i1.next()+" "+i2.next()); 这里面的next()已经将i1的迭代位置移动了,需要将i1.next()移到循环的外面
            }
        }*/
        for(Iterator<enum1> i1 = list1.iterator(); i1.hasNext();){

            enum1 value=i1.next();//迭代器的next()不能放入另一个循环中,迭代器的next()在循环中一般只用一次
            for(Iterator<enum2> i2=list2.iterator();i2.hasNext();){
                System.out.println(value+" "+i2.next());
            }
       }



       for(enum1 e1:list1){
            for(enum2 e2:list2){
                System.out.println("for-each: "+e1+" "+e2);
            }
       }
 }
}
