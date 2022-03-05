package hr.fer.oop.lab4.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Ocjene {

	private int broj;
	private List<Integer> sve;
	private Set<Integer> razlicite;
	private double prosjek;
	private double odstupanje;
	
	public Ocjene() {
		broj = 0;
		sve = new ArrayList<>();
		razlicite = new TreeSet<>();
		prosjek = 0;
		odstupanje = 0;
	}
	
	public void add(int ocjena) {
		broj++;
		sve.add(ocjena);
		razlicite.add(ocjena);
	}
	
	public void izracunaj() {
		double suma = 0;
		for (Integer ocjena : sve) {
			suma += ocjena;
		}
		prosjek = suma/broj;
		
		double SKR = 0; // suma kvadrata razlike
		for (Integer ocjena : sve) {
			SKR += (ocjena-prosjek) * (ocjena-prosjek);
		}
		
		odstupanje = Math.sqrt(SKR/broj);
	}
	
	public void ispisi() {

		System.out.printf("    Broj ocjena: %d%n", broj);
		
		System.out.printf("    Ocjene:");
		for (Integer ocjena : sve) {
			System.out.printf(" %d", ocjena);
		}
		System.out.println();
		
		System.out.printf("    Razlicite ocjene:");
		for (Integer ocjena : razlicite) {
			System.out.printf(" %d", ocjena);
		}
		System.out.println();
		
		System.out.println("    Prosjecna ocjena: " + prosjek);
		System.out.println("    Standardno odstupanje: " + odstupanje);
		System.out.println();
	}
	
}
