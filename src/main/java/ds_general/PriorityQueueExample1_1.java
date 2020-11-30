package ds_general;

import java.util.Scanner;

public class PriorityQueueExample1_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfThreads = scanner.nextInt();
        int noOfRequest = scanner.nextInt();

        Thread_1[] threads = new Thread_1[noOfThreads];

        //long startTime = System.currentTimeMillis();

        for (int k = 0; k < noOfRequest; k++) {
            int nextTask = scanner.nextInt();

            if (k < noOfThreads) {
                threads[k] = new Thread_1(k, nextTask);
                System.out.println(k + " 0");
            } else {
                if(k==noOfThreads) {
                    for (int j = ((noOfThreads) / 2) - 1; j >= 0; j--) {
                        heapify_1(threads, j, threads.length);
                    }
                }
                Thread_1 thread = threads[0];
                System.out.println(thread.index + " " + thread.executionTime);
                long taskValue = thread.executionTime + nextTask;
                threads[0] = new Thread_1(thread.index, taskValue);
                heapify_1(threads, 0, threads.length);
            }
        }
        scanner.close();
        //long endTime = System.currentTimeMillis();

        //System.out.println("Runtime: "+(endTime - startTime)/1000);
    }

    static class Thread_1 implements Comparable<Thread_1> {
        int index;
        long executionTime;

        public Thread_1(int index, long executionTime) {
            this.index = index;
            this.executionTime = executionTime;
        }

        @Override
        public int compareTo(Thread_1 o) {
            if (executionTime == o.executionTime) {
                return this.index - o.index;
            }
            return 0;
        }
    }

    /**
     * Left Index
     *
     * @param i
     * @return
     */
    public static int leftIndex_1(int i) {
        return 2 * i + 1;
    }

    /**
     * Right Index
     *
     * @param j
     * @return
     */
    public static int rightIndex_1(int j) {
        return 2 * j + 2;
    }


    /**
     * Shift down algo
     *
     * @param input
     * @param i
     * @param length
     */
    public static void heapify_1(Thread_1[] input, int i, int length) {

        int maxIndex = i;

        int left = leftIndex_1(i);
        if (left < length && input[left].executionTime < input[maxIndex].executionTime) {
            maxIndex = left;
        } else if (left < length && input[left].executionTime == input[maxIndex].executionTime) {
            if (input[left].index < input[maxIndex].index) {
                Thread_1 temp = input[left];
                input[left] = input[maxIndex];
                input[maxIndex] = temp;
            }
        }

        int right = rightIndex_1((i));
        if (right < length && input[right].executionTime < input[maxIndex].executionTime) {
            maxIndex = right;
        } else if (right < length && input[right].executionTime == input[maxIndex].executionTime) {
            if (input[right].index < input[maxIndex].index) {
                Thread_1 temp = input[right];
                input[right] = input[maxIndex];
                input[maxIndex] = temp;
            }
        }


        if (maxIndex != i) {
            Thread_1 temp = input[i];
            input[i] = input[maxIndex];
            input[maxIndex] = temp;
            heapify_1(input, maxIndex, length);
        }
    }

}
