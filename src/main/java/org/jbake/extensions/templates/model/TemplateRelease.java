package org.jbake.extensions.templates.model;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.kohsuke.github.GHAsset;
import org.kohsuke.github.GHRelease;

public class TemplateRelease {
	private String url;
 	private String releaseVersion;
    private String name;
    private String body;
    private Date published_at;
    private String downloadUrl;
    private String releaseTitle;
    
    
    
    public String getReleaseTitle() {
		return releaseTitle;
	}



	public void setReleaseTitle(String releaseTitle) {
		this.releaseTitle = releaseTitle;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getReleaseVersion() {
		return releaseVersion;
	}



	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBody() {
		return body;
	}



	public void setBody(String body) {
		this.body = body;
	}



	public Date getPublished_at() {
		return published_at;
	}



	public void setPublished_at(Date published_at) {
		this.published_at = published_at;
	}



	public String getDownloadUrl() {
		return downloadUrl;
	}



	public void setDownloadUrl(String zipUrl) {
		this.downloadUrl = zipUrl;
	}



	public static TemplateRelease fromGithub(GHRelease ghRelease){
		TemplateRelease release = new TemplateRelease();
		release.setBody(ghRelease.getBody());
		release.setName(ghRelease.getOwner().getName());
		release.setReleaseTitle(ghRelease.getName());
		release.setPublished_at(ghRelease.getPublished_at());
		release.setReleaseVersion(ghRelease.getTagName());
		
		
		try {
			for (GHAsset asset : ghRelease.getAssets()){
				if(asset.getContentType().equalsIgnoreCase("application/zip")){
					release.setDownloadUrl(asset.getBrowserDownloadUrl());
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return release;
	}
	
	@Override
	public String toString() {
		String format = "%s|%s|\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(String.format(format, getVersionString(this.getReleaseVersion()),getSummaryString(this.getBody())));
		return sb.toString();
	}
	
	private String getVersionString(String version){
		return StringUtils.rightPad(version, 10, " ");
	}
	private String getSummaryString(String summary){
		return StringUtils.rightPad(summary, 100, " ");
	}
}
