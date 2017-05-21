package org.jbake.extensions.templates;


import java.io.File;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main {

	public static void main(String[] args) {
		
		new Main().run(args);
		
	}
	
	protected void run(String[] args) {
		LaunchOptions res = parseArguments( args );
		
		Templates templates = new Templates();
		
		if(res.isListAll()){
			templates.listAvailableTemplates(System.out);
		}
		if (res.isListReleases()){
			String templateRepo = res.getTemplateRepo();
			templates.listTemplateReleases(templateRepo, System.out);
		}
		if (res.isGetTemplate()){
			String templateRepo = res.getTemplateRepo();
			String version = res.getVersion();
			File destination = res.destinationFolder();
			templates.downloadTemplate(templateRepo, version, destination, System.out);
		}
		
	}    
	
	private LaunchOptions parseArguments(String[] args) {
		LaunchOptions res = new LaunchOptions();
		CmdLineParser parser = new CmdLineParser(res);

		try {
			parser.parseArgument(args);
		} catch (final CmdLineException e) {
			printUsage(res);
		}

		return res;                
	}
	
	private void printUsage(Object options) {
		CmdLineParser parser = new CmdLineParser(options);
		parser.getProperties().withUsageWidth(100);
		parser.printUsage(System.out);
	}

}
