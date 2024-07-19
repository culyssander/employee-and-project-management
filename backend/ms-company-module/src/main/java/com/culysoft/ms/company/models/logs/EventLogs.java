package com.culysoft.ms.company.models.logs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventLogs {
    private String event;
    private String message;

    private Map<String, Object> fields;

    public EventLogs addField(String key, Object value) {
        if (fields == null) {
            fields = new HashMap<>();
        }
        fields.put(key, value);
        return this;
    }

    public static final LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER =
            new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-mm-dd'T'HH:mm:ss.SSSS'Z'"));

    @Override
    public String toString() {

        var sb = new StringBuilder("EventLogs(");

        try {
            var mapper = new ObjectMapper();

            var module = new JavaTimeModule();
            module.addSerializer(LOCAL_DATETIME_SERIALIZER);

            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                    .registerModule(module)
                    .writerWithDefaultPrettyPrinter();

            sb.append(mapper.writeValueAsString(this));
        } catch (JsonProcessingException e) {
            log.error("Error converting object to json", e);
        }

        return sb.append(")").toString();
    }

    public void printLog(Logger log) {
        printLog(log, LoggerType.INFO);
    }

    public void printLog(Logger log, LoggerType logType) {
        printLog(log, logType, null);
    }

    public void printLog(Logger log, LoggerType logType, Throwable exception) {

        var msg = this.toString() == null ? "" : this.toString();

        switch (logType) {
            case DEBUG:
                log.debug(msg, exception);
                break;
            case ERROR:
                log.error(msg, exception);
                break;
            case WARN:
                log.warn(msg, exception);
                break;
            default:
                log.info(msg, exception);
        }
    }

    public enum LoggerType {
        INFO, DEBUG, ERROR, WARN
    }

}


