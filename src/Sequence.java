/**
 * Created by saikumaradepu on 2/11/15.
 */
import java.util.List;
import  java.util.ArrayList;
public class Sequence<E> {
    //OVERVIEW: Sequence is an immutable type, which implements Arraylist.
    private List<E> s;
    public Sequence() {
        //Effects: initializes this to be an ArrayList with zero elements

        s = new ArrayList<>();
    }
    public Sequence<E> add(E element) throws NullPointerException {

        //EFFECTS: throw a NullPointerException If 'element' is NULL,
        //          else return a new list with this + element

    Sequence<E> newSequence = new Sequence<>();
    if(element == null)
        throw new NullPointerException("Element cannot be null");
    else{
            for(E listElement : this.s){
                newSequence.s.add(listElement);
            }
        newSequence.s.add(element);
    }

        return newSequence;

    }
    public Sequence<E> add(int index, E element) throws NullPointerException,IllegalArgumentException {

        //EFFECTS: if element is NULL, throw a NullPointerException,
        //         Else if,  index <0 or index> size of this list throw IllegalArgumentException
        //          else return a new list with this+element, where element is added at the specified index

        Sequence<E> newSequence = new Sequence<>();
        if(element == null)
            throw new NullPointerException("Element cannot be null");
        else if(index <0 || index > this.s.size())
            throw new IllegalArgumentException("Please check the range of index");
        else {
            for (E listElement : this.s) {
                newSequence.s.add(listElement);
            }
            newSequence.s.add(index, element);
        }

        return newSequence;

        }
   public Sequence<E> remove(int index) throws IllegalArgumentException//*----*,IllegalStateException
     {

        //EFFECTS: if index <0 or index > size of this list, throw IllegalArgumentException
         //     else return a new list with this - element at specified index

         Sequence<E> newSequence = new Sequence<>();
         if(index<0 || index > this.s.size())
             throw new IllegalArgumentException("Index is out of range");
         else{
             for (E listElement : this.s){
                 newSequence.s.add(listElement);
             }
         newSequence.s.remove(index);
         }

         return newSequence;
    }

    public Sequence<E> set(int index, E element) throws NullPointerException,IllegalArgumentException {

        //EFFECTS: if element is null, throw NullPointerException
        //      else if, index <0 or index >= size of this list then throw IllegalArgumentException
        // else set 'element' to the element at specified index
        Sequence<E> newSequence = new Sequence<>();
        if(element == null)
            throw new NullPointerException();
        else if(index <0 || index >= this.s.size())
            throw new IllegalArgumentException("Index is out of range");
        else {
            for(E listElement : this.s ){
                newSequence.s.add(listElement);
            }
            newSequence.s.set(index,element);
        }
         for(E listElement : newSequence.s)
             System.out.println(listElement);
        return newSequence;


    }
    public E get(int index) throws IllegalArgumentException {

        //EFFECTS: if index<0 or index >= size of this, throw IllegalArgumentException
        //      else return the element at specified index
        if(index < 0 || index >= this.s.size())
            throw new IllegalArgumentException("Index is out of range");
        return this.s.get(index);
    }

    public int size() {

        //EFFECTS: returns size of this

        return this.s.size();
    }

}
