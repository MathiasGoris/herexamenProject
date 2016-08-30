/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.thomasmore.projectwerk.app.register.web.view;

import be.thomasmore.projectwerk.app.register.web.facade.ApplicationFacade;
import be.thomasmore.projectwerk.app.register.web.model.ApplicationDto;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author lucs
 */
@RequestScoped
@Named("applicationOverview")
public class ApplicationsOverviewView {
    
    private List<ApplicationDto> applicationlist = new LinkedList<>();
	private String appId;
	private String appName;
	private String appVersion;
	private String appEnvironment;

    @EJB
    private ApplicationFacade facade;

    @PostConstruct
    public void init() {
        applicationlist = facade.listAll();
    }

	public List<ApplicationDto> getApplicationlist() {
		return applicationlist;
	}

	public void setApplicationlist(List<ApplicationDto> applicationlist) {
		this.applicationlist = applicationlist;
	}
	
	public void createApplication(ActionEvent e){
		ApplicationDto dto = new ApplicationDto();
		dto.setName(appName);
		dto.setEnvironment(appEnvironment);
		dto.setVersion(appVersion);
		facade.create(dto);
		
		appName = "";
		appEnvironment = "";
		appVersion = "";
		
		applicationlist = facade.listAll();
	}
	
	public void deleteApplication(String id) {
		facade.delete(id);
		
		applicationlist = facade.listAll();
	}

	public void updateApplication(String appId, String appName, String appVersion, String appEnvironment) {
		facade.update(appId, appName,appVersion,appEnvironment);
		
		applicationlist = facade.listAll();
	}


	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppEnvironment() {
		return appEnvironment;
	}

	public void setAppEnvironment(String appEnvironment) {
		this.appEnvironment = appEnvironment;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
}
