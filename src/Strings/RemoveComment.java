package Strings;

/**
 * Created by ZXM on 9/23/15.
 * Remove // comment
 * and /* comment
 */ //from source code.

/**analysis
 * clarification
 * 1. empty string or null
 * return empty string
 * 2. all comment
 * empty string
 * 3. what is the newline character?
 * /n
 *
 * pattern matching
 * have to traverse the stringg, best time is O(n)
 * keep a stringbuilder to add characters into it along the traversal
 *
 * algo:
 * read current character s[i]
 * boolean isCode = true;
 * boolean newLine = false;
 * boolean newStar = false;
 * if isCode
 * if s[i] == '/'
 *  if i + 1 < n && s[i + 1] == '/'
 *      isCode = false;
 *      newLine = true;
 *      else if i + 1 < n && s[i + 1] = '*'
 *          isCode = false;
 *          newStart = true;
 *      else 
 *          sb.append(s[i]);
 * else 
 *     if s[i] == '/' && s[i + 1] == 'n'
 *          isCode = true;
 *          newLine = false;
 *     else if s[i] == '*' %% s[i + 1] == '/'
 *          isCode = true;
 *          newStart = false;
 *
 *above pesudo code is not the optimal code, but it leads my optimal code below
 * Complexity O(N) time and O(N) space
 * This is not a hard problem, but combine logic to form final clean code is a good trainning.
 */
public class RemoveComment {

    public String removeCommentFromSource(String source) {
        if (source == null || source.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        boolean isCode = true;
        boolean searchNewLine = false;
        //boolean searchStart  = false;
        for (int i = 1; i < source.length(); i++) {
            char curr = source.charAt(i - 1);
            char next = source.charAt(i);
            if (isCode) {
                if (curr == '/' && (next == '/' || next == '*')) {
                    isCode = false;
                    searchNewLine = next == '/' ? true : false;
                    i++;
                    continue;
                }
                sb.append(curr);
                if (i == source.length() - 1) sb.append(next); //take care of the last character
            } else {
                String pair = curr + "" + next;
                if (pair.equals("/n") && searchNewLine || pair.equals("*/") && !searchNewLine) {
                    isCode = true;
                    i++;
                }
            }
        }


        return sb.toString();
    }

}
