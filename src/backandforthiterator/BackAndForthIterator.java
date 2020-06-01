package backandforthiterator;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * A positional iterator for lists that allows the programmer 
 * to traverse the list in either direction.
 * With this kind of iterator, changing the iteration direction 
 * does not duplicate the last element returned (unlike <i>ListIterator</i>).
 * This is ideal for iterating collections that requires user interaction 
 * through a GUI, like a menu or an interface with next/prev buttons.
 * 
 * <p>A BackAndForthIterator, unlike <i>ListIterator</i>, has a current element.
 * 
 * @see ListIterator
 * @author simomosi
 */
public interface BackAndForthIterator<E>  extends ListIterator<E>{
	//Query Operations
	
	/**
     * Returns {@code true} if the iterator has another element when
     * traversing the list in the forward direction. (In other words,
     * returns {@code true} if {@link #next} would return an element rather
     * than throwing an exception.)
     *
     * @return {@code true} if the iterator has another element when
     *         traversing the list in the forward direction
     */
	@Override
	public boolean hasNext();
	
	/**
     * Returns the next element in the list and advances the cursor position.
     * This method may be called repeatedly to iterate through the list,
     * or intermixed with calls to {@link #previous} to go back and forth.
     *
     * @return the next element in the list
     * @throws NoSuchElementException if the iteration has no next element
     */
	@Override
	public E next();

	/**
     * Returns the index of the element that would be returned by a
     * subsequent call to {@link #next}. (Returns list size if the list
     * iterator is at the end of the list.)
     *
     * @return the index of the element that would be returned by a
     *         subsequent call to {@code next}, or list size if the list
     *         iterator is at the end of the list
     */
    @Override
    public int nextIndex();

	/**
     * Returns {@code true} if the iterator has another element when
     * traversing the list in the backwards direction. (In other words,
     * returns {@code true} if {@link #previous} would return an element rather
     * than throwing an exception.)
     *
     * @return {@code true} if the iterator has another element when
     *         traversing the list in the backwards direction
     */
    @Override
    public boolean hasPrevious();

	/**
     * Returns the previous element in the list and recedes the cursor position.
     * This method may be called repeatedly to iterate through the list,
     * or intermixed with calls to {@link #next} to go back and forth.
     *
     * @return the previous element in the list
     * @throws NoSuchElementException if the iteration has no next element
     */
    @Override
    public E previous();

	/**
     * Returns the index of the element that would be returned by a
     * subsequent call to {@link #previous}. Returns <tt>-1</tt> if the list
     * iterator is at the beginning of the list. Behavior when iterator has
	 * not been initialized may change depending on the implementation.
     *
     * @return the index of the element that would be returned by a
     *         subsequent call to {@code previous}, or <tt>-1</tt> if the
     *         iterator is at the beginning of the list. Behavior when iterator
	 *		   has not been initialized may change depending on the implementation.
     */
    @Override
    public int previousIndex();
	
	/**
	 * Returns the current (selected) element.
	 * 
	 * @return the current (selected) element
	 * @throws IllegalStateException if iterator is not <i>'pointing'</i> to
	 * any element (i.e. if no element is selected)
	 */
	public E current();
	
	/**
	 * Returns the index of current element, or <tt>-1</tt> if iterator 
	 * has not been initialized yet.
	 * 
	 * @return the index of current element, or <tt>-1</tt> if iterator 
	 * has not been initialized yet
	 */
	public int currentIndex();
	
	// Modification operations
	
	/**
     * Inserts the specified element into the list (optional operation).
	 * 
     * @param e the element to insert
     * @throws UnsupportedOperationException if the {@code add} method is
     *         not supported by this iterator
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this list
     * @throws IllegalArgumentException if some aspect of this element
     *         prevents it from being added to this list
     */
    @Override
    public void add(E e);

	/**
	 * Replaces the current element with the specified element 
	 * (optional operation).
	 * 
	 * @param e the element to replace the current element with.
	 * @throws IllegalStateException if iterator is not 'pointing' to
	 * any element (i.e. if no element is selected)
	 */
	@Override
    public void set(E e);

	/**
	 * Removes the current element from the collection (optional operation).
	 * 
	 * @throws UnsupportedOperationException if the {@code remove}
     *         operation is not supported by this iterator
	 */
    @Override
    public void remove();
}