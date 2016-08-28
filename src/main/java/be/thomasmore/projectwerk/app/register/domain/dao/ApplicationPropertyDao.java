/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.thomasmore.projectwerk.app.register.domain.dao;

import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationPropertyEntity;
import java.util.List;


public interface ApplicationPropertyDao {
	public List<ApplicationPropertyEntity> listAll();
	
	public void save(ApplicationPropertyEntity ape);

}
