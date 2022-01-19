package ratelimiter;

import practise.TwoWayMergeSort;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Sachin Tendulkar, 1, mumbai, batsman
 * Rahul Dravid, 2, karnataka, batsman
 * Aswin Vijayu, 3, tamilnadu, bowler
 * Virat Khozhi, 4, mumbai, batsman
 */


class A {
    public static void run() {
        System.out.println("A");
    }
}

class Code_1 extends A {

    public static void run() {
        System.out.println("B");
    }

    public static void main(String[] str) {
        A a = new Code_1();
        a.run();
    }
}


/*
class Player {
    String name;
    Integer id;

    Player(String name, Integer id, String location, String type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String location;
    String type;

    public String toString() {
        return id+" "+name+" "+location+" "+type;
    }
}

public class Code_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count  = Integer.parseInt(scanner.nextLine());
        List<Player> playersList = new ArrayList<>();
        for(int i=0;i<count;i++) {
            String[] read = scanner.nextLine().split(",");
            playersList.add(new Player(read[0], Integer.parseInt(read[1].trim()),read[2],read[3]));
        }
        System.out.println(playersList);
        playersList.sort(returnComp());
        System.out.println(playersList);

        TwoWayMergeSort sort = new TwoWayMergeSort();


    }

    public static Comparator<Player> returnComp() {
        return Comparator.comparing(o -> o.id);
    }
}
*/
