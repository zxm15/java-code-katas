package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Gavin on 4/11/2015.
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p/>
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True
 * <p/>
 * Follow up: Return all possible palindromes (without duplicates) that can be formed from a string.
 */
public class PermutationsFormPalindromes {
    private static HashMap<Character, Integer> getCharacterMap(String str)
    {
        HashMap<Character, Integer> map = new HashMap();
        boolean res = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public static boolean hasPermutationPalindrome(String str)
    {
        HashMap<Character, Integer> map = getCharacterMap(str);
        boolean hasOdd = false;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            if ((Integer) pair.getValue() % 2 == 1) {
                if (hasOdd) return false;
                hasOdd = true;
            }
        }
        return true;
    }

    public static ArrayList<String> findAllPalindromicPermutation(String str)
    {
        //HashMap<Character, Integer> map = getCharacterMap(str);
        if (!hasPermutationPalindrome(str)) return null;
        ArrayList<String> res = new ArrayList<String>();
        findAllPalindromicPermutationHelper(getCharacterMap(str), "", str.length(), res);
        return res;
    }

    private static void findAllPalindromicPermutationHelper(HashMap<Character, Integer> map, String palindrome, int len, ArrayList<String> res)
    {
        //ArrayList<String> res = new ArrayList();
        if (len == 0) {
            res.add(palindrome + reverse(palindrome));
            return;
        }
        Iterator iter = map.entrySet().iterator();
        if (len == 1) {
            while (iter.hasNext()) {
                Map.Entry pair = (Map.Entry) iter.next();
                if ((Integer) pair.getValue() == 1) res.add(palindrome + (Character) pair.getKey() + reverse(palindrome));
                return;
            }
        }
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            if ((Integer) pair.getValue() >= 2) {
                Character c = (Character) pair.getKey();
                map.put(c, map.get(c) - 2);
                findAllPalindromicPermutationHelper(map, palindrome + c, len - 2, res);
                map.put(c, map.get(c) + 2);
            }
        }
    }

    private static String reverse(String str)
    {
        char[] arr = str.toCharArray();
        int i = 0, j = str.length() - 1;
        while (i < j) swap(arr, i++, j--);
        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        System.out.println(hasPermutationPalindrome("aabbcc"));
        System.out.println(hasPermutationPalindrome("abbc"));
        System.out.println(hasPermutationPalindrome("aabcc"));

        ArrayList<String> res = findAllPalindromicPermutation("aabba");
        if (res.isEmpty()) System.out.println("it cannot form palindromes");
        else for (String str : res) System.out.println(str);

    }


}
