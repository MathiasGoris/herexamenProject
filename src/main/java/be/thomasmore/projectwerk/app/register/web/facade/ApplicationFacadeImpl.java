package be.thomasmore.projectwerk.app.register.web.facade;

import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationEntity;
import be.thomasmore.projectwerk.app.register.domain.entities.ApplicationPropertyEntity;
import be.thomasmore.projectwerk.app.register.domain.service.ApplicationPropertyService;
import be.thomasmore.projectwerk.app.register.domain.service.ApplicationService;
import be.thomasmore.projectwerk.app.register.web.model.ApplicationDto;
import be.thomasmore.projectwerk.app.register.web.model.ApplicationPropertyDto;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ApplicationFacadeImpl implements ApplicationFacade{

    @EJB
    private ApplicationService applicationService;
	private ApplicationPropertyService applicationPropertyService;
    
    @Override
    public List<ApplicationDto> listAll() {
        List<ApplicationDto> dtos = new LinkedList<>();
        List<ApplicationEntity> entities = applicationService.list();
		
        for (ApplicationEntity entity : entities) {
            ApplicationDto dto = new ApplicationDto();
			dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setVersion(entity.getAppVersion());
			dto.setEnvironment(entity.getEnvironment());
            dtos.add(dto);
        }
        
        return dtos;
    }
	
	@Override
    public List<ApplicationPropertyDto> listAllProperties() {
		List<ApplicationPropertyDto> dtos = new LinkedList<>();
        List<ApplicationPropertyEntity> entities = applicationPropertyService.list();
		
		for (ApplicationPropertyEntity entity : entities) {
            ApplicationPropertyDto dto = new ApplicationPropertyDto();
			dto.setAppId(entity.getAppid());
			dto.setName(entity.getName());
			dto.setValue(entity.getValue());
            dtos.add(dto);
        }
        
        return dtos;
	}
	
    @Override
    public void create(ApplicationDto dto) {
        ApplicationEntity ae = new ApplicationEntity();
		ApplicationPropertyEntity ape  = new ApplicationPropertyEntity();
        ae.setAppVersion(dto.getVersion());
        ae.setName(dto.getName());
		ae.setEnvironment(dto.getEnvironment());
		
		for (ApplicationPropertyDto i : dto.getPropertylist()){
			ape.setName(i.getName());
			ape.setValue(i.getValue());
			ape.setAppid(ae.getId());
			applicationPropertyService.save(ape);
		}
		
        applicationService.save(ae);
    }

	@Override
	public void delete(String appId) {
		applicationService.delete(appId);
	}

	@Override
	public void update(String appId, String appName, String appVersion, String appEnvironment) {
		applicationService.update(appId, appName, appVersion, appEnvironment);
	}
    
    
}
