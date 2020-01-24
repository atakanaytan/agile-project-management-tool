package io.projectmanagementplatform.pmt.repositories;

import io.projectmanagementplatform.pmt.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}
