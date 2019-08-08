package com.urswolfer.gerrit.client.rest.http.projects;

import com.google.gerrit.extensions.api.changes.ChangeApi;
import com.google.gerrit.extensions.api.changes.CherryPickInput;
import com.google.gerrit.extensions.api.projects.CommitApi;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gson.JsonElement;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;

/**
 * @author lee.lian
 * @version 
 * @desc 
 */
public class CommitApiRestClient extends CommitApi.NotImplemented implements CommitApi{
	
	private GerritRestClient gerritRestClient;
	private ProjectApiRestClient projectApiRestClient;
	private String commit;
	
	public CommitApiRestClient(GerritRestClient gerritRestClient, ProjectApiRestClient projectApiRestClient, String commit) {
		this.gerritRestClient = gerritRestClient;
		this.projectApiRestClient = projectApiRestClient;
		this.commit = commit;
	}

	@Override
	public ChangeApi cherryPick(CherryPickInput input) throws RestApiException {
		JsonElement e = this.gerritRestClient.getRequest(projectApiRestClient.projectsUrl() + "/commits/" + commit + "/files");
		System.out.println(e);
		return null;
	}
}
