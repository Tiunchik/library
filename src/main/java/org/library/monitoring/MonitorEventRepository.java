package org.library.monitoring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface MonitorEventRepository extends JpaRepository<MonitoringEvent, Long> {
}
