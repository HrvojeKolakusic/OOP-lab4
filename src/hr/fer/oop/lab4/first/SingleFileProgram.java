package hr.fer.oop.lab4.first;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class SingleFileProgram {

	public static void main(String[] args) {
		
		Path izvor = Paths.get("d:/faks/oop/racuni/2015/9/Racun_8.txt");
		Path odrediste = Paths.get("d:/faks/oop/racuni/singleout.txt");
		
		try(InputStream is= Files.newInputStream(izvor, StandardOpenOption.READ)){
			
			MyByteWriter writer = new MyByteWriter(is, odrediste);
			writer.run();
			System.out.println(filesEquals(izvor, odrediste)); //true if files contain the same content
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean filesEquals(Path f1, Path f2) throws IOException {
        return Arrays.equals(Files.readAllBytes(f1), Files.readAllBytes(f2));
    }
}
