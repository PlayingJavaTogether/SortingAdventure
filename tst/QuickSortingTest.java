import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortingTest {

	SortingAlgorithm sortingAlgorithm;

	@Before
	public void setup() {
		sortingAlgorithm = new QuickSorting();
	}

	@Test
	public void simpleTest() {
		// 3A:

		// Arrange
		String[] listToSort = new String[] { "orange", "apple", "melon", "grapes", "banana" };

		// Act
		String[] result = sortingAlgorithm.sort(listToSort);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertTrue(result.length > 0);
		Assert.assertEquals(listToSort.length, result.length);

		String[] expectedResult = new String[] { "apple", "banana", "grapes", "melon", "orange" };
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}

	@Test
	public void smarterTest() {
		// 3A:

		// Arrange
		String[] listToSort = new String[] { "pear", "apple" };

		// Act
		String[] result = sortingAlgorithm.sort(listToSort);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertTrue(result.length > 0);
		Assert.assertEquals(listToSort.length, result.length);

		String[] expectedResult = new String[] { "apple", "pear" };
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}

	@Test
	public void emptyArrayTest() {
		// 3A:

		// Arrange
		String[] listToSort = new String[] {};

		// Act
		String[] result = sortingAlgorithm.sort(listToSort);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertEquals(listToSort.length, result.length);

		String[] expectedResult = new String[] {};
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}

	@Test
	public void anotherTest() {
		// 3A:

		// Arrange
		String[] listToSort = new String[] { "a", "b", "c" };

		// Act
		String[] result = sortingAlgorithm.sort(listToSort);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertEquals(listToSort.length, result.length);

		String[] expectedResult = new String[] { "a", "b", "c" };
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}

	@Test
	public void yetAnotherTest() {
		// 3A:

		// Arrange
		String[] listToSort = new String[] { "a", "b", "c", "b" };

		// Act
		String[] result = sortingAlgorithm.sort(listToSort);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertEquals(listToSort.length, result.length);

		String[] expectedResult = new String[] { "a", "b", "b", "c" };
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}

	@Test
	public void capitalizationTest() {
		// 3A:

		// Arrange
		String[] listToSort = new String[] { "a", "b", "c", "A" };

		// Act
		String[] result = sortingAlgorithm.sort(listToSort);

		// Assert
		Assert.assertNotNull(result);
		Assert.assertEquals(listToSort.length, result.length);

		String[] expectedResult = new String[] { "A", "a", "b", "c" };
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}

	@Test
	public void smallTest() {
		String[] listToSort = new String[] { "d", "b", "a", "c" };

		String[] result = sortingAlgorithm.sort(listToSort);

		Assert.assertNotNull(result);
		Assert.assertEquals(listToSort.length, result.length);

		String[] expectedResult = new String[] { "a", "b", "c", "d" };
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}

}
