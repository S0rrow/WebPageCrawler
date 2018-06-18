package edu.handong.csee.java.WebPageCrawler;

import java.net.MalformedURLException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
/**
 * 
 * @author s0rrow
 *
 */
public class MainCrawler {
	String url;
	String outputPath;
	public static void main(String[] args) {
		MainCrawler creeper = new MainCrawler();
		creeper.run(args);
	}
	
	private void run(String[] args) {
		
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			
			System.out.println("Url:"+url+"\n");
			
		}
		
		try {
			URLReader given = new URLReader(url);
			FileAshtml file = new FileAshtml(outputPath);
			file.doWrite(given.getStream());
			
		} catch(MalformedURLException e) {
			e.getMessage();
		}
		
	}
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			url = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("d");
			
		} catch (Exception e) {
			printHelp(options);
			return false;
		}
		return true;
	}
	
	private Options createOptions() {
		Options options = new Options();
		
		options.addOption(Option.builder("u").longOpt("url")
				.desc("Give the url to save as html file")
				.hasArg()
				.argName("url to save html")
				.required()
				.build());
		
		options.addOption(Option.builder("d").longOpt("destination")
				.desc("Set destination directory to get the html file saved")
				.hasArg()
				.argName("html file destination")
				.required()
				.build());
		
		return options;
	}
	
	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "webpage crawler program";
		String footer ="\nissues may be reported to https://github.com/S0rrow/WebPageCrawler";
		formatter.printHelp("WebPageCrawler", header, options, footer, true);
	}
}
