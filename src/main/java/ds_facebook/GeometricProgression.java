package ds_facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Triplets {

    private final int position;
    private final List<Triplets> triplets;
    Triplets(int position) {
        this.position = position;
        triplets = new ArrayList<>();
    }

    private int getPosition() {
        return position;
    }

    public List<Triplets> getTriplets() {
        return triplets;
    }

    public void addTriplet(int position) {
        triplets.add(new Triplets(position));
    }
}

public class GeometricProgression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int count = 0, scannedCount = 0;
        int[] inputArray = new int[n];
        List<Triplets> result = new ArrayList<>();
        while (count+2 != n) {

            int triplet_1 = 0;
            if(scannedCount != n) {
                triplet_1 = scanner.nextInt();
                inputArray[scannedCount] = triplet_1;
                scannedCount++;
            }
            triplet_1 = inputArray[count];
            Triplets triplets = new Triplets(count);
            int triplet_2 = triplet_1*r;

            int copyCount = count;
            while (copyCount != n-1) {
                int triplet_3 = 0;
                if(scannedCount != n) {
                    triplet_3 = scanner.nextInt();
                    inputArray[scannedCount] = triplet_3;
                    scannedCount++;
                }
                copyCount++;
                triplet_3 = inputArray[copyCount];


                if(triplet_2 == triplet_3) {
                    if(scannedCount != n) {
                        triplets.addTriplet(scannedCount-1);
                    }
                    else {
                        triplets.addTriplet(copyCount);
                    }
                    continue;
                }
                if (triplet_3 > triplet_2) {
                    int number_3 = triplet_1 * (int) Math.pow(r, 2);
                    if(triplet_3 == number_3) {
                        List<Triplets> tripletsList = triplets.getTriplets();
                        for(Triplets triplets1 : tripletsList) {
                            if (scannedCount != n) {
                                triplets1.addTriplet(scannedCount-1);
                            }
                            else {
                                triplets1.addTriplet(copyCount);
                            }
                        }
                        result.add(triplets);
                    }
                    else {
                        break;
                    }
                }
            }

            count++;
        }

        int ans =0;
        for (Triplets triplets : result) {
            ans += triplets.getTriplets().size();
        }
        System.out.println(ans);

        scanner.close();
    }
}
