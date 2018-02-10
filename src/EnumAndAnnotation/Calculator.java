package EnumAndAnnotation;

public class Calculator {

    //公有静态成员类 Enum类默认为静态类 static
    /**
     * 这个枚举有局限:如果添加枚举类型,但在switch里没有为其添加相应方法就会有问题,其次这个方法是通过抛异常来解决问题的
     * */
    public  enum optionA{

        PLUS,MINUTE,MUTIPLY,DIVIDE;

        //行为与常量值相结合
        double apply(double x,double y){

            switch (this){


                case PLUS:return x+y;
                case MINUTE:return x-y;
                case MUTIPLY:return x*y;
                case DIVIDE:return x/y;
            }

            throw  new AssertionError("UNDEFINED OP"+this);

        }

    }

    /**
     * 对optionA进行改进:特定于常量方法的实现
     * */

    public enum optionB{

        PLUS {double apply(double x,double y){ return  x+y;}},
        MINUS{double apply(double x,double y){return x-y;}},
        MUTIPLY{double apply(double x,double y){return  x*y;}},
        DIVIDE{double apply(double x,double y){return x/y  ;}};

        //声明抽象方法 枚举里的抽象方法必须在它的常量方法中实现,这是特定于常量方法实现的前提
        abstract  double apply(double x,double y);


    }

    /**
     * 对optionB进行改进:特定于常量方法的实现,重写toString方法来返回与该操作关联的操作符
     * */
    public enum optionC{

        PLUS("+") {double apply(double x,double y){ return  x+y;}},
        MINUS("-"){double apply(double x,double y){return x-y;}},
        MUTIPLY("*"){double apply(double x,double y){return  x*y;}},
        DIVIDE("/"){double apply(double x,double y){return x/y  ;}};

        //声明抽象方法 枚举里的抽象方法必须在它的常量方法中实现,这是特定于常量方法实现的前提
        abstract  double apply(double x,double y);
        //为枚举常量绑定操作符
        private String symbol;

        optionC(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }



    public static void main(String[] args) {

        System.out.println(optionA.MUTIPLY.apply(3,2));

        System.out.println(optionB.MUTIPLY.apply(1,2));

        //对optionC进行打印测试
        for(optionC oc:optionC.values()){

            System.out.printf("%s %s %s=%s %n",100,oc.toString(),10,oc.apply(100,10));
        }
    }
}
