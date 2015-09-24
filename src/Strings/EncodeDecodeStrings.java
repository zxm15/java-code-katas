package Strings;

/**
 * Created by ZXM on 9/23/15.
 * Design an algorithm to encode a list of strings into a single string
 * and another algorithm to
 * decode the encoded string back to the original list of strings.
 */

import java.util.ArrayList;
import java.util.List;

/**analysis
 * clarification:
 * empty list?
 * return empty string;
 *
 * pattern matching:
 * real life experience regular expression
 * how to represent /? use //
 *
 * algo:
 * encode the list, for each string do
 * if it contains /, add a /,
 * at the end of a string, add /n
 *
 * decode:
 * traverse the string looking for /n
 * if s[i] = /
 *  if s[i + 1] = n
 *      add the string to the list
 *      sb = new StringBuilder();
 *  else {
 *      sb.append(/)
 *
 *  }
 *  i++;
 *
 */
public class EncodeDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(encodeString(str));
            sb.append("/n");
        }

        return sb.toString();
    }

    private String encodeString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '/') sb.append("/");
            sb.append(c);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '/') {
                //there must be next character according to the encode algorithm
                if (str.charAt(i + 1) == 'n') {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                    i++;
                    continue;
                }
                i++;
            }
            sb.append(curr);
        }

        return res;
    }
}
