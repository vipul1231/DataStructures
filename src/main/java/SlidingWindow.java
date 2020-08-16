import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] inputs = scanner.nextLine().split(" ");
        int windowLength = Integer.parseInt(scanner.nextLine());

        CustomDequeue customDequeue = new CustomDequeue();

        for (String input : inputs) {
            Integer value = Integer.parseInt(input);
            if (customDequeue.size() == windowLength) {
                System.out.println(customDequeue.getMax());
                customDequeue.dequeue();
            }
            customDequeue.enqueue(value);
        }
        System.out.println(customDequeue.getMax());
        scanner.close();
    }

    /**
     * Custom queue implementation.
     *
     */
    static class CustomDequeue {

        private final Stack<Integer> inbox = new Stack<>();
        private final List<Integer> maxInbox = new ArrayList<>();
        private final Stack<Integer> outbox = new Stack<>();
        private final List<Integer> maxOutBox = new ArrayList<>();

        public void enqueue(Integer value) {
            inbox.push(value);
            if(maxInbox.size() == 0 || value > maxInbox.get(maxInbox.size() -1)) {
                maxInbox.add(value);
            }
            else {
                maxInbox.add(maxInbox.get(maxInbox.size() -1));
            }
        }

        public void dequeue() {
            if (outbox.isEmpty()) {
                maxInbox.clear();
                while (!inbox.isEmpty()) {
                    int value = inbox.pop();
                    if(maxOutBox.size() == 0 || value > maxOutBox.get(maxOutBox.size() -1)) {
                        maxOutBox.add(value);
                    }
                    else {
                        maxOutBox.add(maxOutBox.get(maxOutBox.size() -1));
                    }
                    outbox.push(value);
                }
            }
            maxOutBox.remove(maxOutBox.size() -1);
            outbox.pop();
        }

        public Integer getMax() {
            int value1 = maxInbox.size() == 0 ? -1 :maxInbox.get(maxInbox.size() - 1);
            int value2 = maxOutBox.size() == 0 ? -1 : maxOutBox.get(maxOutBox.size() -1);

            if(value1 > value2) {
                return value1;
            }
            else {
                return value2;
            }
        }

        public int size() {
            return inbox.size()+outbox.size();
        }
    }
}
