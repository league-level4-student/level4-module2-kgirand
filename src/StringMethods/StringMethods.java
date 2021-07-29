package StringMethods;

import java.awt.RenderingHints.Key;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.stream.events.Characters;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		System.out.println(s1.length());
		if(s1.length()>s2.length()) {
			return s1;
		}else {
			return s2;
		}
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		char under = '_';
		char space = ' '; 
		if(s.contains("underscores")==true) {
			System.out.println(s);
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==space) {
					s = s.replace(space, under);
				}
			}
			return s;
		}else {
			return s;
		}
		
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char letter1 = ' ';
		char letter2 = ' ';
		char letter3 = ' ';
		for(int i = 0; i < s1.length()-2; i++) {
			if(s1.charAt(i)!=' ' && s1.charAt(i+1)==' ' && s1.charAt(i+2)!=' ') {
				letter1 = s1.charAt(i+2);
				System.out.println("s1 " + letter1);
			}
		}
		for(int i = 0; i < s2.length()-2; i++) {
			if(s2.charAt(i)!=' ' && s2.charAt(i+1)==' ' && s2.charAt(i+2)!=' ') {
				letter2 = s2.charAt(i+2);
				System.out.println("s2 " + letter2);
			}
		}
		for(int i = 0; i < s3.length()-2; i++) {
			if(s3.charAt(i)!=' ' && s3.charAt(i+1)==' ' && s3.charAt(i+2)!=' ') {
				letter3 = s3.charAt(i+2);
				System.out.println("s3 "  + letter3);
			}
		}
		
		String letter = Character.toString(letter1);
		
		String letterr = Character.toString(letter2);
		String letterrr = Character.toString(letter3);
		
		if(letter.compareTo(letterr) < 0 && letter.compareTo(letterrr) < 0) {
			return s1.trim();
		}else if(letterr.compareTo(letter) < 0 && letterr.compareTo(letterrr) < 0 ){
			return s2.trim();
		}else if(letterrr.compareTo(letter) < 0 && letterrr.compareTo(letterr) < 0){
			return s3.trim();
		}
		return "";
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int num = 0; 
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				int j = Integer.parseInt(s.charAt(i)+"");
				num += j;
				System.out.println(num);
			}
		}
		System.out.println("numeral sum = " + num);
		return num;
		
		
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int ret = 0;
		if(substring.length()>2) {
			for(int i = 0; i < s.length()-2; i++) {
				if(s.charAt(i)==substring.charAt(0)) {
					if(s.charAt(i+1)==substring.charAt(1)) {
						if(s.charAt(i+2)==substring.charAt(2)) {
							ret++;
						}
					}
				}
			}
		}else {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==substring.charAt(0)) {	
					ret ++;
				}
			}
		}
						
		return ret;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		String[] array = s.split("\\s");
		return null;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		
		return null;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
	int num = 0;
	String[] words = s.split("\\s");
	for(int i = 0; i < words.length; i++) {
		if(words[i].endsWith(substring)) {
			num++;
		}
	}
	return num;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int distance = 0;
		int last = s.length() - substring.length();
		System.out.println("last = " + last);
		int first = 0;
		for(int i = 0; i < s.length(); i++) {
				if(first == 0 && s.charAt(i) == substring.charAt(0)) {
					first = i+substring.length(); 
				}	
		}
		System.out.println("first = " + first);
		distance = last - first;
		return distance;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		int d = (s.length()/2)*10;
		Integer.toString(d);
		
		
		return true;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
