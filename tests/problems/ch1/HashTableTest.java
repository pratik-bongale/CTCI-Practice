package problems.ch1;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problems.ch1.exceptions.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {


    @Test
    public void checkBasicFunctionality() throws KeyNotFoundException {
        // when
        HashTable<Integer> ht = new HashTable<>();

        // test valid input
        ht.put("Louis Litt", 96);
        ht.put("Harvey Spectre", 98);
        ht.put("Mike Ross", 93);

        assertTrue(ht.contains("Louis Litt"));
        assertEquals( 96, ht.get("Louis Litt"));

        assertTrue(ht.contains("Harvey Spectre"));
        assertEquals( 98, ht.get("Harvey Spectre"));

        // test invalid input
        assertFalse(ht.contains("Pitt Bull"));

        // test errors
        Exception exception = Assertions.assertThrows(KeyNotFoundException.class,  () -> ht.get("Pitt Bull"));
        assertEquals("Key not found in Hash Table", exception.getMessage());

        // special cases
        // replace existing entry
        ht.put("Mike Ross", 99);
        assertEquals(99, ht.get("Mike Ross"));

    }

}