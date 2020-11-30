package ds_general;

import java.util.Arrays;
import java.util.Scanner;

public class ParallelProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfThreads = scanner.nextInt();
        int noOfRequest = scanner.nextInt();

        Thread[] threads = new Thread[noOfThreads];
        System.out.println("\n");
        for (int i = 0; i < noOfThreads; i++) {
            long value = scanner.nextLong();
            threads[i] = new Thread(i, value);
            System.out.println(i + " 0");
        }

        for (int i = ((noOfThreads) / 2) - 1; i >= 0; i--) {
            heapify(threads, i, threads.length);
        }

        int count = noOfThreads;

        int heapifyCount = 0;
        while (count != noOfRequest) {
            long nextTask = scanner.nextLong();
            Thread thread = threads[0];
            System.out.println(thread.index + " " + thread.executionTime);
            long taskValue = thread.executionTime + nextTask;
            threads[0] = new Thread(thread.index, taskValue);
            heapify(threads, 0, threads.length);

            if(heapifyCount == noOfThreads) {
                for (int i = ((noOfThreads) / 2) - 1; i >= 0; i--) {
                    heapify(threads, i, threads.length);
                }
                heapifyCount = 0;
            }

            heapifyCount++;
            count++;
        }
        scanner.close();
    }

    static class Thread implements Comparable<Thread> {
        int index;
        long executionTime;

        public Thread(int index, long executionTime) {
            this.index = index;
            this.executionTime = executionTime;
        }

        @Override
        public int compareTo(Thread o) {
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
    public static int leftIndex(int i) {
        return 2 * i + 1;
    }

    /**
     * Right Index
     *
     * @param j
     * @return
     */
    public static int rightIndex(int j) {
        return 2 * j + 2;
    }


    /**
     * Shift down algo
     *
     * @param input
     * @param i
     * @param length
     */
    public static void heapify(Thread[] input, int i, int length) {

        int maxIndex = i;

        int left = leftIndex(i);
        int right = rightIndex((i));

        /*if(left < length && input[left].executionTime == input[maxIndex].executionTime && input[left].index < input[maxIndex].index) {
            Thread temp = input[left];
            input[left] = input[maxIndex];
            input[maxIndex] = temp;
        }
        else if(right < length && input[right].executionTime == input[maxIndex].executionTime && input[right].index < input[maxIndex].index) {
            Thread temp = input[right];
            input[right] = input[maxIndex];
            input[maxIndex] = temp;
        }*/

        if (left < length && input[left].executionTime < input[maxIndex].executionTime) {
            maxIndex = left;
        }
        else if(left < length && input[left].executionTime == input[maxIndex].executionTime && input[left].index < input[maxIndex].index) {
            Thread temp = input[left];
            input[left] = input[maxIndex];
            input[maxIndex] = temp;
        }
        if (right < length && input[right].executionTime < input[maxIndex].executionTime) {
            maxIndex = right;
        }else if(right < length && input[right].executionTime == input[maxIndex].executionTime && input[right].index < input[maxIndex].index) {
            Thread temp = input[right];
            input[right] = input[maxIndex];
            input[maxIndex] = temp;
        }

        if (maxIndex != i) {
            Thread temp = input[i];
            input[i] = input[maxIndex];
            input[maxIndex] = temp;
            heapify(input, maxIndex, length);
        }
    }
}
