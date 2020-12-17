package ds_facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctTriangle {

    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        Set<SidesChild> uniqueTriangle = new HashSet<>();

        int similar = 0;
        for (Sides sides : arr) {
            SidesChild sidesChild = sortTheTriangle(sides);
            boolean result  =uniqueTriangle.add(sidesChild);
            if (!result) {
                similar++;
            }
        }

        return arr.size() - similar;
    }

    static SidesChild sortTheTriangle(Sides sides) {
        int[] sidesArray = new int[3];
        sidesArray[0] = sides.a;
        sidesArray[1] = sides.b;
        sidesArray[2] = sides.c;
        Arrays.sort(sidesArray);

        sides.a = sidesArray[0];
        sides.b = sidesArray[1];
        sides.c = sidesArray[2];

        return new SidesChild(sides.a, sides.b, sides.c);
     }

     static class SidesChild extends Sides {

        public int hashCode() {
            return 23 + this.a + this.b + this.c;
        }

        public boolean equals(Object o) {

            if (o == null) {
                return false;
            }

            Sides sides = (Sides) o;
            return this.a == sides.a && this.b == sides.b && this.c == sides.c;
        }
         SidesChild(int a, int b, int c) {
             super(a, b, c);
         }
     }

    public static void main(String[] args) {
        ArrayList<Sides> triangleSides = new ArrayList<>();
        triangleSides.add(new Sides(2, 2, 3));
        triangleSides.add(new Sides(2, 5, 6));
        triangleSides.add(new Sides(3, 2, 2));
        System.out.println(countDistinctTriangles(triangleSides));

        triangleSides.clear();

        System.out.println("New Test case");
        triangleSides.add(new Sides(5, 8, 9));
        triangleSides.add(new Sides(5, 9, 8));
        triangleSides.add(new Sides(9, 5, 8));
        triangleSides.add(new Sides(9, 8, 5));
        triangleSides.add(new Sides(8, 9, 5));
        triangleSides.add(new Sides(8, 5, 9));

        System.out.println(countDistinctTriangles(triangleSides));

    }
}
