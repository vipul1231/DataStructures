import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueExample {

    public static void main(String[] a) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int noOfTest = scanner.nextInt();
        CustomPriorityQueue customPriorityQueue = new CustomPriorityQueue(noOfTest);
        while (scanner.hasNext()){
            int value  = scanner.nextInt();
            try {
                customPriorityQueue.add(value);
            } catch (Exception e) {
                Integer valuePolled = customPriorityQueue.poll();
                System.out.println("Value polled: "+valuePolled);
                customPriorityQueue.add(value);
            }
        }
        scanner.close();
    }


    static class CustomPriorityQueue {

        final int size;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        CustomPriorityQueue(int size) {
            this.size = size;
        }

        public void add(Integer value) throws Exception{
            if(priorityQueue.size() != size) {
                priorityQueue.add(value);
                return;
            }
            throw new Exception("Cannot add new value as size is full");
        }

        public Integer poll() {
            return priorityQueue.poll();
        }

    }
}
