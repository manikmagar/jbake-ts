package org.jbake.extensions.templates;

import java.io.File;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class LaunchOptions {

	@Option(name="-a", aliases = {"--listall"}, usage="List all available templates")
	private boolean listAll;
	
	@Option(name="-r", aliases = {"--releases"}, usage="List all releases of requested template")
	private boolean listReleases;
	
	@Option(name="-t", aliases = {"--template"}, usage="List all available templates")
	private boolean getTemplate;
	
	@Option(name = "-h", aliases = {"--help"}, usage="prints this message")
	private boolean helpNeeded;

	@Argument(index=0, usage="Specify template repo for -r and -t")
	private String templateRepo;
	
	@Argument(index=1, usage="Specify template version to be downloaded with -t")
	private String version;
	
	@Argument(index=2, usage="Specify template version to be downloaded with -t")
	private String destination;

	public boolean isListAll() {
		return listAll;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setListAll(boolean listAll) {
		this.listAll = listAll;
	}

	public boolean isListReleases() {
		return listReleases;
	}

	public void setListReleases(boolean listReleases) {
		this.listReleases = listReleases;
	}

	public boolean isGetTemplate() {
		return getTemplate;
	}

	public void setGetTemplate(boolean getTemplate) {
		this.getTemplate = getTemplate;
	}

	public String getTemplateRepo() {
		return templateRepo;
	}

	public void setTemplateRepo(String templateRepo) {
		this.templateRepo = templateRepo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	

	
	public boolean isHelpNeeded() {
		return helpNeeded;
	}

	public void setHelpNeeded(boolean helpNeeded) {
		this.helpNeeded = helpNeeded;
	}
	
	public File destinationFolder(){
		File destinationFile = new File(".");
		if(destination == null || destination.trim().isEmpty()){
			return destinationFile;
		} else {
			destinationFile = new File(destination);
			return destinationFile;
		}
	}
	
}
