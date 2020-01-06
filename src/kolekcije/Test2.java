package kolekcije;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {
	
	/*
	public static void removeDuplicates(ArrayList<Integer> list, int x) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == x) {				
				break;
			} 
			else if(list.get(i) != x && i < list.size()-1 ) {
				continue;
			}
			else if(list.get(i) != x && i == list.size()-1) {
				list.add(x);
				break;
			}
		}
	}*/

	public static void main(String[] args) {
				
		/* Ne pohranjivati duplikate brojeva!!!!  */
		
		Scanner unos = new Scanner(System.in);
		ArrayList<Integer> brojevi = new ArrayList<>();
		int broj = 1;
		char izbor ; 
		
		Set<Integer> set = new HashSet<>();
		
		System.out.println("Unesite neodređeni broj cijelih brojeva (0 prekida unos) ");

		
		while ( (broj = unos.nextInt()) != 0) {
			
			brojevi.add(broj);
			
			/*
			if(brojevi.size() == 0) {
				brojevi.add(broj);
				continue;
			}
			removeDuplicates(brojevi, broj);*/
					
		}		
				
		System.out.print("Odaberite a za sortiranje brojeva(sort), b za mijesanje brojeva(shuffle) \n"
				+ "ili c za da sortira brojeve u silazećem redosljedu? (reverse sort) : ");
		izbor = unos.next().charAt(0);
		
		if( izbor == 'a' ) {
			set = new TreeSet<>(brojevi);
			System.out.println("Sortiranje u rastucem redoslijedu:");
			//Collections.sort(brojevi);	
			
		} else if( izbor == 'b' ) {
			Collections.shuffle(brojevi);
			set = new LinkedHashSet<>(brojevi);
			System.out.println("Premjestanje u kolekciji:");
			
			
		} else if( izbor == 'c' ) {	
			Collections.sort(brojevi);
			Collections.reverse(brojevi);
			set = new LinkedHashSet<>(brojevi);
			System.out.println("Sortiranje u silazecem redoslijedu:");
		}
		
        System.out.println("Modificirana lista brojeva je: "); 
        
        for(Integer inter : brojevi) {
			System.out.print(inter + " ");
		}System.out.println();
        
        for(Integer inter : set) {
			System.out.print(inter + " ");
		}
	}

}
