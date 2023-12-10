import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyUniversityUnitTest {
    @DisplayName("Normal path test")
    @Test
    public void testNormalPath() {
        var expected = new Administration(new Person[]{
                new Person("A1", 'm'),
                new Person("A2", 'f'),
                new Person("B1", 'm'),
                new Person("B2", 'f'),
        });

        var actual = new Administration(new Person[]{
                new Person("B2", 'f'),
                new Person("A2", 'f'),
                new Person("B1", 'm'),
                new Person("A1", 'm')
        });
        actual.sortList();

        assertEquals(expected, actual);
    }

    @DisplayName("Worst case - test with a reversed list")
    @Test
    public void testReversedList() {
        var expected = new Administration(new Person[]{
                new Person("A1", 'm'),
                new Person("A2", 'f'),
                new Person("B1", 'm'),
                new Person("B2", 'f'),
        });

        var actual = new Administration(new Person[]{
                new Person("B2", 'f'),
                new Person("B1", 'm'),
                new Person("A2", 'f'),
                new Person("A1", 'm')
        });
        actual.sortList();

        assertEquals(expected, actual);
    }

    @DisplayName("Best case - test with an already sorted list")
    @Test
    public void testSortedList() {
        var expected = new Administration(new Person[]{
                new Person("A1", 'm'),
                new Person("A2", 'f'),
                new Person("B1", 'm'),
                new Person("B2", 'f'),
        });

        var actual = new Administration(new Person[]{
                new Person("A1", 'm'),
                new Person("A2", 'f'),
                new Person("B1", 'm'),
                new Person("B2", 'f')
        });
        actual.sortList();

        assertEquals(expected, actual);
    }

    @DisplayName("Edge case - test with an empty list")
    @Test
    public void testEmptyList() {
        var admin = new Administration(new Person[]{});
        assertThrows(IllegalStateException.class, admin::sortList);
    }

    @DisplayName("Edge case - test with a list containing only one element")
    @Test
    public void testListWithOneElement() {
        var expected = new Administration(new Person[]{
                new Person("A1", 'm')
        });

        var actual = new Administration(new Person[]{
                new Person("A1", 'm')
        });
        actual.sortList();

        assertEquals(expected, actual);
    }

    @DisplayName("Edge case - test with a list containing only two elements")
    @Test
    public void testListWithTwoElements() {
        var expected = new Administration(new Person[]{
                new Person("A1", 'm'),
                new Person("A2", 'f')
        });

        var actual = new Administration(new Person[]{
                new Person("A2", 'f'),
                new Person("A1", 'm')
        });
        actual.sortList();

        assertEquals(expected, actual);
    }

    @DisplayName("Performance - test with a reversed list containing 10000 elements")
    @Timeout(2)
    @Test
    public void testPerformance() {
        var persons = new Person[10000];
        for (int i = persons.length; i > 0; i--) {
            persons[i - 1] = new Person("A" + i, 'm');
        }

        new Administration(persons).sortList();
    }
}
