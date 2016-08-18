/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.thomasmore.projectwerk.app.register.web.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucs
 */
public class ApplicationDto {
    
    public String name;
    public String version;
	public String environment;
	public List<ApplicationPropertyDto> propertylist = new LinkedList<>();
	
	public void addProperty(String name, String value) {
		ApplicationPropertyDto pent = new ApplicationPropertyDto();
		pent.setName(name);
		pent.setValue(value);
		propertylist.add(pent);
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public List<ApplicationPropertyDto> getPropertylist() {
		return propertylist;
	}

	public void setPropertylist(List<ApplicationPropertyDto> propertylist) {
		this.propertylist = propertylist;
	}
}
