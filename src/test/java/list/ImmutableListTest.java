package list;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableListTest {
    final static Logger LOGGER = Logger.getLogger(ImmutableList.class);

    @Test
    public void listCreationTest() {
        ImmutableList<String> list = new ImmutableList<>("a", "b", "c");
        LOGGER.info("List Size: " + list.size());
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void listHeadTest() {
        ImmutableList<String> list = new ImmutableList<>("a", "b", "c");
        String head = list.head();
        LOGGER.info("List Head: " + head);
        Assert.assertEquals("a", head);
    }

    @Test
    public void listComparisonTest() {
        ImmutableList<String> list1 = new ImmutableList<>("a", "b", "c");
        LOGGER.info("List1: " + list1);
        ImmutableList<String> list2 = new ImmutableList<>("a", "b", "c");
        LOGGER.info("List2: " + list2);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void listTailTest() {
        ImmutableList<String> list = new ImmutableList<>("a", "b", "c");
        LOGGER.info("Original List: " + list);
        ImmutableList<String> tail = list.tail();
        LOGGER.info("List Tail: " + tail);
        Assert.assertEquals(new ImmutableList<>("b", "c"), tail);
    }

    @Test
    public void listConsTest() {
        ImmutableList<String> list = new ImmutableList<>("a", "b", "c");
        LOGGER.info("Original List: " + list);
        ImmutableList<String> cons = list.cons("z");
        LOGGER.info("List Cons: " + cons);
        Assert.assertEquals(new ImmutableList<>("z","a","b", "c"), cons);
    }

    @Test
    public void listDropTest() {
        ImmutableList<String> list = new ImmutableList<>("a", "b", "c","d","e","f");
        LOGGER.info("Original List: " + list);
        ImmutableList<String> drop = list.drop(3);
        LOGGER.info("List drop: " + drop);
        Assert.assertEquals(new ImmutableList<>("d","e","f"), drop);
    }

    @Test
    public void listReverseTest() {
        ImmutableList<String> list = new ImmutableList<>("a", "b", "c","d");
        LOGGER.info("Original List: " + list);
        ImmutableList<String> rev = list.reverse();
        LOGGER.info("List Reverse: " + rev);
        Assert.assertEquals(new ImmutableList<>("d","c","b", "a"), rev);
    }
}
