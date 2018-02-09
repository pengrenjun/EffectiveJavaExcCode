package EnumAndAnnotation;

import java.math.RoundingMode;

public class EnumPlantTest {
    public static void main(String[] args) {

       //EnumPlant枚举类测试

        //取得半径
        System.out.println(EnumPlant.MARS.mass());
        //计算表面质量
        System.out.println(EnumPlant.MARS.surfaceWeight(EnumPlant.MARS.mass()));

        //给出物体在地球表面的质量求其在其他星球的表面总量
        final double mass=100;
        //EnumPlant.values()得到枚举常量的值数组
        for (EnumPlant plant:EnumPlant.values()) {
            //printf写法采用了Stingformat的写法,可以向字符串内赋值
            System.out.printf("surfaceWeight on %s = %s %n",plant,plant.surfaceWeight(mass));
            
        }



    }
}
