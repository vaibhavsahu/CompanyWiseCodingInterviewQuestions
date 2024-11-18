package easy;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/excel-sheet-column-number/
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int c = i + 65;
            map.put((char) c, i + 1);
        }

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(n - 1 - i);
            result += (int) (map.get(ch) * (Math.pow(26, i)));
        }
        return result;
    }
}
