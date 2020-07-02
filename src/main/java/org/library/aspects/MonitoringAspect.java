package org.library.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.chess.library.annotations.Monitoring;
import org.chess.library.domains.MonitoringEvent;
import org.chess.library.repositories.MonitorEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Timestamp;

@Aspect
@Component
public class MonitoringAspect {

    private final MonitorEventRepository evRep;

    public MonitoringAspect(@Autowired MonitorEventRepository evRep) {
        this.evRep = evRep;
    }

    @Around("@annotation(org.chess.library.annotations.Monitoring)")
    public Object doLogging(ProceedingJoinPoint jP) {
        MethodSignature signature = (MethodSignature) jP.getSignature();
        Method method = signature.getMethod();
        String annoName = method
                .getAnnotation(Monitoring.class)
                .name();
        StringBuilder parameters = new StringBuilder();
        for (var par : jP.getArgs()) {
            parameters.append(par.toString()).append(", ");
        }
        MonitoringEvent start = startEvent(annoName,
                parameters.length() > 254 ? parameters.toString().substring(0, 254) : parameters.toString());
        Object answ = null;
        try {
            answ = jP.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        MonitoringEvent finish = finishEvent(annoName, start.getParameters());
        durationEvent(start, finish);
        return answ;
    }

    private MonitoringEvent startEvent(String name, String parameters) {
        MonitoringEvent start = new MonitoringEvent();
        start.setEvent_timestamp(new Timestamp(System.currentTimeMillis()));
        start.setName(name + "_START");
        start.setValue(1L);
        start.setParameters(parameters);
        return evRep.save(start);
    }

    private MonitoringEvent finishEvent(String name, String parameters) {
        MonitoringEvent finish = new MonitoringEvent();
        finish.setEvent_timestamp(new Timestamp(System.currentTimeMillis()));
        finish.setName(name + "_FINISH");
        finish.setValue(1L);
        finish.setParameters(parameters);
        return evRep.save(finish);
    }

    private MonitoringEvent durationEvent(MonitoringEvent start, MonitoringEvent finish) {
        MonitoringEvent duration = new MonitoringEvent();
        duration.setEvent_timestamp(finish.getEvent_timestamp());
        duration.setName(start.getName() + "_FINISH");
        duration.setValue(finish.getEvent_timestamp().getTime()
                - start.getEvent_timestamp().getTime());
        duration.setParameters(start.getParameters());
        return evRep.save(duration);
    }

}
