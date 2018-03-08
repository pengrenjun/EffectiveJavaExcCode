package Serializable;

/*在创建对象之前,提供对成员变量进行初始化约束的通用实现方法 AbstractExample为其实现类实现序列化读写约束规范要求提供了可能 */

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public abstract class  AbstractExample implements Serializable {


    private static final long serialVersionUID = 8848431505957553062L;

    //state
    private int  x;
    private  String y;

    //创建变量初始化约束规范实现跟踪的枚举
    private static  enum state{NEW,INITING,INITED};

    //创建枚举的原子引用(线程安全状态机的通用实现方法)

    private final AtomicReference<state> initReference=new AtomicReference<state>(state.NEW);



    //AbstractExample继承类的成员变量初始化要符合约束条件的实现方法:

    protected AbstractExample() {

    }

    //对构造器进行改造,完成约束限制的要求
    public AbstractExample(int x, String y) {
       initVars(x,y);
    }


   protected final void  initVars(int x,String y){

       //判断是否已经完成的初始化约束规范要求
       if(!initReference.compareAndSet(state.NEW,state.INITING)){
           throw  new IllegalStateException("VARS(X,Y) INITED ");
       }


       /*填写对x,y初始化的约束规法代码 这部分代码也可以放在成员变量的set方法中 也可以放在checkInit()中*/
       if(x<0){  throw  new IllegalStateException("x<0 required x>=0 ");}
       if(y.length()>10000){throw  new IllegalStateException("y.length()>10000");}
       this.x = x;
       this.y = y;

       initReference.set(state.INITED);

   }

   /* protected final void setX(int x) {
        checkInit();
        this.x = x;
    }

    protected final void setY(String y) {
        checkInit();
        this.y = y;
    }*/

    protected final  int getX() {
        checkInit();
        return x;
    }


    protected final  String getY() {
        checkInit();
        return y;
    }

    //校验成员变量是否已完成约束条件限制 所有的公用和私用的方法再调用成员变量之前都调用checkInit 进行约束校验
    private void checkInit() {
        if (initReference.get()!=state.INITED) {
            throw  new IllegalStateException("VARS(X,Y) UNINITED ");
        }
    }
}
