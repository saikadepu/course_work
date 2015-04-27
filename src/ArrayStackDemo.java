import java.util.Stack;

import static java.util.Objects.isNull;

/**
 * Created by saikumaradepu on 2/7/15.
 */
public class ArrayStackDemo {
    public static void main(String args[])
    {
        ArrayStack<String> test= new ArrayStack<String>(5);
        test.push("Hello");
        test.push("World");
        test.push("Gmu");
       /* //System.out.println("Pop: " +test.pop());
        //test.flip();
        //System.out.println("Pop after flip: " +test.pop());
        //test.push(1018);
        System.out.println("Depth: " + test.depth());
        test.push(1079);
        System.out.println("Depth: "+test.depth());
        System.out.println("Capacity: " + test.capacity());
*/
       test.flip();
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());


     /*   Stack testStack = new Stack();
        testStack.push(63);
        testStack.push(23);
        testStack.push(30);
        testStack.push(19);
        test.transferTop(testStack);
        System.out.println("Depth: "+test.depth());
        System.out.println("transfer top: "+test.pop());
        System.out.println("Depth: "+test.depth());

        test.push(16);
        test.push(07);
        test.replaceTop(22);
        System.out.println("replace top: "+test.pop());
*/
    }
}
