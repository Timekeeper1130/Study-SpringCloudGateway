package com.example.cscfrgateway.filter.fr;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(3)
public class FrFilter extends AbstractGatewayFilterFactory<FrFilter.Config> {

    public FrFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("real address:" +
                    exchange.getRequest().getHeaders().getFirst("X-Real-IP"));
            doPre(exchange, config);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                doPost(exchange, config);
            }));
        };
    }

    private void doPre(ServerWebExchange exchange, Config config) {
        // pre
        if (config.isPreLogger()) {
            System.out.println("Pre GatewayFilter logging: "
                    + config.getBaseMessage());
        }
        System.out.println("前置-帆软局部过滤器");
        System.out.println(exchange.getRequest().getURI());
    }

    private void doPost(ServerWebExchange exchange, Config config) {
        // post
        if (config.isPostLogger()) {
            System.out.println("Post GatewayFilter logging: "
                    + config.getBaseMessage());
        }
        System.out.println("后置-帆软局部过滤器");
    }

    public static class Config {
        // 可以添加一些配置项
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;

        public String getBaseMessage() {
            return baseMessage;
        }

        public void setBaseMessage(String baseMessage) {
            this.baseMessage = baseMessage;
        }

        public boolean isPreLogger() {
            return preLogger;
        }

        public void setPreLogger(boolean preLogger) {
            this.preLogger = preLogger;
        }

        public boolean isPostLogger() {
            return postLogger;
        }

        public void setPostLogger(boolean postLogger) {
            this.postLogger = postLogger;
        }
    }
}
