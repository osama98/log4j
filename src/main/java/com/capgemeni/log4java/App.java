package com.capgemeni.log4java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class App {
	
	private final static Logger log = Logger.getLogger(App.class);
	
	private static String log4j = new File("src/main/java/com/capgemeni/log4java/log4j.properties").getAbsolutePath();
	
	private static String log4jPath = log4j.replace("\\", "/");

	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure(log4jPath);
		
		FileReader fileReader = null;
		BufferedReader reader = null;
		
		try {
			String file = new File("src/main/java/com/capgemeni/log4java/files/app2.txt").getAbsolutePath();
			String playersFile = file.replace("\\", "/");
			fileReader = new FileReader(playersFile);
			reader = new BufferedReader(fileReader);
			
			
			String jugador = "";
			while((jugador = reader.readLine()) != null) {
				System.out.println(jugador);
			}
		} catch(FileNotFoundException e){
			System.out.println("Se enviará el error por correo");
			log.fatal(e);
		}

	}

}
