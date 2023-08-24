package dbwls.springAdvanced.app.v5;

import dbwls.springAdvanced.trace.callback.TraceCallback;
import dbwls.springAdvanced.trace.callback.TraceTemplate;
import dbwls.springAdvanced.trace.logtrace.LogTrace;
import dbwls.springAdvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.Callback;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
