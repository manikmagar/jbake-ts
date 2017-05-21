package org.jbake.extensions.templates.model;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Template {

	    private String name;
	    private String summary;
	    private String author;
	    private String repoName;
	    
	    List<TemplateRelease> releasedVersions;
	    
	    public Template(){
	    	
	    }
	    
	    public Template(String repoName){
	    	this.setRepoName(repoName);
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getRepoName() {
			return repoName;
		}

		public void setRepoName(String repoName) {
			this.repoName = repoName;
		}

		public List<TemplateRelease> getReleasedVersions() {
			return releasedVersions;
		}

		public void setReleasedVersions(List<TemplateRelease> releasedVersions) {
			this.releasedVersions = releasedVersions;
		}
		
		public TemplateRelease findRelease(String version){
			if (version == null || releasedVersions == null) return null;
			TemplateRelease release = null;
			for(TemplateRelease rel : releasedVersions){
				if(rel.getReleaseVersion().equalsIgnoreCase(version)){
					release = rel;
					break;
				}
			}
			return release;
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Template Name: "+ this.getName() + "\r\n");
			sb.append("Template Author: "+ this.getAuthor() + "\r\n");
			sb.append("Summary: "+ this.getSummary() + "\r\n");
			sb.append("Repo Name: "+ this.getRepoName() + "\r\n");
			if(releasedVersions != null && !releasedVersions.isEmpty()){
				String format = "%s|%s|\r\n";
				sb.append("---------------------------------------------\r\n");
				String header = String.format( format, StringUtils.rightPad("Version", 10, " "), StringUtils.rightPad("Summary", 100, " "));
				sb.append(header);
				for(TemplateRelease release : releasedVersions){
					sb.append(release.toString());
				}
				sb.append("---------------------------------------------\r\n");
			}
			sb.append("###################################################\r\n");
			return sb.toString();
		}
			    
}
