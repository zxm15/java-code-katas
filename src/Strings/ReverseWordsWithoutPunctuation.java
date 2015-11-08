package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZXM on 11/7/15.
 */
public class ReverseWordsWithoutPunctuation {
    public String reverseWords(String str) {
        if (str == null || str.length() == 0) return str;
        str = str.trim();
        List<String> words = new ArrayList<>();
        List<String> punctuations = new ArrayList<>();
        int start = 0, runner = 0;
        boolean isWord = false;
        for (; runner < str.length(); runner++) {
            char ch = str.charAt(runner);
            if (!isWord && Character.isLetter(ch)) {
                if (runner > start)
                    punctuations.add(str.substring(start, runner));
                isWord = true;
                start = runner;
            } else if (isWord && !Character.isLetter(ch)) {
                if (runner > start)
                    words.add(str.substring(start, runner));
                isWord = false;
                start = runner;
            }
        }
        if (!isWord) {
            punctuations.add(str.substring(start, runner));
        } else {
            words.add(str.substring(start, runner));
        }

        reverseList(words);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < punctuations.size())
                sb.append(punctuations.get(i));
        }

        return sb.toString();
    }

    private void reverseList(List<String> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            swap(list, i++, j--);
        }
    }

    private void swap(List<String> list, int i, int j) {
        if (i != j) {
            String temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }


}

/**test
 * this...is,,a  word
 * this is a    word
 * ...  ,, ' '
 * word a is this
 * ...  ,, ' '
 *
 * word...a,,is this
 *
 *
 * a...b,,c!!
 * c...b,,a!!
 */
