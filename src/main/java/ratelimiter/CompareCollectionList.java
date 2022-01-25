package ratelimiter;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;

//@State(Scope.Benchmark)
public class CompareCollectionList {

//	@Benchmark
//	@Fork(value = 1, warmups = 0)
	public long testFastUtilsIntArrayListPerformance() {

		IntArrayList fastUtilList = new IntArrayList();

		for (int i=0;i<100000;i++) {
			fastUtilList.add(i);
		}

		long sum = 0;
		for (int i = 100000-1;i>=0;i--) {
			sum += fastUtilList.getInt(i);
		}

		return sum;
	}

//	@Benchmark
//	@Fork(value = 1, warmups = 0)
	public long testEclipseFastListPerformance() {

		org.eclipse.collections.impl.list.mutable.primitive.IntArrayList eclipseList = new org.eclipse.collections
				.impl.list.mutable.primitive.IntArrayList();

		for (int i=0;i<100000;i++) {
			eclipseList.add(i);
		}

		long sum = 0;
		for (int i = 100000-1;i>=0;i--) {
			sum += eclipseList.get(i);
		}

		return sum;
	}

//	@Benchmark
//	@Fork(value = 1, warmups = 0)
	public long testJavaListPerformance() {
		List<Integer> javaList = new ArrayList<>();

		for (int i=0;i<100000;i++) {
			javaList.add(i);
		}

		long sum = 0;
		for (int i = 100000-1;i>=0;i--) {
			sum += javaList.get(i);
		}

		return sum;
	}

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}

}
