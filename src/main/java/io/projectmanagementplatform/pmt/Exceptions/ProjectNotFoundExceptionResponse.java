package io.projectmanagementplatform.pmt.Exceptions;

public class ProjectNotFoundExceptionResponse {

    private String projectNotFound;

    public ProjectNotFoundExceptionResponse(String projectNotFound){

        this.projectNotFound = projectNotFound;
    }

    public String getProjectNotFound() {

        return projectNotFound;
    }

    public void setProjectNotFound(String projectIdentifier) {

        this.projectNotFound = projectNotFound;
    }
}

