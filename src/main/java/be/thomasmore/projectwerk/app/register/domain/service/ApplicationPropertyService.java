/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.thomasmore.projectwerk.app.register.domain.service;

import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationPropertyEntity;
import java.util.List;

/**
 *
 * @author thomas
 */
public interface ApplicationPropertyService {
	
	public List<ApplicationPropertyEntity> list();

    void save(ApplicationPropertyEntity ae);
    
}
