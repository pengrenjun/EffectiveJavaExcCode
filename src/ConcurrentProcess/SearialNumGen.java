package ConcurrentProcess;

/*产生不同的序列号*/
public class SearialNumGen {

    private static  /*volatile */ long searialNum;

    private static synchronized long getSearialNum(){
        return searialNum++;
    }

    public static  void startThread(){
      /*  Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A:"+ getSearialNum()+" "+System.currentTimeMillis());
            }
        });

        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B:"+ getSearialNum()+" "+System.currentTimeMillis());
            }
        });


        Thread threadC=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("C:"+ getSearialNum()+" "+System.currentTimeMillis());
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();*/

        for(int i=0;i<10000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("B:"+ getSearialNum()+" "+System.currentTimeMillis());
                }
            }).start();
        }

    }

    public static void main(String[] args) {

        startThread();

    }
}
