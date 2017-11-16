package list;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableListTest {

    @Test
    public void listHeadTest() {
        ImmutableList<String> list = new ImmutableList<>("A");
        Assert.assertEquals("A", list.head());
    }

    @Test
    public void listTailTest() {
        ImmutableList<String> list1 = new ImmutableList<>("B", new ImmutableList<>("A"));
        ImmutableList<String> list2 = list1.tail();
        Assert.assertEquals(new ImmutableList<>("B", new ImmutableList<>("A")), list1);
        Assert.assertEquals(new ImmutableList<>("A"), list2);
    }
    @Test
    public void listConsTest() {
        ImmutableList<String> list1 = new ImmutableList<>();
        ImmutableList<String> list2 = list1.cons("A");
        Assert.assertEquals(new ImmutableList<>(), list1);
        Assert.assertEquals(new ImmutableList<>("A"), list2);
        Assert.assertEquals(list1, list2.tail());
    }

    @Test
    public void listDropTest() {
        ImmutableList<String> list1 = new ImmutableList<>("B", new ImmutableList<>("A",
                new ImmutableList<>("C", new ImmutableList<>("D", new ImmutableList<>(
                        "E")))));
        ImmutableList<String> list2 = list1.drop(3);
        Assert.assertEquals(new ImmutableList<>("D", new ImmutableList<>("E")), list2);
    }

    @Test
    public void listReverseTest() {
        ImmutableList<String> list1 = new ImmutableList<String>().cons("E").cons("D")
                .cons("C").cons("A").cons("B");
        ImmutableList<String> list2 = list1.reverse();
        Assert.assertEquals(new ImmutableList<>("E", new ImmutableList<>("D",
                new ImmutableList<>("C",
                        new ImmutableList<>("A", new ImmutableList<>("B"))))), list2);
    }

}
