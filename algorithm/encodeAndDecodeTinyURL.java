/* Two HashMap + random character generation */
public class Codec {
    private Map<String, String> encode = new HashMap<>();/* origURL -> key */
    private Map<String, String> decode = new HashMap<>();/* key -> origURL */
    private static String BASE_HOST = "http://tinyURL.com/"; /* URL base */
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(encode.containsKey(longUrl)){    /* if the url has been encoded before */
            return BASE_HOST + encode.get(longUrl);
        }
        String key = genKey();  /* otherwise, generate a mapping key */
        while(decode.containsKey(key)){ /* if the key has been generatd before, re-generat key */
            key = genKey();
        }
        encode.put(longUrl, key);
        decode.put(key, longUrl);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode.get(shortUrl.replace(BASE_HOST, ""));
    }
    /* randomly generate 6 chars from [a-zA-Z0-9] */
    private String genKey(){
        String baseChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++){
            int index = (int)(Math.random() * baseChar.length());
            sb.append(baseChar.charAt(index));
        }
        return sb.toString();
    }
}
