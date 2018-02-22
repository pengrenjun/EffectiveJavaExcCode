package FunctionNote;

import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * 子类重写父类的方法,当通过父类调用子类方法时,父类的方法会被子类所覆盖
 * */
public class overideFunctionTest {



    public static void main(String[] args) {
        printString[] strFuns={new printString(),new upPrintStr(),new concatPrintStr()};
        List<printString> list= Arrays.asList(strFuns);
        list.forEach(printString -> printString.soutStr("qwe"));

    }
}

class printString{

    public void soutStr(String str){
        System.out.println(str);
    }
}

class upPrintStr extends printString{
    @Override
    public void soutStr(String str) {
        super.soutStr(str.toUpperCase());
    }
}

class concatPrintStr extends printString{
    @Override
    public void soutStr(String str) {
        super.soutStr(str.concat("重写方法测试"));

    }
}
