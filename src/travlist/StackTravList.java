package travlist;

import java.util.Stack;

public class StackTravList<E> extends AbstractTravList<E> {
	
	private Stack<E> left;
	private Stack<E> right;
	
	public StackTravList() {
		// TODO Implement this constructor
        left = new Stack<>();
        right = new Stack<>();
        int pos=0;
	}
	
	@Override
	public void insert(E elem) throws NullPointerException {
		// TODO Implement this method
        if(elem==null)
            throw new NullPointerException("Element passed is null");
        else
         right.push(elem);

	}

	@Override
	public E remove() throws IllegalStateException {
		// TODO Implement this method
        E temp=null;
        if(right.empty())
            throw new IllegalStateException("RIght list is empty");
        else
            temp =right.pop();

		return temp;
	}

	@Override
	public void advance() throws IllegalStateException{
		// TODO Implement this method
        if(right.empty())
            throw new IllegalStateException("The right list is empty");
        else
        {
            E temp = right.pop();
            left.push(temp);
        }
	}

	@Override
	public void reset() {
		// TODO Implement this method
        while(!left.empty())
        {
            E temp = left.pop();
            right.push(temp);
        }

	}

	@Override
	public int leftLength() {
		// TODO Implement this method
		return left.size();
	}

	@Override
	public int rightLength() {
		// TODO Implement this method
		return right.size();
	}
	
	// ==========================================================
	// Object Methods
	// ==========================================================
	
	@Override
	public boolean equals(Object o) {
		// TODO Implement this method
        StackTravList<E> temp = (StackTravList<E>)o;
        boolean areElementsEqual = this.left.equals(temp.left) && this.right.equals(temp.right);
        boolean isCursorSame = false;
        if(rightLength()==temp.rightLength())
            isCursorSame =true;
		return (areElementsEqual && isCursorSame);
	}
	
	@Override
	public int hashCode() {
		// TODO Implement this method
        int result = 3;
       /*// int l,r;
        int length = leftLength()+rightLength();
        E[] mergeLeftRight  = (E[])new Object[length];
        int i =0;
        for(int j=0; j<=left.size()-1; j++)
        {
            mergeLeftRight[i] = this.left.get(j);
            i++;
        }
        for(int k=rightLength()-1;k>=0;k--)
        {
            mergeLeftRight[i] = this.right.get(k);
            i++;
        }*/
        int calcHash=0 ;
        int leftLen = leftLength();
        int rightLen = rightLength();

        for(int i =0;i<leftLen;i++)
        {
            E temp = this.left.get(i);
            calcHash += temp.hashCode();
        }

        for(int j =0;j<rightLen;j++)
        {
            E temp = this.right.get(j);
            calcHash += temp.hashCode();
        }

        result = 31 * result + calcHash;
        return result;

	}
	
	@Override
	public String toString() {
		// TODO Implement this method
        StringBuffer str = new StringBuffer();
        for(E stackElementLeft: this.left)
        {
            str.append(stackElementLeft);
            //str.append("-->");
        }
        for(int i=rightLength()-1;i>=0;i--)
        {
            //ingBuffer stringRight = new StringBuffer();
            str.append(right.get(i));
        }
       /* for(E stackElementRight : this.right)
        {
            str.append(stackElementRight);
            //str.append("-->");
        }*/

		return str.toString();
	}

    public void flip()
    {
        super.flip();
        int length = rightLength();
        for (int i =0; i<length;i++)
        {
            E temp =right.pop();
            left.push(temp);
        }
    }
}
