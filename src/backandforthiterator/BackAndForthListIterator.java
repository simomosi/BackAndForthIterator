package backandforthiterator;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @param <T> is the collection type
 * @see BackAndForthIterator
 * @see ListIterator
 * @author simomosi
 *
 * BackAndForthIterator implementation for Lists collections and subtypes. A
 * BackAndForthListIterator, unlike <i>ListIterator</i>, has a current element.
 * Using positional access, use of data structure with fast positional access is
 * recommended (like <i>array lists</i>)
 */
public class BackAndForthListIterator<T> implements BackAndForthIterator<T> {

	private final List<T> list;
	private int currentPosition;

	public BackAndForthListIterator(List<T> list) {
		if (list == null) {
			throw new IllegalArgumentException("List must not be null.");
		}
		this.list = list;
		this.currentPosition = -1;
	}

	@Override
	public boolean hasNext() {
		return currentPosition + 1 < list.size();
	}

	@Override
	public T next() {
		if (currentPosition + 1 >= list.size()) {
			throw new NoSuchElementException(); // Unchecked
		}
		return list.get(++currentPosition);
	}

	@Override
	public boolean hasPrevious() {
		return currentPosition - 1 >= 0;
	}

	@Override
	public T previous() {
		if (currentPosition - 1 < 0) {
			throw new NoSuchElementException(); // Unchecked
		}
		return list.get(--currentPosition);
	}

	@Override
	public int nextIndex() {
		return currentPosition + 1;
	}

	@Override
	public int previousIndex() {
		if (currentPosition < 0) // Comment these lines if you want to return -2 when iterator has not been initialized
		{
			return -1;
		}
		return currentPosition - 1;
	}

	@Override
	public void set(T e) {
		if (currentPosition < 0) {
			throw new IllegalStateException("Iterator must be initialized with a next() call");
		}
		list.set(currentPosition, e);
	}

	@Override
	public T current() {
		if (currentPosition < 0) {
			throw new IllegalStateException("Iterator must be initialized with a next() call");
		}
		return list.get(currentPosition);
	}

	@Override
	public int currentIndex() {
		return currentPosition;
	}

	/**
	 * Operation not supported to not violate the post-condition of iterator
	 * contract. The remove operation should not modify the iterator status
	 * (i.e. the next element it returns)
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Operation not supported because the ability to both append an element or
	 * prepend it to the list cannot be guaranteed in the same implementation.
	 * That's because if the add method inserts the element <tt>e</tt> in
	 * position
	 * <i>currentPosition+1</i>, it won't be possible to prepend <tt>e</tt> to a
	 * non-empty list (i.e. to position <i>0</i>). The problem is symmetrical if
	 * the <tt>add</tt> method inserts <tt>e</tt>
	 * in position <i>currentPosition-1</i>
	 */
	@Override
	public void add(T e) {
		throw new UnsupportedOperationException();
	}
}
