package be.thomasmore.projectwerk.app.register.domain.service;

import be.thomasmore.projectwerk.app.register.domain.dao.ApplicationDao;
import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ApplicationServiceImpl implements ApplicationService{
    
    @EJB
    private ApplicationDao dao;

    @Override
    public List<ApplicationEntity> list() {
        return dao.listAll();
    }
    
    @Override
    public void save(ApplicationEntity ae) {
         dao.save(ae);
    }

	@Override
	public void delete(String appId) {
		dao.delete(appId);
	}

	@Override
	public void update(String appId, String appName, String appVersion, String appEnvironment) {
		dao.update(appId,appName,appVersion,appEnvironment);
	}
    
}
