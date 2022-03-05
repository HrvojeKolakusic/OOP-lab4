package hr.fer.oop.lab4.third;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String ime;
		Integer ocjena;
		Map<String, Ocjene> mapa = new LinkedHashMap<>();
		
		while (true) {
			System.out.printf("Unesite ime i ocjenu: ");
			ime = sc.next();
			if (ime.equals("KRAJ")) break;
			ocjena = sc.nextInt();
			
			if (mapa.containsKey(ime)) {
				mapa.get(ime).add(ocjena);
				
			} else {
				mapa.put(ime, new Ocjene());
				mapa.get(ime).add(ocjena);
			}
			System.out.println();
		}
		
		for (Map.Entry<String, Ocjene> par : mapa.entrySet()) {
			
			System.out.println("Ucenik " + par.getKey());
			par.getValue().izracunaj();
			par.getValue().ispisi();
		}
		
		sc.close();
	}
}
