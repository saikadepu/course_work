import java.util.ArrayList;
import java.util.List;

/**
 * Created by saikumaradepu on 2/11/15.
 */
public class SequenceDemo {
    public static void main(String args[])
    {

        Sequence<String> seq = new Sequence<>();
       Sequence<String> xyz=  seq.add("Hello");
        Sequence<String> y= xyz.add("temp");
        Sequence<String> indexTest = y.add(1,"SaiK");
        Sequence<String> beforeRemove = indexTest.add("Adepu");
        Sequence<String> afterRemove = beforeRemove.remove(2);
        Sequence<String> addAgain = afterRemove.add("dhadael");
        System.out.println("Size: "+addAgain.size());
        System.out.println("Get Element: "+addAgain.get(3));
        Sequence<String> setElment = addAgain.set(0,"set");
        System.out.println("Get Element: "+addAgain.get(3));

    }
}
