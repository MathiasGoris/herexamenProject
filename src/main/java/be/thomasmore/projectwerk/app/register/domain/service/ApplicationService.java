package be.thomasmore.projectwerk.app.register.domain.service;

import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationEntity;
import java.util.List;

public interface ApplicationService {

    public List<ApplicationEntity> list();

    void save(ApplicationEntity ae);

	void delete(String appId);

	void update(String appId, String appName, String appVersion, String appEnvironment);
    
}
