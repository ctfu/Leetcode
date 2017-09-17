/* delimiter each string with the format "size/word" */
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // the string can contain any char, we nned to append special char before s, so that we can index of it later
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int slashIdx = s.indexOf('/', index); // index of appended slash starting from i
            int wordSize = Integer.parseInt(s.substring(index, slashIdx));
            String str = s.substring(slashIdx + 1, slashIdx + wordSize + 1);
            res.add(str);
            index = slashIdx + wordSize + 1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
