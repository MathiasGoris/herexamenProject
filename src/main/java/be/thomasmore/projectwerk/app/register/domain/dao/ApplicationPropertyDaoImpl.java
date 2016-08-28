/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.thomasmore.projectwerk.app.register.domain.dao;

import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationPropertyEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ApplicationPropertyDaoImpl extends BaseDaoImpl<ApplicationPropertyEntity> implements ApplicationPropertyDao {
	
	@PersistenceContext(unitName = "appregPU")
    protected EntityManager em;
	
	@Override
    protected EntityManager em() {
        return em;
    }
    
    @Override
    protected Class<ApplicationPropertyEntity> entityClass() {
        return ApplicationPropertyEntity.class;
    }
}
