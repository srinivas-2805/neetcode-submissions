class Solution {
    public String mergeAlternately(String word1, String word2) {
        int left1 = 0;
        int left2 = 0;
        StringBuilder sb = new StringBuilder();
        while (left1 < word1.length() && left2 < word2.length()) {
            sb.append(word1.charAt(left1));
            left1++;
            sb.append(word2.charAt(left2));
            left2++;
        }
        while (left1 < word1.length()) {
            sb.append(word1.charAt(left1));
            left1++;
        }
        while (left2 < word2.length()) {
            sb.append(word2.charAt(left2));
            left2++;
        }

        return sb.toString();
    }
}