package koni.learning.ppmtool.service;

import koni.learning.ppmtool.domain.Project;
import koni.learning.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {
		return projectRepository.save(project);
	}
}
