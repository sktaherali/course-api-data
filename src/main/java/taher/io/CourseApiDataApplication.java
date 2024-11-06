package taher.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = "taher.io.repository")
@EnableScheduling
public class CourseApiDataApplication {
	@Autowired
	CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}
	
	@Scheduled(cron = "0 0/1 * * * ?")
	public void clearRedisCache() {
		for(String manes:cacheManager.getCacheNames()) {
			cacheManager.getCache(manes).clear();
		}
	}

}
