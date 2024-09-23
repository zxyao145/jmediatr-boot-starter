package io.github.zhaord.jmediatr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * VoidRequest 测试
 */
@ExtendWith(SpringExtension.class)
@Import(
        value = {
                Mediator.class,
                VoidRequestTest.CommandHandler.class,
        }
)
public class VoidRequestTest {

    @Autowired
    IMediator mediator;

    @Test
    public void should() {
        mediator.send(new Command());
    }

    public static class Command implements IVoidRequest {
    }

    public static class CommandHandler implements IVoidRequestHandler<Command> {
        @Override
        public void handle(Command request) {
            System.out.printf("IVoidRequestHandler");
        }
    }

}
