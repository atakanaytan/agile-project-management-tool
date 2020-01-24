package io.projectmanagementplatform.pmt.Exceptions;

public class ProjectIdentifierExceptionResponse {
    private String projectIdentifier;

    public ProjectIdentifierExceptionResponse(String projectIdentifier){
        this.projectIdentifier=projectIdentifier;
    }

    public String getProjectIdentifier(){ return projectIdentifier;}

    public void setProjectIdentifier(String projectIdentifier){this.projectIdentifier = projectIdentifier;}
}
