package com.derbysoft.interview.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * For a given set of numbers on a phone, print all possible "word" combinations in alphabetical order.
 *
 * For example if input number is 234, possible words which can be formed are (Alphabetical order):
 * adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi
 *
 * Bonus points explain the performance/complexity of the solution in Big O notation.
 */
public class PhoneWords
{
/*
  static char[][] lettersForNumbers = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
          {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y','z'}};
*/

   private static List<String> findWords(String digits)
  {
    List<String> words = new ArrayList<String>();
    HashMap<Character, char[]> lettersMap = new HashMap<Character, char[]>();
    lettersMap.put('2',new char[]{'a','b','c'});
    lettersMap.put('3',new char[]{'d','e','f'});
    lettersMap.put('4',new char[]{'g','h','i'});
    lettersMap.put('5',new char[]{'j','k','l'});
    lettersMap.put('6',new char[]{'m','n','o'});
    lettersMap.put('7',new char[]{'p','q','r','s'});
    lettersMap.put('8',new char[]{'t','u','v'});
    lettersMap.put('9',new char[]{'w','x','y','z'});

    char[] arr = new char[digits.length()];
    helper(digits, 0, lettersMap, words, arr);
      return words;
  }

  private static void helper(String digits, int index, HashMap<Character, char[]> lettersMap,
                      List<String> result, char[] arr){
    if(index==digits.length()){
      result.add(new String(arr));
      return;
    }

    char number = digits.charAt(index);
    char[] candidates = lettersMap.get(number);
    for(int i=0; i<candidates.length; i++){
      arr[index]=candidates[i];
      helper(digits, index+1, lettersMap, result, arr);
    }
  }

  /**
   * Time complexity is O(k^n), where k is the biggest number of letters a digit can map (k=4) and n is the length of the digit string.
   * Time Complexity: O(4n), where n is number of digits in input number.
   * @param args
   */
  public static void main(String[] args)
  {
    List<String> words = findWords("234");
    System.out.println(words);
  }
}
