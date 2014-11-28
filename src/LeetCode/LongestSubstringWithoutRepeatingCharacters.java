package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用HashMap，时间复杂度为O(n)
 * @author Administrator
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;

        Map<Integer, Integer> dictionary = new HashMap<Integer, Integer>();

        int max = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            length++;
            //If found repeating character, check if the character is in the current substring.
            if (dictionary.containsKey(s.codePointAt(i))&&length>(i-dictionary.get(s.codePointAt(i))))
                length =i - dictionary.get(s.codePointAt(i));
            //Get the longest substring.            
            max = Math.max(length, max);
            dictionary.put(s.codePointAt(i), i);
        }

        return max;
	}
	public static void main(String[] args){
		String str="wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().
				lengthOfLongestSubstring(str));
	}
}
