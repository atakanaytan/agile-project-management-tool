package io.projectmanagementplatform.pmt.services;

import io.projectmanagementplatform.pmt.domain.Backlog;
import io.projectmanagementplatform.pmt.domain.Project;
import io.projectmanagementplatform.pmt.domain.ProjectTask;
import io.projectmanagementplatform.pmt.repositories.BacklogRepository;
import io.projectmanagementplatform.pmt.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {

        //ProjectTasks to be added to specific project, project != null, BackLog means exist
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the backlog to ProjectTask

        projectTask.setBacklog(backlog);
        //Project sequence will show a like IDPRO-1, IDPRO-2
        Integer BacklogSequence = backlog.getPTSequence();
        //Update BackLog Sequence
        BacklogSequence++;
        backlog.setPTSequence(BacklogSequence);

        //Add sequence to projectTask
        projectTask.setProjectSequence(projectIdentifier+ "-"+ BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        //Initial Priorty when priority is null

        //Initial status when status is null

        if(projectTask.getStatus()== "" || projectTask.getStatus()== null){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }
}
