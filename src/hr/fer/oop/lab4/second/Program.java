package hr.fer.oop.lab4.second;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		FileVisitor<Path> visitor = new MySecondByteReader();
		FileVisitor<Path> visitor2 = new MySecondByteReader();
		Path racuni = Paths.get("d:/faks/oop/racuni");
		Path racuni2 = Paths.get("d:/faks/oop/racuni-privremeno");
		
		try {
			Files.walkFileTree(racuni, visitor);
			System.out.println("Broj racuna u folderu racuni prije prebacivanja je " + ((MySecondByteReader)visitor).getBrojac());
			System.out.println("Ukupna vrijednost racuna prije prebacivanja je " + ((MySecondByteReader)visitor).getUkupno());
			System.out.println();
			Files.walkFileTree(racuni2, visitor2);
			System.out.println("Broj racuna u folderu racuni_privremeno je " + ((MySecondByteReader)visitor2).getBrojac());
			System.out.println("Ukupna vrijednost racuna je " + ((MySecondByteReader)visitor2).getUkupno());
			System.out.println();
			int razlika = ((MySecondByteReader)visitor).getBrojac() - ((MySecondByteReader)visitor2).getBrojac();
			double ukupnoRazlika = ((MySecondByteReader)visitor).getUkupno() - ((MySecondByteReader)visitor2).getUkupno();
			System.out.println("Broj racuna u folderu racuni poslije prebacivanja je " + razlika);
			System.out.println("Ukupna vrijednost racuna poslije prebacivanja je " + ukupnoRazlika);
			
//			TreeSet<Artikl> artikli = ((MySecondByteReader) visitor).getArticles();
//			Writer bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("d:/faks/oop/racuni/cjenik.88592.txt")),"ISO-8859-2"));
//			Writer bw1 = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("d:/faks/oop/racuni/cjenik.utf8.txt")),"UTF-8"));
			
//			for (Artikl a: artikli) {
//				System.out.println(a.getNaziv()+";"+a.getCijena());
//				bw.write(a.getNaziv()+"\t"+a.getCijena()+"\n");
//				bw1.write(a.getNaziv()+"\t"+a.getCijena()+"\n");
//			}
//			bw.close();
//			bw1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
