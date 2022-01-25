package ratelimiter;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2IntRBTreeMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.HashMap;
import java.util.Map;

@State(Scope.Benchmark)
public class CompareCollectionMaps {

	@Benchmark
	@Fork(value = 1, warmups = 0)
	public long testFastUtilsIntMapPerformance() {
		Int2IntMap i2iMap = new Int2IntOpenHashMap();
        for (int i=0;i<1000000;i++) {
            i2iMap.put(i, i);
        }

        long sum = 0;
        for (int i = 1000000-1;i>=0;i--) {
            sum += i2iMap.get(i);
        }

        return sum;
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	public long testEclipseMapPerformance() {
		IntIntHashMap i2iMap = new IntIntHashMap();

		for (int i=0;i<1000000;i++) {
			i2iMap.put(i, i);
		}

		long sum = 0;
		for (int i = 1000000-1;i>=0;i--) {
			sum += i2iMap.get(i);
		}

		return sum;
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	public long testJavaMapPerformance() {
		Map<Integer, Integer> i2iMap = new HashMap<>();
        for (int i=0;i<1000000;i++) {
            i2iMap.put(i, i);
        }

        long sum = 0;
        for (int i = 1000000-1;i>=0;i--) {
            sum += i2iMap.get(i);
        }

        return sum;
	}

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
}
