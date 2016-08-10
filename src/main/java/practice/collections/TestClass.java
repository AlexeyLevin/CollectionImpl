package practice.collections;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestClass {

//    @Benchmark
    public void testJDKArrayList() {
        add(new ArrayList<Integer>());
    }

//    @Benchmark
    public void testJDKLinkedList() {
        add(new LinkedList<Integer>());
    }

//    @Benchmark
    public void testJDKVector() {
        add(new Vector<Integer>());
    }

    public void add(final List<Integer> list) {
        for (int i = 0; i < 10_000; i++)
            list.add(i);
    }

}