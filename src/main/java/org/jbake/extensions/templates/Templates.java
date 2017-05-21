package org.jbake.extensions.templates;

import java.io.File;
import java.io.PrintStream;

import org.jbake.extensions.templates.model.Template;
import org.jbake.extensions.templates.model.TemplateRelease;
import org.jbake.extensions.templates.repositories.GithubTemplateRepository;
import org.jbake.extensions.templates.repositories.TemplateRepository;

public class Templates {

	private TemplateRepository repository;
	
	
	public Templates(){
		repository = new GithubTemplateRepository();
	}
	
	public void listAvailableTemplates(PrintStream out){
		Template template = new Template();
		template.setName("jbake-future-imperfect-template");
		template.setAuthor("Manik Magar");
		template.setRepoName("manikmagar/jbake-future-imperfect-template");
		template.setSummary("HTML5 based blog template");
		
		out.print(template.toString());
	}
	
	public void listTemplateReleases(String templateRepo, PrintStream out){
		
		try {
			Template template = new Template(templateRepo);
			repository.loadTemplateReleases(template);
			out.println(template.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void downloadTemplate(String templateRepo, String version, File destination, PrintStream out){
		try {
			Template template = new Template(templateRepo);
			repository.loadTemplateReleases(template);
			TemplateRelease release = template.findRelease(version);
			if(release == null){
				out.println("Unable to find template: "+ templateRepo + "/" + version);
				out.println("List all available templates with option -a or list available releases for a template repo with -r {templateRepo}");
				return;
			}
			String generatePath = repository.downloadAndExrtact(release, destination);
			out.println("Extracted template at: "+ generatePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
