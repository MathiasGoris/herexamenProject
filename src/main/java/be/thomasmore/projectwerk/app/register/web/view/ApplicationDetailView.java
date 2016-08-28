/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.thomasmore.projectwerk.app.register.web.view;

import be.thomasmore.projectwerk.app.register.web.facade.ApplicationFacade;
import be.thomasmore.projectwerk.app.register.web.model.ApplicationPropertyDto;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("applicationDetail")
public class ApplicationDetailView {
	
	private List<ApplicationPropertyDto> allApplicationProperties = new LinkedList<>();
	private List<ApplicationPropertyDto> applicationProperties = new LinkedList<>();
	private String id;
	
	@EJB
    private ApplicationFacade facade;

    @PostConstruct
    public void init() {
        allApplicationProperties = facade.listAllProperties();
		
    }
	
	public List<ApplicationPropertyDto> getApplicationProperties() {
		List<ApplicationPropertyDto> result = new LinkedList<>();
		
		for (ApplicationPropertyDto apdto : allApplicationProperties) {
			if (apdto.appId.equals(id)) {
				result.add(apdto);
			}
		}
		
        return result;
    }

    public void setApplications(List<ApplicationPropertyDto> applicationProperties) {
        this.allApplicationProperties = applicationProperties;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
