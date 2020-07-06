package org.library;

import org.library.monitoring.MonitoringAspect;
import org.library.monitoring.MonitoringEvent;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {MonitoringEvent.class})
@EnableJpaRepositories(basePackageClasses = org.library.monitoring.MonitorEventRepository.class)
@ComponentScan(basePackageClasses = {MonitoringAspect.class})
public class Config {

}
