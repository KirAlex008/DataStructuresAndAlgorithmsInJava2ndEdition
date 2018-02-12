package chapter11;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static chapter11.TestHashTableBase.HASH_TABLE_SIZE;
import static junit.framework.TestCase.assertEquals;

/**
 * Тестирование сущности {@link DoubleHashTable}
 *
 * @author rassoll
 * @created 12.02.2018
 * @$Author$
 * @$Revision$
 */
public class TestDoubleHashTable
{
	private static DoubleHashTable doubleHashTable;

	@Before
	public void init()
	{
		doubleHashTable = new DoubleHashTable(HASH_TABLE_SIZE);

		IntStream.range(0, HASH_TABLE_SIZE / 2).forEach(key -> doubleHashTable.insert(new DataItem(key)));
	}

	@Test
	public void testHashFunction()
	{
		TestHashTableBase.testHashFunction(doubleHashTable);
	}

	/**
	 * Тестирование второй функции вычисляющей хэш-значение
	 */
	@Test
	public void testHashFunction2()
	{
		assertEquals(4, doubleHashTable.hashFunction2(1));
		assertEquals(4, doubleHashTable.hashFunction2(201));
		assertEquals(3, doubleHashTable.hashFunction2(22));
		assertEquals(5, doubleHashTable.hashFunction2(150));
		assertEquals(5, doubleHashTable.hashFunction2(400));
	}

	@Test
	public void testInsertMethod()
	{
		TestHashTableBase.testInsertMethod(doubleHashTable);
	}

	@Test
	public void testDeleteMethod()
	{
		TestHashTableBase.testDeleteMethod(doubleHashTable);
	}

	@Test
	public void testGetDisplayDataMethod()
	{
		TestHashTableBase.testGetDisplayDataMethod(doubleHashTable);
	}
}