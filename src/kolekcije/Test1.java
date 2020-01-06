package kolekcije;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test1 {

	public static void listNames(Collection<String> list, Path path) throws IOException {

		Scanner sc2 = new Scanner(path);
		String str;
		while (sc2.hasNext()) {
			str = sc2.next();
			//System.out.println(str);
			list.add(str);
		}
		sc2.close();
	}

	public static void main(String[] args) throws IOException {

		Scanner unos = new Scanner(System.in);
		System.out.print("Unesite ime fajla: ");
		String fileName = unos.next();

		Path putanja = Paths.get(fileName);

		if (!Files.exists(putanja)) {
			System.out.println("File " + putanja.getFileName() + " doesn't exists.");
		}

		System.out.print("Odaberite a za ispis svih rijeci, b za ispis rijeci bez duplikata: ");
		char odabir = unos.next().charAt(0);

		if (odabir == 'a') {

			ArrayList<String> Arraylista = new ArrayList<>();			
			listNames(Arraylista, putanja);
			
			Iterator<String> iteratorArray = Arraylista.iterator();
			while(iteratorArray.hasNext()) {
				System.out.println(iteratorArray.next());
			}

		} else if (odabir == 'b') {

			Set<String> setLista = new TreeSet<>();			
			listNames(setLista, putanja);
			
			Iterator<String> iteratorSet = setLista.iterator();
			while(iteratorSet.hasNext()) {
				System.out.println(iteratorSet.next());
			}
			
		}
	}

}
