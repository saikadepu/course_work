/* Test code outside the package*/
package travlist;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class StackTravList<E> implements Iterable<E> {

    private Stack<E> left, right;

    public StackTravList() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void insert(E elem) {
        if (elem == null) throw new NullPointerException();
        right.push(elem);
    }

    public E remove() {
        if (right.isEmpty()) throw new IllegalStateException();
        return right.pop();
    }

    public void advance() {
        if (right.isEmpty()) throw new IllegalStateException();
        left.push(right.pop());
    }

    public void reset() {
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
    }

    public int leftLength() {
        return left.size();
    }

    public int rightLength() {
        return right.size();
    }

    public Iterator<E> iterator() {
        return new TLGen();
    }

    private class TLGen implements Iterator<E> {

        private int pos;
        private boolean done; // NOTE: I found this useful; is it necessary?

        public TLGen() {
            // TODO Implement this constructor
            // NOTE Access outer class by using "StackTravList.this"
            pos = StackTravList.this.leftLength();
            done = false;
            StackTravList.this.reset();
        }

        @Override
        public boolean hasNext() {
            // TODO Implement this method
            // NOTE Access outer class by using "StackTravList.this"

           if( StackTravList.this.rightLength() != 0)
                return true;
            else
            {
                StackTravList.this.reset();
                for(int i=0;i<pos;i++)
                    StackTravList.this.advance();
                return false;
            }

        }

        @Override
        public E next() {
            E result;

            // TODO Implement this method
            // NOTE Access outer class by using "StackTravList.this"
            if(!hasNext()) throw new NoSuchElementException();

                result = StackTravList.this.remove();
                StackTravList.this.insert(result);
                StackTravList.this.advance();
                return result;
        }
    }
    @Override
    public String toString() {
        int counter = 0;
        int pos = this.leftLength();
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (E elem : this) { // NOTE: iterator in progress while this loop is running
            if (counter == pos) sb.append("| ");
            sb.append(elem.toString() + " ");
            counter++;
        }
        if (counter == pos) sb.append("| ");
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackTravList<String> s = new StackTravList<>();
        s.insert("F");
        s.insert("E");
        s.insert("D");
        s.insert("C");
        s.insert("B");
        s.insert("A");
        System.out.println(s.toString());
        s.advance();
        s.advance();
        s.advance();
        System.out.println(s.toString());
        s.advance();
        s.advance();
        s.advance();
        System.out.println(s.toString());
    }
}
