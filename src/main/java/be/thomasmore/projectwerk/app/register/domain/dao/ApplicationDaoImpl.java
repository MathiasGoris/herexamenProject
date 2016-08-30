package be.thomasmore.projectwerk.app.register.domain.dao;

import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ApplicationDaoImpl extends BaseDaoImpl<ApplicationEntity>implements ApplicationDao {

    @PersistenceContext(unitName = "appregPU")
    protected EntityManager em;

    @Override
    protected EntityManager em() {
        return em;
    }
	
	@Override
	public void delete(String id){
		ApplicationEntity ae = em.getReference(ApplicationEntity.class, id);
		em.remove(ae);
		em.flush();
	}
	
	@Override
	public void update(String appId, String appName, String appVersion, String appEnvironment) {
		ApplicationEntity ae = em.getReference(ApplicationEntity.class, appId);
		ae.setName(appName);
		ae.setAppVersion(appVersion);
		ae.setEnvironment(appEnvironment);
		
		em.flush();
	}

    @Override
    protected Class<ApplicationEntity> entityClass() {
        return ApplicationEntity.class;
    }
}
