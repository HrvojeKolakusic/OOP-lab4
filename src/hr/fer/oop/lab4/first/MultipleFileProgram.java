package hr.fer.oop.lab4.first;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MultipleFileProgram {
	
	protected static void createFile(Path path){
		try {
			Files.createFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Path racuni = Paths.get("d:/faks/oop/racuni/"); // directory where all receipts are stored
		Path outputFile = Paths.get("d:/faks/oop/racuni/sviRacuni.txt"); //destination txt file
		
		if(Files.notExists(outputFile, LinkOption.NOFOLLOW_LINKS)){
			createFile(outputFile);
		}
		try {
			OutputStream os = Files.newOutputStream(outputFile, StandardOpenOption.WRITE);
			FileVisitor<Path> visitor = new MyByteReader(os);
			Files.walkFileTree(racuni, visitor);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
