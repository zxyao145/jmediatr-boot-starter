package io.github.zhaord.jmediatr;

/**
 * 单播消息处理接口
 * @author rende
 * @param <TRequest> {@link IRequest}
 */
public interface IVoidRequestHandler<TRequest extends IVoidRequest> {
    /**
     * 处理
     * @param request 单播消息
     * @return 处理结果
     */
    void handle(TRequest request);
}
