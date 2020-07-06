package org.library.monitoring;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Component
@Entity(name = "METRIKS")
public class MonitoringEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long value;

    private String parameters;

    @Column(nullable = false)
    private Timestamp event_timestamp;

    public MonitoringEvent() {
    }

    public MonitoringEvent(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Timestamp getEvent_timestamp() {
        return event_timestamp;
    }

    public void setEvent_timestamp(Timestamp event_timestamp) {
        this.event_timestamp = event_timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MonitoringEvent that = (MonitoringEvent) o;
        return id == that.id
                && value == that.value
                && name.equals(that.name)
                && parameters.equals(that.parameters)
                && event_timestamp.equals(that.event_timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, parameters, event_timestamp);
    }

    @Override
    public String toString() {
        return "MonitoringEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", parameters='" + parameters + '\'' +
                ", event_timestamp=" + event_timestamp +
                '}';
    }
}
