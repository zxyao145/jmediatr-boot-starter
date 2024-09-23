package io.github.zhaord.jmediatr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Multiple Inheritance 测试
 */
@ExtendWith(SpringExtension.class)
@Import(
        value = {
                Mediator.class,
                MultipleInheritRequestTest.PingHandler.class,
        }
)
public class MultipleInheritRequestTest {

    @Autowired
    IMediator mediator;

    public interface IRequest1<TResponse> extends IRequest<TResponse> {
    }
    public interface IRequest2<TResponse> extends IRequest1<TResponse> {
    }
    public interface IRequest3<TResponse> extends IRequest2<TResponse> {
    }

    public static class Ping implements IRequest3<String> {
    }


    public interface RequestHandler<TRequest extends IRequest3<TResponse>, TResponse> extends IRequestHandler<TRequest, TResponse> {

    }

    public static class PingHandler implements RequestHandler<Ping, String> {

        @Override
        public String handle(Ping request) {
            return "";
        }
    }


    @Test
    public void should() {
        mediator.send(new Ping());
    }
}
