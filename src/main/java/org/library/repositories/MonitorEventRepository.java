package org.library.repositories;

import org.library.domains.MonitoringEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorEventRepository extends JpaRepository<MonitoringEvent, Long> {
}
