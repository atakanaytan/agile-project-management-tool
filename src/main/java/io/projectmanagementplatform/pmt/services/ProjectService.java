package io.projectmanagementplatform.pmt.services;

import io.projectmanagementplatform.pmt.Exceptions.ProjectIdException;
import io.projectmanagementplatform.pmt.domain.Project;
import io.projectmanagementplatform.pmt.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.projectmanagementplatform.pmt.Exceptions.ProjectIdException;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exist");
        }
    }

    public Project findProjectByIdentifier(String projectId ){
           Project project = projectRepository.findByProjectIdentifier(projectId);

           if(project == null) {
               throw new ProjectIdException("Project ID '"+projectId+"' does not exist");
           }
            return project;
    }

    public Iterable<Project> findAllProjects(){
            return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);

        if(project == null){
            throw new ProjectIdException("Cannot Project with ID ' "+projectId+"'. This project does not exist");
        }

        projectRepository.delete(project);
    }
}
