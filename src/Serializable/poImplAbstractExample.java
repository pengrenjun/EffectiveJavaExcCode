package Serializable;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*AbstractExample的实现类,符合读写约束规范的实现类*/
public class poImplAbstractExample extends AbstractExample implements Serializable {


    private static final long serialVersionUID = 576567009347197819L;

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        int x=inputStream.readInt();
        String y= String.valueOf(inputStream.readChar());
        initVars(x,y);
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(getX());
        outputStream.writeObject(getY());

    }

    public poImplAbstractExample(int x, String y) {
        super(x, y);
    }


}



