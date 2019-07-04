package ds.algo;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

/***
 ** @author umamaheshwar.hs
 ** @since 4/7/19
 *
 *  For a given string, check if it can be represented by repeated substring.
 *  Using frequency count to solve this.
 *
 *  Eg : abcabcabc is a valid string
 *
 *  Below is  solution using KMP
 *
 *  https://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 *
 **/
public class RepeatedSubString {

    private int gcd(int... args) {

        int len = args.length;

        int subGcd = args[0];
        for (int i = 1; i < len; i++) {
            subGcd = gcd(subGcd, args[i]);
        }
        return subGcd;
    }

    int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    boolean isValidString(String s) {

        Map<Character, Integer> characterFrequency = s.chars().boxed()
                .collect(toMap(
                        k -> Character.valueOf((char) k.intValue()),
                        v -> 1,
                        Integer::sum));

        int gcd = gcd(characterFrequency.values().stream().mapToInt(Integer::intValue).toArray());

        if (gcd == 1) {
            // Cannot be 1, as each window should have the character repeated.
            return false;
        }

        int count = characterFrequency.values().stream().mapToInt(Integer::intValue).sum();
        int windowSize = count / gcd;
        int i = 0;
        int j = windowSize;
        String subString = s.substring(0, windowSize);
        while (j <= s.length()) {

            if (!subString.equals(s.substring(i, j))) {
                return false;
            }
            i = i + windowSize;
            j = j + windowSize;

        }

        return true;
    }

    public static void main(String[] args) {

        String s = "abcaabcaabca";

        RepeatedSubString solution = new RepeatedSubString();

        System.out.println(solution.isValidString(s));

    }

}
