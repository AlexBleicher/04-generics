package ohm.softa.a04;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsUtilityTest {

    private SimpleList<Integer> testList = new SimpleListImpl<>();
    @BeforeEach
    void setup(){
        testList.add(3);
        testList.add(1);
        testList.add(9);
        testList.add(2);
        testList.add(69);
        testList.add(420);
    }

    @Test
    void sort() {
        SimpleList<Integer> sortedList = CollectionsUtility.sort(testList, Comparator.comparingInt(i->i));
        assertEquals(6, sortedList.size());
        int tmp = -1;
        for(Integer i : sortedList) {
            assertTrue(i >= tmp);
            tmp = i;
        }
    }
}