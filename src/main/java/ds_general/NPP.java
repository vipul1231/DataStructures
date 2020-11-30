package ds_general;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class NPP {


    static class Packet {

        int arrivalTime;
        int processingTime;

        public Packet(int arrivalTime, int processingTime){
            this.arrivalTime = arrivalTime;
            this.processingTime = processingTime;
        }

        public String toString() {
            return arrivalTime+" "+processingTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bufferSize = scanner.nextInt();
        ArrayBlockingQueue<Packet> buffer = new ArrayBlockingQueue<>(bufferSize);
        List<Packet> request = new ArrayList<>();
        int numberOfPacket = scanner.nextInt();

        for(int i=0;i<numberOfPacket;i++) {
            int arrivalTime = scanner.nextInt();
            int processingTime = scanner.nextInt();
            Packet packet = new Packet(arrivalTime, processingTime);
            request.add(packet);
        }

        int count =0;
        int processorFinishTime = 0;
        int lastPacketArrivalTime = 0;
        int lastPacketProcessingTime = 0;
        while (true) {
            if (count == 0){
                Packet packet = request.get(count);
                buffer.add(packet);
                lastPacketArrivalTime = packet.arrivalTime;
                lastPacketProcessingTime = packet.processingTime;
                processorFinishTime = packet.arrivalTime + packet.processingTime;
            }
            else {
                Packet packet = request.get(count);

                if(packet.arrivalTime >= processorFinishTime) {
                    buffer.poll();
                    buffer.add(packet);
                    lastPacketArrivalTime = packet.arrivalTime;
                    lastPacketProcessingTime = packet.processingTime;
                    //Recompute the processorFinish Time

                }

                if(lastPacketArrivalTime < packet.arrivalTime && packet.arrivalTime < processorFinishTime) {
                    buffer.poll();
                    buffer.add(packet);
                    lastPacketArrivalTime = packet.arrivalTime;
                    lastPacketProcessingTime = packet.processingTime;
                    //Recompute the processorFinish Time
                    System.out.println(processorFinishTime);
                    processorFinishTime = processorFinishTime + packet.processingTime;

                }
            }
            count++;
        }


        //scanner.close();
    }
}
