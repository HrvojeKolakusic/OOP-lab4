package hr.fer.oop.lab4.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TreeSet;

public class MySecondByteReader extends SimpleFileVisitor<Path>{
	
	protected double ukupno;
	protected int brojac;
	
	public MySecondByteReader() {
		ukupno = 0;
		brojac = 0;
	}
	
	public double getUkupno() {
		return ukupno;
	}
	
	public int getBrojac() {
		return brojac;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		//System.out.println("reading file :" + file.toString());
		if (file.toString().endsWith("txt")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file, StandardOpenOption.READ)));
			while (true) {
				String line = br.readLine();
				line.trim();
				if (line.startsWith("UKUPNO")) {
					String[] parts = line.split("\\s+");
					ukupno += Double.parseDouble(parts[1]);
					brojac++;
					break;
				}
			}
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

}
