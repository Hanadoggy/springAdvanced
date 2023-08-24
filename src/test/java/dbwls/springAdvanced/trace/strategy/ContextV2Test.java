package dbwls.springAdvanced.trace.strategy;

import dbwls.springAdvanced.trace.strategy.code.strategy.ContextV2;
import dbwls.springAdvanced.trace.strategy.code.strategy.Strategy;
import dbwls.springAdvanced.trace.strategy.code.strategy.StrategyLogic1;
import dbwls.springAdvanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * use strategy pattern
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
        // 하나의 컨텍스트에 여러 전략을 전달하며 사용
    }

    /**
     * use strategy pattern, anonymous class
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        context.execute(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
        // 하나의 컨텍스트에 여러 전략을 전달하며 사용
    }

    /**
     * use strategy pattern, lambda function
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직 1 실행"));
        context.execute(() -> log.info("비즈니스 로직 2 실행"));
        // 하나의 컨텍스트에 여러 전략을 전달하며 사용
    }
}
