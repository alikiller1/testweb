package per.liuqh.job;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@Lazy(false)
@Component
public class PropertiesPrintJob {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	// m站域名
	@Value("${aa}")
	private String aa;

	
	//@Scheduled(cron = "0/3 * * * * ?")
	public void printProperties() {
		log.info("aa="+aa);
		
	}

}
