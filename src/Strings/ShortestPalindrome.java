package Strings;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding chars in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * <p/>
 * For example:
 * aacecaaa -> aaacecaaa
 * abcd -> dcbabcd
 * Created by Gavin on 4/9/2015.
 */

public class ShortestPalindrome {
    /**
     * Find the shortest palindrome
     * @param str
     * @return res
     */
    public static String findShortestPalindrome(String str)
    {
        int n = str.length();
        int mid = (n - 1) / 2;
        int i = mid;
        String res = "";
        String suffix = "";
        while (i >= 0) {
            /* It is not necessary to write it because for this case, its left boundary will never reach index 0
            if (i == mid && n % 2 == 1) {
                if (isPalindromePrefix(str, i, i)) return str;
                else continue;
            }*/
            if (isPalindromePrefix(str, i, i + 1)) {
                //return n - (i + 1) * 2 + n;
                suffix = str.substring(2 * i + 2);
                break;
            }
            if (isPalindromePrefix(str, i, i)) {
                //return n - 1 - i * 2 + n;
                suffix = str.substring(2 * i + 1);
                break;
            }
            i--;
        }
        //System.out.println(suffix);
        res = reverse(suffix) + str;
        return res;
    }

    /**
     * check if str is a palindrome prefix
     *
     * @param str
     * @param i
     * @param j
     * @return
     */
    /*
    class Wrapper {
        boolean isPalin;
        String suffix;
        public wrapper(boolean isPalin, String suffix) {
            this.isPalin = isPalin;
            this.suffix = suffix;
        }
    }*/
    private static boolean isPalindromePrefix(String str, int i, int j)
    {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        // return new Wrapper(i==0, str.substring(j+1))
        return i == -1;
    }

    /**
     * reverse the string str
     * @param str
     * @return void
     */
    private static String reverse(String str)
    {
        int i = 0, j = str.length() - 1;
        char[] arr = str.toCharArray();
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args)
    {
        System.out.println(findShortestPalindrome("aacecaaa"));
        System.out.println(findShortestPalindrome("eca"));
        System.out.println(findShortestPalindrome("c"));
    }
}
