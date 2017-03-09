package Lintcode.SytemDesign;

import java.util.HashMap;
import java.util.Map;

/**
 Tiny Url

 Description
 Notes
 Testcase
 Judge
Given a long url, make it shorter. To make it simpler, let's ignore the domain name.

You should implement two methods:

longToShort(url). Convert a long url to a short url.
shortToLong(url). Convert a short url to a long url starts with http://tiny.url/.
You can design any shorten algorithm, the judge only cares about two things:

The short key's length should equal to 6 (without domain and slash). And the acceptable characters are [a-zA-Z0-9]. For example: abcD9E
No two long urls mapping to the same short url and no two short urls mapping to the same long url.
Have you met this question in a real interview? Yes
Example
Given url = http://www.lintcode.com/faq/?id=10, run the following code (or something similar):

short_url = longToShort(url) // may return http://tiny.url/abcD9E
long_url = shortToLong(short_url) // return http://www.lintcode.com/faq/?id=10
The short_url you return should be unique short url and start with http://tiny.url/ and 6 acceptable characters. For example "http://tiny.url/abcD9E" or something else.

The long_url should be http://www.lintcode.com/faq/?id=10 in this case.

Related Problems 
Medium Tiny Url II 18 %
Medium Binary Tree Serialization

 *
 */
public class Tiny_Url {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    private HashMap<Integer, String> id2url = new HashMap<Integer, String>();
    private HashMap<String, Integer> url2id = new HashMap<String, Integer>();

    public static int GLOBAL_ID = 0;
    public static String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static int SHORT_URL_KEY_LENGTH = 6;
    public static int BASE = chars.length();;
    private static Map<Character, Integer> charToBase62 = new HashMap<Character, Integer>();
    static{
        int i = 0;
        for(char ch : chars.toCharArray()){
            charToBase62.put(ch, i++);
        }
    }
    private String SHORT_URL_PREFIX = "http://tiny.url/";

    private String idToShortKey(int id){
        String shortUrl = "";
        while(id!=0){
            shortUrl = chars.charAt(id % BASE) + shortUrl;//øºµ„”Îœ›⁄Â
            id = id / BASE;
        }
        while(shortUrl.length() < SHORT_URL_KEY_LENGTH){
            shortUrl = "0" + shortUrl;
        }
        return shortUrl;
    }
    
    // public WRITE service longURL to shortURL
    public String longToShort(String url) {
        // Write your code here
        if (url2id.containsKey(url)) {
            return SHORT_URL_PREFIX + idToShortKey(url2id.get(url));
        }
        GLOBAL_ID++;
        String shortUrl = idToShortKey(GLOBAL_ID);
        id2url.put(GLOBAL_ID, url);
        url2id.put(url, GLOBAL_ID);
        return SHORT_URL_PREFIX + shortUrl;
    }

    /**
     * @param url a short url starts with http://tiny.url/
     * @return a long url
     */
    // public READ service shortURL to longURL
    public String shortToLong(String shortUrl) {
        // Write your code here
        if(shortUrl == null) return null;
        String shortKey = shortUrl.substring(SHORT_URL_PREFIX.length());
        int id = 0;
        for(int i = 0; i < shortKey.length(); i++){
            id = id*BASE +  charToBase62.get(shortKey.toCharArray()[i]);//
        }
        return id2url.get(id);
    }
    
}
