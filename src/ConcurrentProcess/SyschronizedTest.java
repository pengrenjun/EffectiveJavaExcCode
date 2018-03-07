package ConcurrentProcess;

import java.util.concurrent.TimeUnit;

public class SyschronizedTest {




   /* //threadFlag数据的读写并不同步,无法保证累加进程能实时同步threadFlag值的变化,需要对threadFlag的读写进行数据同步处理

    private static  Boolean threadFlag=false;

    private static  int count;

    public static void main(String[] args) throws InterruptedException {

        //设置累加进程
        Thread addthread=new Thread(new Runnable() {
            @Override
            public void run() {
              while (!threadFlag){
                  count++;
                  System.out.println(count);

              }
            }
        });

        //开启进程
        addthread.start();

        //主进程控制累加进程
        TimeUnit.SECONDS.sleep(2);

        threadFlag=Boolean.TRUE;

    }*/


   /*
   //读写方法进行同步处理
   private static  Boolean threadFlag=false;
    private static  int count;

    private  static synchronized void setThreadFlag(){
        threadFlag=true;
    }

    private  static synchronized   Boolean getThreadFlag(){
       return threadFlag;
    }



    public static void main(String[] args) throws InterruptedException {
        //设置累加进程
        Thread addthread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (!getThreadFlag()){
                    count++;
                    System.out.println(count);

                }
            }
        });

        //开启进程
        addthread.start();

        //主进程控制累加进程
        TimeUnit.SECONDS.sleep(2);

        setThreadFlag();
    }*/

   //使用volatile关键字,保证读取的数据是最近刚刚处理的数据
    private static  volatile   Boolean threadFlag=false;

    private static  int count;

    public static void main(String[] args) throws InterruptedException {

        //设置累加进程
        Thread addthread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (!threadFlag){
                    count++;
                    System.out.println(count);

                }
            }
        });

        //开启进程
        addthread.start();

        //主进程控制累加进程
        TimeUnit.SECONDS.sleep(2);

        threadFlag=Boolean.TRUE;

    }








}
