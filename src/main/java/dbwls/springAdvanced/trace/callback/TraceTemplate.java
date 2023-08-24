package dbwls.springAdvanced.trace.callback;

import dbwls.springAdvanced.trace.TraceStatus;
import dbwls.springAdvanced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {

        TraceStatus status = null;

        try {
            status = trace.begin(message);

            // logic start
            T result = callback.call();

            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
