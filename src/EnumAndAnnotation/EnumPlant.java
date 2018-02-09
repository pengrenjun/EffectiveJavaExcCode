package EnumAndAnnotation;

public enum EnumPlant {
    //枚举常量集合(后面的参数就是传递给构造器的参数)
    //提供了质量mass 半径radius
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);
    //私有域 mass radius对应枚举常量的两个值
    private final double mass;
    private final double radius;
    //私有域surfaceGravity 通过创建枚举类的构造器自动计算所得
    private final double surfaceGravity;

    private static final double G = 6.67300e-11;
    //枚举的构造器,将数据和枚举常量关联起来,参数值来自于枚举常量集合
     EnumPlant(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    //枚举提供的方法
    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {//F=ma
        return mass * surfaceGravity;
    }

}
