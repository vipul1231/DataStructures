package ratelimiter;

import lombok.Builder;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.openjdk.jmh.annotations.*;


@State(Scope.Benchmark)
public class CompareCollectionMaps {

	@Builder
	static class Source {

		private static final long serialVersionUID = 1L;

		public int id;

		//lead time elements
		public int leadTime = 0;
		public int leadTimeCalendar = 0;
		public int pickPackTime = 0;
		public int pickPackTimeCalendar = 0;
		public int transitTime = 0;
		public int transitTimeCalendar = 0;
		public int inspectionTime = 0;
		public int inspectionTimeCalendar = 0;

		//lot size elements
		public double minQty = 0.0;
		public double multQty = 0.0;
		public double maxQty = 0.0;

		//priority and targets
		public int priority;
		public double target;

		public SourceType type;

		enum SourceType {
			MAKE,
			BUY,
			TRANSFER
		}
	}

	@Builder
	static class SourceByte {

		private static final long serialVersionUID = 1L;

		public int id;

		//lead time elements
		public int leadTime = 0;
		public int leadTimeCalendar = 0;
		public int pickPackTime = 0;
		public int pickPackTimeCalendar = 0;
		public int transitTime = 0;
		public int transitTimeCalendar = 0;
		public int inspectionTime = 0;
		public int inspectionTimeCalendar = 0;

		//lot size elements
		public double minQty = 0.0;
		public double multQty = 0.0;
		public double maxQty = 0.0;

		//priority and targets
		public int priority;
		public double target;

		public byte[] type;

		enum SourceType {
			MAKE,
			BUY,
			TRANSFER
		}
	}

	private IntObjectHashMap test = IntObjectHashMap.newMap();

	@Setup(Level.Invocation)
	public void setUp() {
		for (int i = 0; i < 100000; i++) {
			test.put(i, new Object());
		}
	}

	/*@Benchmark
	@Fork(value = 1, warmups = 0)
	public void testEnumOfClass() {
		int count = 0;
		List<Source> sourceList = new ArrayList<>();
		for (int i=0;i<100000;i++) {
			Source source = Source.builder().id(i).inspectionTime(i).leadTime(i).pickPackTime(i)
					.transitTime(i).type(i > 100000 ? Source.SourceType.BUY : Source.SourceType.TRANSFER).build();
			sourceList.add(source);
		}
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	public void testEnumConvertedToByte() {
		int count = 0;
		List<SourceByte> sourceList = new ArrayList<>();
		for (int i=0;i<100000;i++) {
			SourceByte source = SourceByte.builder().id(i).inspectionTime(i).leadTime(i).pickPackTime(i)
					.transitTime(i).type(i > 100000 ? Source.SourceType.BUY.name().getBytes() : Source.SourceType.TRANSFER.name().getBytes()).build();
			sourceList.add(source);
		}
	}*/

	@Benchmark
	@Fork(value = 1, warmups = 0)
	public void testIntObjectHashMapPutIfAbsent() {
		for (int i = 0; i < 1000000; i++) {
			test.getIfAbsentPut(i, new Object());
		}
	}

	@Benchmark
	@Fork(value = 1, warmups = 0)
	public void testIntObjectHashMapOrdinaryWay() {

		IntObjectHashMap test = IntObjectHashMap.newMap();
		for (int i = 0; i < 1000000; i++) {
			Object obj = test.get(i);
			if (obj == null) {
				test.put(i, new Object());
			}
		}
	}




	/*@Benchmark
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
	}*/

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
}
