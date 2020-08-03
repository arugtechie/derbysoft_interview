package com.derbysoft.interview.exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Longest Palindrome
 */
public class LongestPalindrome {

  /**
   * This function will return the longest substring palindrome in a given phrase.
   * e.g. the longest substring palindrome in "bananas" is "anana"
   */
  public static String longestPalindrome(String phrase) {
    if (phrase == null || phrase.isEmpty()) {
      return null;
    }
    String longest = phrase.substring(0, 1);
    for (int i = 0; i < phrase.length() - 1; i++) {
      //odd cases like bab
      String palindrome = intermediatePalindrome(phrase, i, i);
      if (palindrome.length() > longest.length()) {
        longest = palindrome;
      }
      //even cases like 1221
      palindrome = intermediatePalindrome(phrase, i, i + 1);
      if (palindrome.length() > longest.length()) {
        longest = palindrome;
      }
    }
    if(longest.length() > 1 && IsPalindrome(longest)) return longest;
    else
    return null;
  }

  public static String intermediatePalindrome(String s, int left, int right) {
    if (left > right) return null;
    while (left >= 0 && right < s.length()
            && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }
  public static void main(String[] args) {
    assertNull(longestPalindrome(""));
    assertNull(longestPalindrome("xyz"));
    assertEquals("anana", longestPalindrome("bananas"));
    assertEquals("racecar", longestPalindrome("bananas racecar"));
    assertEquals("racecar", longestPalindrome("racecar bananas"));
    assertEquals("ddddcccbbabbcccdddd", longestPalindrome("ddddcccbbabbcccdddd"));
    assertEquals("ddddcccbbabbcccdddd", longestPalindrome("ddddcccbbabbcccdddd bananas"));
  }


  public static boolean IsPalindrome(String input) {
    if (input == null || input.isEmpty()) {
      return false;
    }
    int length = input.length();
    char[] chars = input.toLowerCase().toCharArray();
    for (int i = 0; i < length / 2; i++) {
      if (chars[i] != chars[length - 1 - i]) {
        return false;
      }
    }
    return true;
  }


}
