import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int removeCount = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (sb.length() > 0 && removeCount < k && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                removeCount++;
            }

            sb.append(c);
        }

        sb.setLength(sb.length() - (k - removeCount));

        return sb.toString();
    }
}
