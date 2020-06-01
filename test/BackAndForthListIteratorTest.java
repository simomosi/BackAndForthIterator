/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import backandforthiterator.*;
import java.time.Clock;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author simomosi
 */
public class BackAndForthListIteratorTest {

	public BackAndForthListIteratorTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Tests the symmetry between BackAndForthIterator and ListIterator
	 */
	@Test
	public void backAndForthTest() {
		List<Integer> list = new LinkedList<>();
		Integer index;
		for (index = 0; index < 6; index++) { // Fills the collection
			list.add(index);
		}
		BackAndForthIterator<Integer> bfli = new BackAndForthListIterator<>(list);
		ListIterator<Integer> oracleIterator = list.listIterator(); // contains all expected values in assertions
		// Forth
		while (oracleIterator.hasNext()) {
			assertTrue(bfli.hasNext());
			assertEquals(oracleIterator.next(), bfli.next());
		}
		// Back
		assertEquals(oracleIterator.previous(), bfli.current()); // BFLI is already "pointing" on the last element (current)
		while (oracleIterator.hasPrevious()) {
			assertTrue(bfli.hasPrevious());
			assertEquals(oracleIterator.previous(), bfli.previous());
		}
		// Mixed: position 0
		assertFalse(bfli.hasPrevious());
		assertTrue(bfli.hasNext());
		assertEquals(list.get(0), bfli.current());
		// Mixed: go to position 1
		assertEquals(list.get(1), bfli.next());
		assertTrue(bfli.hasPrevious());
		assertTrue(bfli.hasNext());
		// Mixed: go to position 2
		assertEquals(list.get(2), bfli.next());
		// Mixed: go to position 1
		assertEquals(list.get(1), bfli.previous());
	}

	/**
	 * Tests the current index when the iterator has not iterated yet
	 */
	@Test(expected = IllegalStateException.class)
	public void notInitializedTest() {
		List<Integer> list = new LinkedList<>();
		Integer index;
		for (index = 0; index < 6; index++) { // Fills the collection
			list.add(index);
		}
		BackAndForthIterator<Integer> bfli = new BackAndForthListIterator<>(list);
		ListIterator<Integer> oracleIterator = list.listIterator(); // contains all expected values in assertions
		assertEquals(oracleIterator.hasPrevious(), bfli.hasPrevious());
		assertEquals(oracleIterator.hasNext(), bfli.hasNext());
		assertEquals(-1, bfli.currentIndex());
		bfli.current();
	}

	/**
	 * Tests if the set operation replaces an element correctly
	 */
	@Test
	public void replaceElementTest() {
		List<Integer> list = new LinkedList<>();
		Integer index;
		for (index = 0; index < 6; index++) { // Fills the collection
			list.add(index);
		}
		BackAndForthIterator<Integer> bfli = new BackAndForthListIterator<>(list);
		bfli.next();
		assertEquals(list.get(0), bfli.current());
		bfli.set(list.get(1)); // Replaces item 0 with item 1
		assertEquals(list.get(1), bfli.current());
	}
	
	/**
	 * Tests indexes at the edges of the list
	 */
	@Test
	public void indexTest() {
		List<Integer> list = new LinkedList<>();
		Integer index;
		for (index = 0; index < 6; index++) { // Fills the collection
			list.add(index);
		}
		BackAndForthIterator<Integer> bfli = new BackAndForthListIterator<>(list);
		// Beginning of the list
		assertEquals(-1, bfli.currentIndex());
		assertEquals(-1, bfli.previousIndex()); // see previousIndex implementation
		assertEquals(0, bfli.nextIndex());
		// End of the list
		while (bfli.hasNext())
			bfli.next();
		assertEquals(list.size()-1, bfli.currentIndex());
		assertEquals(list.size()-2, bfli.previousIndex());
		assertEquals(list.size(), bfli.nextIndex());
	}
}
