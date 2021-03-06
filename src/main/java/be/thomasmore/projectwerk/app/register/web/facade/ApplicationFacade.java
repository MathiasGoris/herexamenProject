/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.thomasmore.projectwerk.app.register.web.facade;

import be.thomasmore.projectwerk.app.register.web.model.ApplicationDto;
import be.thomasmore.projectwerk.app.register.web.model.ApplicationPropertyDto;
import java.util.List;

/**
 *
 * @author lucs
 */
public interface ApplicationFacade {
    
    List<ApplicationDto> listAll();
	 
	List<ApplicationPropertyDto> listAllProperties();

    void create(ApplicationDto dto);

	void delete(String appId);

	void update(String appId, String appName, String appVersion, String appEnvironment);
}
