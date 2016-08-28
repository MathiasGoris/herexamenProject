/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.thomasmore.projectwerk.app.register.domain.service;


import be.thomasmore.projectwerk.app.register.domain.dao.ApplicationPropertyDao;
import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationPropertyEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thomas
 */
@Stateless
public class ApplicationPropertyServiceImpl implements ApplicationPropertyService {
	@EJB
    private ApplicationPropertyDao dao;

    @Override
    public List<ApplicationPropertyEntity> list() {
        return dao.listAll();
    }
    
    @Override
    public void save(ApplicationPropertyEntity ae) {
         dao.save(ae);
    }
}
