package per.liuqh.job;

import java.io.File;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@Lazy(false)
@Component
public class PropertiesReLoadJob {
	private static long lastModified=0l;
	private static long count=1;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Resource
	private ConfigurableWebApplicationContext wac;

	@Scheduled(cron = "0/2 * * * * ?")
	public void reloadProperties() {
		try{
		 File f=new File("/config/application.properties");
		 long t=f.lastModified();
		 if(count==1){
			 lastModified=t;
		 }
		 long currTime=t;
		 
		 if(currTime!=lastModified){
			 log.info("change");
			 lastModified=t;
			 wac.refresh();
		 }
		 count++;
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}

}
