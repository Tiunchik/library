package org.library;

import org.library.monitoring.MonitorEventRepository;
import org.library.monitoring.MonitoringAspect;
import org.library.monitoring.MonitoringEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {MonitoringEvent.class})
@EnableJpaRepositories(basePackageClasses = org.library.monitoring.MonitorEventRepository.class)
@ComponentScan(basePackageClasses = {MonitoringAspect.class})
public class Config {

}
