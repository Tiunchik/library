package org.library;

import org.library.monitoring.MonitorEventRepository;
import org.library.monitoring.MonitoringAspect;
import org.library.monitoring.MonitoringEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public MonitoringEvent monitoringEvent() {
        return new MonitoringEvent();
    }

    @Bean(name = {"eventRepository", "myRepo"})
    public MonitorEventRepository monitorEventRepository(MonitorEventRepository eventRepository) {
        return eventRepository;
    }

    @Bean
    public MonitoringAspect monitoringAspect(MonitorEventRepository eventRepository) {
        return new MonitoringAspect(eventRepository);
    }
}
