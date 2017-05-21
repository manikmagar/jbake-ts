package org.jbake.extensions.templates.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jbake.extensions.templates.model.Template;
import org.jbake.extensions.templates.model.TemplateRelease;
import org.jbake.extensions.templates.util.ZipUtil;
import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;

public class GithubTemplateRepository extends AbstractTemplateRepository {
	
	private static GitHub github;
	
	static {
		try {
			github = GitHub.connectAnonymously();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public String downloadAndExrtact(TemplateRelease template, File destination) throws Exception {
		URL url = new URL(template.getDownloadUrl());
		File targetZip = new File(destination, Long.toString(System.currentTimeMillis()));
		FileUtils.copyURLToFile(url, targetZip);
		File targetTemplateRoot = destination;
		ZipUtil.extract(new FileInputStream(targetZip), targetTemplateRoot);
		targetZip.delete();
		return targetTemplateRoot.getAbsolutePath();
	}

	@Override
	public void loadTemplateReleases(Template template) throws Exception {
		GHRepository repo = github.getRepository(template.getRepoName());
		PagedIterable<GHRelease> pagedreleases = repo.listReleases();
		List<GHRelease> releases = pagedreleases.asList();
		List<TemplateRelease> lstReleases = new ArrayList<TemplateRelease>();
		for (GHRelease release : releases) {
			lstReleases.add(TemplateRelease.fromGithub(release));
		}
		template.setReleasedVersions(lstReleases);
	}
	
}
