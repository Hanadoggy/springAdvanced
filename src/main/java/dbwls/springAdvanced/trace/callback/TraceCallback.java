package dbwls.springAdvanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}
