package Strings;

import java.util.HashMap;

/**
 * Created by Gavin on 4/11/2015.
 * Given an alphabet and a string, return the shortest pangram in the string. The pangram is unique:
 * example: alphabet = "abc", string = "ccbcaaa", return "bca"
 */
public class MinimumWindowSubString {


    public static String findMinimumWindow(String alpha, String dest) throws Exception
    {
        if (dest.length() < alpha.length()) throw new Exception("Destination string is shorter than alpha");
        HashMap<Character, Integer> map = new HashMap();
        //store the characters and number of its occurences in the map
        for (Character c : alpha.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        //iterate through the destination string to find the minimum window
        int count = alpha.length();
        int minLeft = -1, minRight = dest.length();
        int i = 0; //current substring start index
        for (int j = 0; j < dest.length(); j++) { //current substring end index
            char c = dest.charAt(j);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
                if (count == 0) {//find a window that contains alpha, shrink it by moving left boundary to right if possible

                    while (i < j && (!map.containsKey(dest.charAt(i)) || map.get(dest.charAt(i)) < 0)) {
                        char d = dest.charAt(i);
                        if (map.containsKey(d)) map.put(d, map.get(d) + 1);
                        i++;
                    }
                    if (minRight - minLeft > j - i) {
                        minRight = j;
                        minLeft = i;
                    }
                }
            }
        }
        return minLeft == -1 ? "error" : dest.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args)
    {
        String alpha = "aab";
        String dest = "acbba";
        try {
            String res = findMinimumWindow(alpha, dest);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
