package kolekcije;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test4 {

	public static void timingList(List<Integer> list) {

		long start = System.currentTimeMillis();

		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		long end = System.currentTimeMillis();

		System.out.println("Vrijeme potrebno za iteraciju get(index) metodom : " + (end - start) + " ms");
		
		start = System.currentTimeMillis();
		
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next();
		}

		end = System.currentTimeMillis();

		System.out.println("Vrijeme potrebno za iteraciju pomocu iteratora : " + (end - start) + " ms");

	}

	public static void main(String[] args) {
		
		System.out.println(1E5);

		ArrayList<Integer> Arraylista = new ArrayList<>();
		LinkedList<Integer> linkanaLista = new LinkedList<>();
		
		// Ubacivanje 5 miliona cijelih brojeva u liste
				for (int i = 0; i < 1E5; i++) {
					Arraylista.add(i);
					linkanaLista.add(i);
				}
		
		System.out.println("//// Array lista ////");
		timingList(Arraylista);
		
		System.out.println();
		
		System.out.println("//// Linkana lista ////");
		timingList(linkanaLista);
		
	}

}
