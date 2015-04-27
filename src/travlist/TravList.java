package travlist;

/**
 * <p>
 * A traversable list is a list with a conceptual cursor position at which
 * elements are inserted and removed. We typically represent a traversable list
 * as two consecutive lists: a left list and a right list.
 * </p>
 * 
 * <blockquote>
 * <table summary="traversable list examples" border="0" cellpadding="5" cellspacing="0">
 * <tr>
 * <th colspan="2" style="background-color:lavender">Traversable List Examples</th>
 * </tr>
 * <tr style="background-color:#eee">
 * <td><code>[ ][ ]</code></td>
 * <td>An empty list</td>
 * </tr>
 * <tr style="background-color:white">
 * <td><code>[ ][A B]</code></td>
 * <td>A list with its cursor at the beginning</td>
 * </tr>
 * <tr style="background-color:#eee">
 * <td><code>[A B][ ]</code></td>
 * <td>A list with its cursor at the end</td>
 * </tr>
 * <tr style="background-color:white">
 * <td><code>[A B][C D]</code></td>
 * <td>A list with its cursor between elements <code>B</code> and <code>C</code>
 * </td>
 * </tr>
 * </table>
 * </blockquote>
 *
 * @param <E>
 *            type of list entries
 */
public interface TravList<E> {

	// ==========================================================
	// Primary Methods
	// ==========================================================

	/**
	 * <p>
	 * Inserts the specified element into the list just after the cursor. If the
	 * specified element is null, a null pointer exception is thrown.
	 * </p>
	 * <blockquote>
	 * <table summary="insert example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Insert Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [A B C][D E F] <b>and</b> x = X</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>s.insert(x);</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [A B C][X D E F] <b>and</b> x = X</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 * 
	 * @param elem
	 *            the element to insert
	 */
	public void insert(E elem) throws NullPointerException;

	/**
	 * <p>
	 * Removes and returns the element just after the cursor. If the right list
	 * is empty, an illegal argument exception is thrown.
	 * </p>
	 * <blockquote>
	 * <table summary="remove example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Remove Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [A B C][D E F] <b>and</b> x = X</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>x = s.remove();</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [A B C][E F] <b>and</b> x = D</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 *
	 * @return the element after the cursor
	 */
	public E remove() throws IllegalStateException;

	/**
	 * <p>
	 * Advances the cursor past one element in the right list. If the right list
	 * is empty, an illegal state exception is thrown.
	 * </p>
	 * <blockquote>
	 * <table summary="remove example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Advance Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [A B C][D E F]</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>s.advance();</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [A B C D][E F]</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 */
	public void advance() throws IllegalStateException;

	/**
	 * <p>
	 * Resets the cursor to the beginning of the list.
	 * </p>
	 * <blockquote>
	 * <table summary="remove example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Reset Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [A B C][D E F]</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>s.reset();</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [ ][A B C D]</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 */
	public void reset();

	/**
	 * <p>
	 * Returns the number of elements to the left of the cursor.
	 * </p>
	 * 
	 * @return the number of elements to the left of the cursor
	 */
	public int leftLength();

	/**
	 * <p>
	 * Returns the number of elements to the right of the cursor.
	 * </p>
	 * 
	 * @return the number of elements to the right of the cursor
	 */
	public int rightLength();

	// ==========================================================
	// Secondary Methods
	// ==========================================================

	/**
	 * <p>
	 * Returns a handle to the element just after the cursor. If the right list
	 * is empty, an illegal state exception is thrown.
	 * </p>
	 * <blockquote>
	 * <table summary="get example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Get Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [A B C][D E F] <b>and</b> x = X</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>x = s.get();</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [A B C][D E F] <b>and</b> x = D</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 *
	 * @return the element after the cursor
	 */
	public E get() throws IllegalStateException;
	
	/**
	 * <p>
	 * Replaces and returns the element just after the cursor. If the right list
	 * is empty, an illegal state exception is thrown.
	 * </p>
	 * <blockquote>
	 * <table summary="set example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Set Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [A B C][D E F] <b>and</b> x = X</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>x = s.set();</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [A B C][X E F] <b>and</b> x = D</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 *
	 * @param element the element to replace the original
	 *
	 * @return the element after the cursor
	 */
	public E set(E element) throws IllegalStateException,NullPointerException;

	/**
	 * <p>
	 * Inserts all the elements in the specified list (that) at the cursor
	 * position in this list. If the cursor is not at the beginning of the
	 * specified list (that), throws an illegal argument exception.
	 * </p>
	 * 
	 * <blockquote>
	 * <table summary="splice example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Splice Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [A B C][D E F] <b>and</b> t = [ ][X Y Z]</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>s.splice(t);</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [A B C][X Y Z D E F] <b>and</b> t = [ ][ ]</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 * 
	 * @param that
	 *            the list to be inserted into this list
	 */
	public void splice(TravList<E> that) throws IllegalArgumentException,NullPointerException;

	/**
	 * <p>
	 * Reverses the list by taking everything after the cursor, reversing it,
	 * and moving it before the cursor. If the cursor is not at the beginning of
	 * this list, throws an illegal state exception.
	 * </p>
	 * <blockquote>
	 * <table summary="flip example" border="0" cellpadding="5" cellspacing="0">
	 * <tr>
	 * <th colspan="2" style="background-color:lavender">Flip Example</th>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Pre-state</td>
	 * <td><code>s = [ ][A B C D E]</code></td>
	 * </tr>
	 * <tr style="background-color:white">
	 * <td>Call</td>
	 * <td><code>s.flip();</code></td>
	 * </tr>
	 * <tr style="background-color:#eee">
	 * <td>Post-state</td>
	 * <td><code>s = [E D C B A][ ]</code></td>
	 * </tr>
	 * </table>
	 * </blockquote>
	 */
	public void flip() throws IllegalStateException;

	// ==========================================================
	// Object Methods
	// ==========================================================

	/**
	 * Returns true if the lists have the same elements in the same positions
	 * (based on their "equals" method) and have the same cursor position.
	 * 
	 * @param o
	 *            the object to be tested for equality to this list
	 * 
	 * @return true if the lists have the same elements and same cursor position
	 */
	public boolean equals(Object o);

	/**
	 * Returns the hash code for this list.
	 * 
	 * @return the hash code for this list
	 */
	public int hashCode();

	/**
	 * Returns the string representation of this list. The string
	 * representations should look like the list in the examples of this
	 * documentation.
	 * 
	 * @return the string representation of this list
	 */
	public String toString();
}
