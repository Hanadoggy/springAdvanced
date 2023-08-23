package dbwls.springAdvanced;

import dbwls.springAdvanced.trace.logtrace.FieldLogTrace;
import dbwls.springAdvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
