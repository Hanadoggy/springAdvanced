package dbwls.springAdvanced.trace.logtrace;

import dbwls.springAdvanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
