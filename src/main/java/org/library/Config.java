package org.library;

import org.library.monitoring.MonitorEventRepository;
import org.library.monitoring.MonitoringAspect;
import org.library.monitoring.MonitoringEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = org.library.monitoring.MonitorEventRepository.class)
public class Config {

    @Bean
    public MonitoringEvent monitoringEvent() {
        return new MonitoringEvent();
    }

    @Bean
    public MonitoringAspect monitoringAspect(MonitorEventRepository eventRepository) {
        return new MonitoringAspect(eventRepository);
    }
}
