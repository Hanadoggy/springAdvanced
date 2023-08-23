package dbwls.springAdvanced.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {

    private String id;
    private int level;

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    // UUID는 그냥 사용하기에는 너무 길기 때문에 앞의 8자리만 잘라내어 사용

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }
    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }
    // id는 동일하게 재사용하면서 메서드 호출 스택의 깊이를 따라갈 때 사용

    public boolean isFirstLevel() {
        return level == 0;
    }
}
