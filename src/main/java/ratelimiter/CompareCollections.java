package ratelimiter;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntRBTreeMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.eclipse.collections.api.map.primitive.MutableIntIntMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@State(Scope.Benchmark)
public class CompareCollections {

//    @Benchmark
//    @Fork(value = 1, warmups = 0)
//    public long testHashMapUnimiPerf() {
//        Int2IntMap i2iMap = new Int2IntRBTreeMap();
//        for (int i=0;i<100000;i++) {
//            i2iMap.put(i, i);
//        }
//
//        long sum = 0;
//        for (int i = 100000-1;i>=0;i--) {
//            sum += i2iMap.get(i);
//        }
//
//        return sum;
//    }
//
//    @Benchmark
//    @Fork(value = 1, warmups = 0)
//    public long testHashMapPerf() {
//        Map<Integer, Integer> i2iMap = new HashMap<>();
//        for (int i=0;i<100000;i++) {
//            i2iMap.put(i, i);
//        }
//
//        long sum = 0;
//        for (int i = 100000-1;i>=0;i--) {
//            sum += i2iMap.get(i);
//        }
//
//        return sum;
//    }

    /*@Benchmark
    //@BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 0)
    public long testHashMapHashMapForEclipsePerf() {
        MutableIntIntMap i2iMap = new IntIntHashMap();

        for (int i=0;i<size;i++) {
            i2iMap.put(i, i);
        }

        long sum = 0;
        for (int i = size-1;i>=0;i--) {
            sum += i2iMap.get(i);
        }

        return sum;
    }

    @Benchmark
    //@BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 0)
    public long testHashMapHashMapForEclipsePerf_1() {

        MutableIntObjectMap<A> i2iMap = new IntObjectHashMap<>();

        for (int i=0;i<size;i++) {
            A obj = new A();
            obj.a += 1;
            i2iMap.put(i, obj);
        }

        long sum = 0;
        for (int i = size-1;i>=0;i--) {
            sum += i2iMap.get(i).a;
        }

        return sum;
    }*/

    /*@Benchmark
    //@BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    public FastList<A> testFastListFromEclipseCollections() {
        FastList<A>  list = new FastList<>();

        AtomicInteger counter = new AtomicInteger(1);
        for (int i=0;i<size;i++) {
            A a = new A();
            a.a = counter.getAndIncrement();
            list.add(a);
        }
        return list;
    }

    @Benchmark
    //@BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    public ObjectArrayList<A> testFastListFromUnimiCollection() {
        ObjectArrayList<A> list = new ObjectArrayList<>();
        AtomicInteger counter = new AtomicInteger(1);
        for (int i=0;i<size;i++) {
            A a = new A();
            a.a = counter.getAndIncrement();
            list.add(a);
        }
        return list;
    }

    */

    /*FastList<Double> list = new FastList<>();

    @Setup(Level.Invocation)
    public void setup() {
        list.clear();
        for (double i=0;i<100000;i++) {
            list.add(i);
        }
    }


    @Benchmark
    @Fork(value = 1, warmups = 0)
    public Double testFastListFromUnimiCollection1() {
        Double sum = 0d;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    @Benchmark
    @Fork(value = 1, warmups = 0)
    public Double testFastListFromUnimiCollection2() {
        Double sum = 0d ;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    @Benchmark
    @Fork(value = 1, warmups = 0)
    public Double testFastListFromUnimiCollection3() {
        Double sum = 0d ;

        Iterator<Double> iter = list.iterator();
        while (iter.hasNext()) {
            sum += iter.next();
        }
        return sum;
    }

    @Benchmark
    @Fork(value = 1, warmups = 0)
    public Double testFastListFromUnimiCollection4() {
        Double sum = 0d ;

        for (Double aDouble : list) {
            sum += aDouble;
        }
        return sum;
    }*/

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}