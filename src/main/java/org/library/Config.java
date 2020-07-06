package org.library;

import org.library.monitoring.MonitorEventRepository;
import org.library.monitoring.Monitoring;
import org.library.monitoring.MonitoringAspect;
import org.library.monitoring.MonitoringEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {MonitoringEvent.class,
        MonitorEventRepository.class,
        MonitoringAspect.class,
        Monitoring.class})
public class Config {

}
