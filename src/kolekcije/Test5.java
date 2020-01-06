package kolekcije;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test5 {

	public static int vowels(String str) {

		char[] charString = str.toCharArray();
		int numVowels = 0;
		for (int i = 0; i < charString.length; i++) {
			numVowels += (charString[i] == 'a' || charString[i] == 'e' || charString[i] == 'i' || charString[i] == 'o'
					|| charString[i] == 'u') ? 1 : 0;
		}

		return numVowels;
	}

	public static void main(String[] args) throws IOException {
		
		Scanner unos = new Scanner(System.in);
		System.out.print("Unesite ime fajla: ");
		String fileName = unos.next();
		int numWords = 0, numUniqWords = 0, numConsonant = 0, numVowels = 0;
		
		Path path = Paths.get(fileName);

		if (!Files.exists(path)) {
			System.out.println("File " + path.getFileName() + " doesn't exists.");
		}
		/*
		ispiše broj unikatnih riječi u fileu
		ukupan broj riječi u fileu
		broj samoglasnika u fileu
		broj suglasnik u fileu
	    */
				
		Map<String, Integer> wordsMap = new HashMap<>();	

		Scanner sc2 = new Scanner(path);
		String str;
		while (sc2.hasNext()) {
			str = sc2.next();
			numWords++;
			
			if(!wordsMap.containsKey(str)) {
				wordsMap.put(str, 1);
			}else {
				wordsMap.put(str, wordsMap.get(str) + 1);
			}			
			
		}
		sc2.close();
		
		for(String s : wordsMap.keySet()) {
			System.out.print( (wordsMap.get(s) == 1)? s + '\n' : "");
			numUniqWords += (wordsMap.get(s) == 1)? 1 : 0;
			numVowels += (vowels(s) > 0)? vowels(s) : 0;
			numConsonant += (vowels(s) > 0)? s.length() - vowels(s) : s.length();
		}
		
		/**
		Set<String> wordsSet = wordsMap.keySet();
		Iterator<String> iteratorSet = wordsSet.iterator();
		while(iteratorSet.hasNext()) {
			System.out.println(iteratorSet.next() + wordsMap.get(arg0));
		}*/	
		
		System.out.println("Ukupan broj rijeci u fajlu je: " + numWords + "\n");
		System.out.println("Ukupan broj unikatnih rijeci u fajlu je: " + wordsMap.keySet().size() + "\n");
		System.out.println("Ukupan broj samoglasnika u fajlu je: " + numVowels + "\n");
		System.out.println("Ukupan broj suglasnika u fajlu je: " + numConsonant + "\n");
		

	}

}
