/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.thomasmore.projectwerk.app.register.domain.entities;

import be.thomasmore.projectwerk.app.register.web.model.ApplicationPropertyDto;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATIONS")
public class ApplicationEntity extends BaseTrackableEntity {

    private String name;
    private String appVersion;
	private String environment;
	private int applicationPropertiesList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int getApplicationPropertiesList() {
		return applicationPropertiesList;
	}

	public void setApplicationPropertiesList(int applicationPropertiesList) {
		this.applicationPropertiesList = applicationPropertiesList;
	}
}
