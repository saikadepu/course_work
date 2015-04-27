import java.util.Stack;

/**
 * Created by saikumaradepu on 2/6/15.
 */

public class ArrayStack<E> {

    private int sizeOfStack, top;
    private E[] arrayStack;

    public ArrayStack(int capacity) throws IllegalArgumentException {
    // REQUIRES: capacity > 0
    // EFFECTS: Throws  IllegalArgumentException if   capacity is less than  0
    //  else, create a new Stack with the specified capacity

        if(capacity < 0)
            throw new IllegalArgumentException("capacity should be greater than zero");

        this.sizeOfStack = capacity;
        this.arrayStack = (E[])new Object[sizeOfStack];
        this.top = -1;
        //arrayStack =  Array.newInstance(this.getClass(),capacity);
    }
    public void push(E element) throws NullPointerException,IllegalStateException {

    // EFFECTS: If element is NULL, throw NullPointerException,
    //      else if the Stack is full, throw IllegalStateException,
    //      else add the Element to the ArrayStack
    // MODIFIES: this
        if(element == null || element == "")
            throw new NullPointerException();
        else if (top==this.arrayStack.length-1)
            throw new IllegalStateException("The stack is full");
        else {
            //top++;
            //System.out.println("in push" + top);
            this.arrayStack[++top] = element;
        }
    }
    public E pop() throws IllegalStateException{
    // EFFECTS: If there are no elements in the Stack, throw IllegalStateException
    //  else, return the top element in the Stack
    // MODIFIES: this
        if(top==-1)
            throw new IllegalStateException("The stack is empty");
        E topElement = this.arrayStack[top];
        this.arrayStack[top--] = null;
        return topElement;
    }
    public int depth() {
        // EFFECTS: returns the number of elements stored currently in the stack
        return top+1;
    }
    public int capacity() {
        // EFFECTS: returns the number of elements that the stack can store
        return this.sizeOfStack;
    }
    public void flip() {
    // EFFECTS: reverses the elements of the stack
    //MODIFIES: modifies 'this'
        int startOfStack = 0, endOfStack =this.arrayStack.length-1;
        while(startOfStack<endOfStack)
        {
            E temp = this.arrayStack[startOfStack];
            this.arrayStack[startOfStack] = this.arrayStack[endOfStack];
            this.arrayStack[endOfStack] = temp;
            startOfStack++;
            endOfStack--;
            this.top= this.arrayStack.length-1;
        }
    }
    public void transferTop(Stack<E> s) throws NullPointerException,IllegalStateException{
    // EFFECTS: If Stack s is NULL, throw NullPointerException,
        //      else if the current Stack is full, throw IllegalStateException,
    // else transfer the element from the top of stack s to the top of the current stack (this)

        //MODIFIES: this
        if(s==null)
            throw new NullPointerException();
        else if (top==this.arrayStack.length-1)
            throw new IllegalStateException("The current stack is full");
        else
            this.arrayStack[++top]=  s.peek();

    }
    public E replaceTop(E element) throws NullPointerException{
        // EFFECTS: If element is NULL, throw NullPointerException,
        // else replace the top element with 'element' and return the original top element.
        // MODIFIES: this

        if(element == null)
            throw new NullPointerException();
        E originalTop = this.arrayStack[top];
        this.arrayStack[top] = element;
        return  originalTop;

    }
}
