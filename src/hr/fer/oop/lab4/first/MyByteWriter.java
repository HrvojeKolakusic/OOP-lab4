package hr.fer.oop.lab4.first;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MyByteWriter {
	
	protected InputStream inputStream;
	protected Path odrediste;
	
	public MyByteWriter(InputStream inputStream, Path newFile){
		this.inputStream = inputStream;
		this.odrediste = newFile;
	}
	
	protected void createFile(){
		try {
			Files.createFile(odrediste);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		
		//create new file to rewrite the original
		if(Files.notExists(this.odrediste, LinkOption.NOFOLLOW_LINKS)){
			this.createFile();
		}
		
		//open output stream on a new file, and rewrite the given input stream in it
		try(OutputStream os= Files.newOutputStream(this.odrediste, StandardOpenOption.WRITE)){
			byte [] buffer = new byte[1024];
			BufferedInputStream bis = new BufferedInputStream(this.inputStream);
			while(true){
				int numOfReadBytes = bis.read(buffer);
				if(numOfReadBytes<1) break;
				os.write(buffer, 0, numOfReadBytes);
			}
			
			//close all opened streams
			bis.close();
			this.inputStream.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
