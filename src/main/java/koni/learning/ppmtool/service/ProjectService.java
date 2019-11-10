package koni.learning.ppmtool.service;

import koni.learning.ppmtool.domain.Project;
import koni.learning.ppmtool.exceptions.ProjectIdException;
import koni.learning.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {
		try {
			return projectRepository.save(project);
		} catch (Exception ex) {
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
		}
	}

	public Project findProjectByIdentifier(String projectIdentifier) {
		Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("Project with ID '" + projectIdentifier.toUpperCase() + "' doesn't exist");
		}
		return project;
	}

	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
	}

	public void deleteProjectByIdentifier(String projectIdentifier) {
		Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("Project with ID '" + projectIdentifier.toUpperCase() + "' doesn't exist");
		}
		projectRepository.delete(project);
	}
}
