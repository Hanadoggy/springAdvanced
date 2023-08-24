package dbwls.springAdvanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {

        long startTime = System.currentTimeMillis();

        // business logic start
//        log.info("비즈니스 로직 1 실행");
        call();
        // business logic end

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();
}
