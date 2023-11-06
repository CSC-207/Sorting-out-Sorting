import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Albert-Kenneth Okine
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void integerTest() {
    Integer[] original = { 9, 1, 2, 8, 7, 3, 4, 6, 5, 0 };
    Integer[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // integerTest

  @Test
  public void emptyTest() {
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyTest

  @Test
  public void multipleOccurencesTest() {
    Integer[] original = { 1, 2, 3, 4, 1, 2, 3, 1, 2, 1 };
    Integer[] expected = { 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // multipleOccurencesTest

} // class SortTester
