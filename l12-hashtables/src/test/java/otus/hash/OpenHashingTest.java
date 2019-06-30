package otus.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenHashingTest {
    private OpenHashingHashTable<Integer, String> hashTable;

    @BeforeEach
    public void init() {
        hashTable = new OpenHashingHashTable<>();
    }

    @Test
    public void whenSeveralStringsIsGiven_ExpectItToGetFromHashtable() {
        hashTable.put(1, "a");
        hashTable.put(2, "b");
        hashTable.put(3, "c");
        hashTable.put(4, "d");
        assertTrue(hashTable.delete(4));
        hashTable.put(5, "e");
        hashTable.put(6, "f");
        hashTable.put(7, "g");
        hashTable.put(8, "h");
        hashTable.put(9, "i");
        hashTable.put(10, "j");
        hashTable.put(-1, "aa");
        hashTable.put(-7, "gg");

        assertEquals("a", hashTable.get(1));
        assertEquals("aa", hashTable.get(-1));
        assertEquals("g", hashTable.get(7));
        assertEquals("gg", hashTable.get(-7));
        assertEquals(11, hashTable.size());
    }
}
