package org.jbake.extensions.templates.repositories;

import java.io.File;
import java.util.List;

import org.jbake.extensions.templates.model.Template;
import org.jbake.extensions.templates.model.TemplateRelease;

public interface TemplateRepository {
	
	List<Template> listAvaiableTemplates() throws Exception;

	void loadTemplateReleases(Template template) throws Exception;
	
	/**
	 * Downloads the Zip release of template, extracts it and returns the extracted folder path
	 * @param template
	 * @param destination
	 * @return
	 * @throws Exception
	 */
	String downloadAndExrtact(TemplateRelease template, File destination) throws Exception;
	
	
}
