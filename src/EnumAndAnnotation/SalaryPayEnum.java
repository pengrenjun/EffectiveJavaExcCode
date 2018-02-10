package EnumAndAnnotation;

//计算方法:工作日超过8个小时有加班费,休息日每个小时都有加班费
//采用策略枚举策略,有利于计算方式的扩展
public enum SalaryPayEnum {


    Mon(PayWay.WeekDay),TUS(PayWay.WeekDay),WEN(PayWay.WeekDay),THU(PayWay.WeekDay),FRI(PayWay.WeekDay),SAT(PayWay.Weekend),SUN(PayWay.Weekend);


    //为每个工作日配置策略枚举(枚举构造器为枚举绑定策略枚举)
    //参数为私有的策略枚举PayWay(私有域)
    private final  PayWay payWay;

    SalaryPayEnum(PayWay payWay) {
        this.payWay = payWay;
    }

    //私有的工资计算方法(具体实现过程委托给策略枚举进行实现)
    private double getSalary(double workhours, double hourPay) {//工作时间,每小时工资
        //调用策略枚举的工资计算方法
        return payWay.getSalary(workhours,hourPay);
    }


    //策略枚举:通过创建抽象方法,采用特定于常量的实现方法计算两种策略的加班费用
    private enum PayWay{
       WeekDay {

            double overbasehourPay(double overhours, double hourPay) {
               return overhours*hourPay*1.5;
           }
       },
        Weekend {

             double overbasehourPay(double overhours, double hourPay) {
                return overhours*(overhours+basehour)*hourPay*1.6;
            }
        };


       //抽象方法,实现特定常量实现
       abstract  double overbasehourPay(double overhours,double hourPay);


       private static final int basehour=8;//规定工时



       //基本工资+加班费用(特定枚举常量实现)
       private  double getSalary(double workhours, double hourPay) {//工作时间,每小时工资

            return workhours*hourPay+overbasehourPay(workhours-basehour<=0?0:workhours-basehour,hourPay);
        }


    }



    public static void main(String[] args) {

        System.out.println("salaryPay: "+SalaryPayEnum.Mon.getSalary(9,100));

    }



}


