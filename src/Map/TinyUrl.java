package Map;

/**
 * Created by zxm on 12/5/15.
 */

import java.util.HashMap;
import java.util.Map;

/**analysis
 * use cases:
 * 1. shorten url
 * 2. redirect shorted url;
 * 3. how to distinguish which one is shorted url? 1. try check if existed in the shorted url map, if so get the original and visit, otherwise, visit it directly;
 */
public class TinyUrl {

    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private char[] charMap = new char[62]; //a-zA-z0-9
    private Map<Character, Integer> integerToChar = new HashMap<>();

    public TinyUrl() {
        int j = 0;
       for (int i = 0; i < 26; i++) {
           charMap[j++] = (char) (i + 'a');
           integerToChar.put(charMap[j - 1], i);
       }
       for (int i = 0; i < 26; i++) {
           charMap[j++] = (char) (i + 'A');
           integerToChar.put(charMap[j - 1], i);
       }
       for (int i = 0; i < 10; i++) {
           charMap[j++] = (char) (i + '0');
           integerToChar.put(charMap[j - 1], i);
       }

    }
    //shorten long url
    public String shortenUrl(String url) {
        if (url == null || url.length() == 0) return "";
        String shortUrl = convertToBase62(url);
        //String shortUrl = convertToBase62(shortToLong.size());
        longToShort.put(url, shortUrl);
        shortToLong.put(shortUrl, url);

        return shortUrl;
    }

    //redirect short url
    public String redirectUrl(String url) {
        if (! shortToLong.containsKey(url)) return url;
        return shortToLong.get(url);
    }

    public String convertToBase62(String url) {
        int num = Math.abs(url.hashCode());
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(charMap[num % 62]);
            num /= 62;
        }

        return sb.toString();
    }

    public int convertToBase10(String url) {
        int res = 0;
        int poly = 1;
        for (int i = 0; i < url.length(); i++) {
            char ch = url.charAt(i);
            int digit = integerToChar.get(ch);
            res += digit * poly;
            poly *= 62;
        }

        return res;
    }


}
