package practice.collections;

import org.openjdk.jmh.annotations.Benchmark;
import practice.collections.map.arraymap.ArrayBasedMap;
import practice.collections.map.hashtable.Employee;
import practice.collections.map.hashtable.HashTableMap;

import java.util.HashMap;
import java.util.Map;


public class TestMapClass {
    @Benchmark
    public void testPutJDKHashMap() {
        getValueByKey(new HashMap<String, Employee>());
    }

    @Benchmark
    public void testPutMyHashTableMap() {
        getValueByKey(new HashTableMap<String, Employee>());
    }

    @Benchmark
    public void testPutMyArrayTableMap() {
        getValueByKey(new ArrayBasedMap<String, Employee>());
    }

    public void put(final Map<String, Employee> map) {
        for (int i = 0; i < 1_000; i++)
            map.put(i+"", new Employee(i+""));
    }

    public void getValueByKey(final Map<String, Employee> map) {
        put(map);
        for (int i = 0; i < 1_000; i++) {
            map.get(i + "");
        }
    }
}
