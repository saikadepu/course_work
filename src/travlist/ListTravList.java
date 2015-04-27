package travlist;

import java.util.LinkedList;
import java.util.List;

public class ListTravList<E> extends AbstractTravList<E> {

	List<E> elements;
	int pos;
	
	public ListTravList() {
		// TODO Implement this constructor
        elements = new LinkedList<>();
        pos =0;
	}

	@Override
	public void insert(E elem) throws NullPointerException {
		// TODO Implement this method
        if(elem == null)
            throw new NullPointerException("Null values are not allowed");
        else
            elements.add(this.pos, elem);
	}

	@Override
	public E remove() throws IllegalStateException{
		// TODO Implement this method
        E temp;
        if(this.pos>this.elements.size()-1)
            throw new IllegalStateException("The right list is empty.");
        else
            temp = this.elements.remove(this.pos);

		return temp;
	}

	@Override
	public void advance() throws IllegalStateException {
		// TODO Implement this method
        if(this.pos>this.elements.size()-1)
            throw new IllegalStateException("The right list is empty.");
        else
            this.pos++;

	}

	@Override
	public void reset() {
		// TODO Implement this method
        this.pos = 0;
	}

	@Override
	public int leftLength() {
		// TODO Implement this method

		return this.pos;
	}

	@Override
	public int rightLength() {
		// TODO Implement this method
        int length = this.elements.size();
		return length-this.pos;
	}	

	// ==========================================================
	// Object Methods
	// ==========================================================
	
	@Override
	public boolean equals(Object o) {
		// TODO Implement this method
        ListTravList<E> temp = (ListTravList<E>)o;
        boolean areElementsEqual = this.elements.equals(temp.elements);
        boolean isCursorSame = false;
        if(this.pos == temp.pos )
            isCursorSame = true;
		return ( areElementsEqual && isCursorSame);
	}
	
	@Override
	public int hashCode() {
        /*int result = 3;
        System.out.println("elements:" + elements);
        int num;
        if(elements == null)
            num =0;
        else
         num =elements.hashCode();
		// TODO Implement this method
        result = 31 * result + num;
        return result;*/

        int result = 3;
        // TODO Implement this method
        int length = leftLength()+rightLength();
        int calcHash=0 ;
        for(int i =0;i<length;i++)
        {
            E temp = this.elements.get(i);
            calcHash += temp.hashCode();
        }

        result = 31 * result + calcHash;
        return result;
	}
	
	@Override
	public String toString() {
		// TODO Implement this method
        StringBuffer str= new StringBuffer();
        for(E listElement : this.elements) {
            str.append(listElement);
           // if(listElement!=null)
             //   str.append("-->");
        }
		return str.toString();
	}



}
