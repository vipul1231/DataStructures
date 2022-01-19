package ds_general;

import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {


        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,24,-1,8,-3,0));
        for (Integer i: numbers)
            numbers.add(i*numbers.get(i));
    }
}
