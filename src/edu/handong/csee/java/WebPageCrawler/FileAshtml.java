package edu.handong.csee.java.WebPageCrawler;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author s0rrow
 *
 */
public class FileAshtml {
	String dir = "";
	String aLine = "";
	public FileAshtml(String output) {
		dir = output;
	}
	public void doWrite(BufferedReader br) {
		try {
		FileWriter writer = new FileWriter(dir+"\\index.html");
		while((aLine = br.readLine())!= null) {
			writer.append(aLine);
		}
		writer.flush();
		writer.close();
		} catch (IOException e) {
			System.out.println("Problem with output to file " + dir);
		}
		
	}
}
