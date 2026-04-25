class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> results = new ArrayList<>();
        if (str.isBlank()) return results;
        while(str.length() > 0) {
            int end = str.indexOf("#");
            // handle the parse exception
            int length = Integer.parseInt(str.substring(0, end));
            int strStart = end + 1;
            int strEnd = strStart + length;
            String next = str.substring(strStart, strEnd);
            results.add(next);
            str = str.substring(strEnd);
        }

        return results;
    }
}
