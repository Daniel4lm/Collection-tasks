package kolekcije;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) throws IOException {

		Scanner unos = new Scanner(System.in);
		System.out.print("Unesite ime fajla: ");
		String fileName = unos.next();
		System.out.print("Unesite neku rijac: ");
		String findWord = unos.next();

		Path path = Paths.get(fileName);
		BufferedReader reader = Files.newBufferedReader(path);
		String line, scannerLine;
		int numPosition = 0, numLines = 1, wordNumber = 0, numUniqWords = 0;

		Map<String, Integer> wordsMap = new HashMap<>();
		Map<Integer, Integer> positionMap = new HashMap<>();

		Scanner wordsScanner = null;

		while ((line = reader.readLine()) != null) {
			wordsScanner = new Scanner(line);

			while (wordsScanner.hasNext()) {

				scannerLine = wordsScanner.next();
				System.out.print(scannerLine + " ");
				numPosition++;
				
				wordNumber = (scannerLine.equals(findWord))? numPosition : 0;
				
				if(wordNumber > 0 && !positionMap.containsKey(numLines)) {
					positionMap.put(numLines, wordNumber);
				}else if(wordNumber > 0 && positionMap.containsKey(numLines)) {
					positionMap.put(numLines, positionMap.get(numLines) + (wordNumber - positionMap.get(numLines)));
				}
				
				if (!wordsMap.containsKey(scannerLine)) {
					wordsMap.put(scannerLine, 1);
				} else {
					wordsMap.put(scannerLine, wordsMap.get(scannerLine) + 1);
				}
			}
			System.out.println();
			numLines++;
			wordNumber = 0;
			numPosition = 0;
		}

		reader.close();
		wordsScanner.close();
		
		System.out.println("Broj ponavljanja rijeci " + findWord + " u fajlu je : " + wordsMap.get(findWord));	
		
		for(Integer pos : positionMap.keySet()) {
			System.out.println("Pozicija u tekstu na kojoj se riječ " + findWord + " pojavljuje je : " + pos + " red, " 
							+ positionMap.get(pos) + "-a pozicija u redu");
			//numUniqWords += (wordsMap.get(s) == 1)? 1 : 0;
			
		}
	}

}
