package projects.exception;

import projects.entity.Project;


public class ProjectService {

	public class ProjectService {
		private ProjectDao projectDao = new ProjectDao();
		
		public Project addProject(Project project) {
			return projectDao.insertProject(project);
		}
	}
	
	

