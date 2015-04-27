package travlist;

public abstract class AbstractTravList<E> implements TravList<E> {

	public E get() throws IllegalStateException{
		// TODO Implement this method
        E temp = null;
        if(rightLength()==0)
            throw new IllegalStateException("The right list is empty");
        else
        {
            temp = remove();
            insert(temp);
        }
		return temp;
	}
	
	public E set(E element) throws NullPointerException,IllegalStateException{
		// TODO Implement this method
        E temp = null;
        if(element==null)
            throw new NullPointerException("element is null");

        else if(rightLength()==0)
            throw new IllegalStateException("The right list is empty.");
        else
        {
            temp = remove();
            insert(element);
        }

        return temp;
	}
	
	public void splice(TravList<E> that) throws IllegalArgumentException, NullPointerException {
		// TODO Implement this method

        if(that==null)
            throw new NullPointerException();
        else if(that.leftLength()!=0)
            throw new IllegalArgumentException();
        else
        {

            //backup
/*
            int right_length = that.rightLength();
            for(int i=1; i<= right_length;i++) {
                E temp = that.remove();
                insert(temp);
            }

  */
            int right_length = that.rightLength();
            for(int i=0; i<right_length;i++) {
                int rightAfterRemoval = that.rightLength();
                for (int j = 0; j < rightAfterRemoval-1 ; j++) {
                    that.advance();

                }
                E temp = that.remove();
                this.insert(temp);
                that.reset();
                //rightAfterRemoval=0;

            }
        }

	}

	public void flip() throws IllegalStateException{
		// TODO Implement this method
        int right_length = rightLength();

        System.out.println("right length:" + right_length);
        E temp = null;
        if(leftLength()!=0)
            throw new IllegalStateException("Cursor is not at the beginning of the list");
        else
        {

            for(int i = 0 ; i < right_length/2 ; i++){
                E first  =  this.get();
                //reset();
                for(int j = i+1 ; j < right_length-i ; j++){
                    this.advance();
                }
                E second = this.set(first);
                reset();
                for(int l = 0 ; l < i ; l++)
                    this.advance();

                this.set(second);
                reset();

                for(int k = 0 ; k<= i ; k++){
                    this.advance();
                }
            }
        }
	}

}
