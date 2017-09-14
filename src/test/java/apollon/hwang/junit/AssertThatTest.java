package apollon.hwang.junit;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;

public class AssertThatTest {

    @Test
    public void testIs() {
        assertThat("Unexpected number.", 1, Matchers.is(2));
    }

    @Test
    public void testInstanceOf() {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertThat("Unexpected type", list, Matchers.instanceOf(HashSet.class));
    }

    @Test
    public void testNullValue() {
        assertThat("Unexpected size", 1, Matchers.nullValue());
    }

    @Test
    public void testHasSize() {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertThat("Unexpected size", list, Matchers.hasSize(3));
    }

    @Test
    public void testHasKey() {
        final Map<String, String> map = new HashMap<>();
        map.put("key1", "value2");
        map.put("key2", "value2");
        assertThat("Key not found", map, Matchers.hasKey("key3"));
    }

    @Test
    public void testLessThan() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("a1", 7);
        map.put("a2", 9);
        for (Map.Entry entry: map.entrySet()) {
            if (((String)entry.getKey()).contains("b")) {
                assertThat("Number too big", (Integer)entry.getValue(), Matchers.lessThan(5));
            }
        }
    }
}
