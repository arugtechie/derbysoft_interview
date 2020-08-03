package com.derbysoft.interview.exercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Anagram Test
 */
public class Anagram {

//  Write a function that takes a list of words as input, and returns a list of those words bucketed by anagrams.
//  Method signature
//  public static List<List<String>> anagramBucketer(List<String> words)
//  Example
//  Input: ["star", "rats", "car", "arc", "arts", "stars"]
//  Output: [["star", "rats", "arts"], ["car", "arc"], ["stars"]]

  public static List<List<String>> anagramBucketer(List<String> words) {
    final List<List<String>>  anagarms = new ArrayList<>();
    Map<String, List<String>> anagarmsMap = new HashMap<>();
    int i, j;
    AtomicInteger k = new AtomicInteger(0);
    for(i=0; i< words.size() ; i++)
    {
      char [] anagramChars = words.get(i).toLowerCase().toCharArray();
      Arrays.sort(anagramChars);
      for(j = 0; j < words.size(); j ++)
      {
        if(isAnagram(words.get(i), words.get(j)))
        {
          if (!anagarmsMap.containsKey(String.valueOf(anagramChars))) {
            anagarmsMap.put(new String(anagramChars), new ArrayList<String>());
          }
          if(!anagarmsMap.get(String.valueOf(anagramChars)).contains(words.get(j)))
            anagarmsMap.get(String.valueOf(anagramChars)).add(words.get(j));
        }
      }
      if(!anagarmsMap.containsKey(String.valueOf(anagramChars)))
      {
        anagarmsMap.put(String.valueOf(anagramChars), Arrays.asList(words.get(i).toLowerCase()));
      }
    }
    anagarmsMap.forEach((key, value) -> {
      anagarms.add(k.getAndIncrement(), value);
    });
    return anagarms;
  }

  static boolean isAnagram(String s1, String s2) {
    //Removing all white spaces from s1 and s2
    String copyOfs1 = s1.replaceAll(" ", "");
    String copyOfs2 = s2.replaceAll(" ", "");

    if (copyOfs1.length() != copyOfs2.length()) {
      //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
      return false;
    } else {
      //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array
      char[] s1Array = copyOfs1.toLowerCase().toCharArray();
      char[] s2Array = copyOfs2.toLowerCase().toCharArray();
      //Sorting both s1Array and s2Array
      Arrays.sort(s1Array);
      Arrays.sort(s2Array);
      //Checking whether s1Array and s2Array are equal
      return Arrays.equals(s1Array, s2Array);
    }

  }

  public static void main(String [] args) {
    List<String> words = Arrays.asList("star", "cats", "rats", "car", "arc", "arts", "stars");
    System.out.println(anagramBucketer(words));
  }
}
