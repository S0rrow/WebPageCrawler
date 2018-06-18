package edu.handong.csee.java.WebPageCrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 * 
 * @author s0rrow
 *
 */
public class URLReader {
	URL given;
	
	public URLReader(String url) throws MalformedURLException {
		given = new URL(url);
	}
	public BufferedReader getStream() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(given.openStream()));
		} catch(IOException e) {
			e.getMessage();
		}
		return br;
	}
}
