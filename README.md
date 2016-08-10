# CollectionImpl
Implements JDK collections and test complexity with JMH

run JMH tests:
# mvn clean install
# java -jar target\benchmarks.jar

results:

1) Buckets in MyHashMap - 1010,  Global bucket type = ArrayList, value count: 1000

<pre>
Benchmark                                  Mode  Cnt    Score   Error  Units
TestMapClass.testPutAndGetArrayTableMap   thrpt  200    0,622 ? 0,016  ops/s
TestMapClass.testPutAndGetJDKHashMap      thrpt  200  312,937 ? 5,083  ops/s
TestMapClass.testPutAndGetMyHashTableMap  thrpt  200  145,202 ? 3,861  ops/s
</pre>

2) Buckets in MyHashMap - 10100, Global bucket type = LinkedList, value count: 10000

<pre>
Benchmark                                  Mode  Cnt    Score   Error  Units
TestMapClass.testPutAndGetArrayTableMap   thrpt  200    0,652 ? 0,009  ops/s
TestMapClass.testPutAndGetJDKHashMap      thrpt  200  362,804 ? 5,778  ops/s
TestMapClass.testPutAndGetMyHashTableMap  thrpt  200    2,631 ? 0,138  ops/s
</pre>

3) Buckets in MyHashMap - 10100,  Global bucket Type = ArrayList, value count: 10000

<pre>
Benchmark                                  Mode  Cnt    Score   Error  Units
TestMapClass.testPutAndGetArrayTableMap   thrpt  200    0,663 ? 0,006  ops/s
TestMapClass.testPutAndGetJDKHashMap      thrpt  200  339,024 ? 8,303  ops/s
TestMapClass.testPutAndGetMyHashTableMap  thrpt  200  212,736 ? 8,380  ops/s
</pre>
