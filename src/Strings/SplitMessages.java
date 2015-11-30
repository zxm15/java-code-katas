package Strings;

/**
 * Created by ZXM on 11/10/15.
 * 给定一段英文消息，以及一个固定的长度，要求将消息分割成若干条，每条的最后加上页码如 (2/3)，然后每条总长度不超过给定的固定长度。典型的应用场景就是短信发送长消息。
 经过询问之后得到更多详细要求及假设：
 (1）消息数量尽可能少，不必凑整句，可以在任意空格处分页；
 （2）这个固定长度可能非法，比如某个词很长导致一条消息放不下，要判断并抛出异常；
 （3）假设空格分割，不会出现连着两个空格的情况。
 assume the page informatoin does not occupy the message space
 */

import java.util.ArrayList;
import java.util.List;

/**analysis
 * could have many cases
 *
 * use List<String> to store the message for each page
 * use stringbuilder and a counter to add words into the sb
 * input = trim(input)
 * words = input.split("\\s+")
 * count = k
 * for i in words.length
 *  word = words[i]
 *  if (count > wordlength) {
 *      sb.append(word)
 *      count -= wordlength
 *      if (count > 0) {
 *          count--;
 *          sb.append(" ")
 *
     *  }
 *  }
 *  if (count == 0 || count < wordlength)
 *      count = k;
 *      sb = new builder
 *      if (count < wordlength) throw exception
 *  }
 *
 */
public class SplitMessages {
    public static void split(String message, int k) {
        if (message == null || message.length() == 0) return;
        List<String> pages = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        message = message.trim();
        String[] words = message.split("\\s+");
        int count = k;
        for (int i = 0; i < words.length; i++) {
            if (count > words[i].length()) {
                sb.append(words[i]);
                count -= words[i].length();
                //last word
                if (i == words.length - 1) {
                    pages.add(sb.toString());
                    break;
                }
                if (count > 0) {
                    sb.append(" ");
                    count--;
                } else {

                    pages.add(sb.toString());
                    sb = new StringBuilder();
                    count = k;
                }
            } else {
                if (k < words[i].length()) throw new RuntimeException("The contains invalid word");
                pages.add(sb.toString());
                sb = new StringBuilder();
                count = k;
                i--;

            }


        }

        printPage(pages);

    }

    private static void printPage(List<String> pages) {
        for (int i = 0; i < pages.size(); i++) {
            String page = pages.get(i);
            System.out.print(page);
            System.out.println("(" + (i + 1) + "/" + pages.size() + ")");
        }
    }


    public static void main(String[] args) {
        String str = "I am one of the best candidates";
        split(str, 10);
    }
}
