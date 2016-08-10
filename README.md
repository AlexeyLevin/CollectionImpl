# CollectionImpl
Implements JDK collections and test complexity with JMH

run JMH tests:
mvn clean install
java -jar target\benchmarks.jar

results:

1)
Buckets in MyHashMap - 1010, Bucket Type = ArrayList, value count -10_000

#Benchmark                                  Mode  Cnt    Score   Error  Units
#TestMapClass.testPutAndGetArrayTableMap   thrpt  200    0,622 ? 0,016  ops/s
#TestMapClass.testPutAndGetJDKHashMap      thrpt  200  312,937 ? 5,083  ops/s 
#TestMapClass.testPutAndGetMyHashTableMap  thrpt  200  145,202 ? 3,861  ops/s

2)
Buckets in MyHashMap - 10100, Bucket Type = LinkedList, value count -10_000
