import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put(String.valueOf('I'), 1);
        map.put(String.valueOf('V'), 5);
        map.put(String.valueOf('X'), 10);
        map.put(String.valueOf('L'), 50);
        map.put(String.valueOf('C'), 100);
        map.put(String.valueOf('D'), 500);
        map.put(String.valueOf('M'), 1000);

        int sum = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            int romanToIntValue = map.get(String.valueOf(s.charAt(i)));

            if (i == s.length() - 1) {
                sum = sum + romanToIntValue;
            } else if (romanToIntValue < map.get(String.valueOf(s.charAt(i + 1))) ) {
                sum = sum - romanToIntValue;
            } else {
                sum = sum + romanToIntValue;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        int i = romanToInt(s);
        System.out.println(i);
    }
}