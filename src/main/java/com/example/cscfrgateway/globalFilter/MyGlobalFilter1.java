package com.example.cscfrgateway.globalFilter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
@Order(1)
public class MyGlobalFilter1 implements GlobalFilter{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("前置-进入了全局过滤器-1");
        // 在这里编写你的过滤器逻辑，例如添加请求头、验证身份等操作
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("后置-进入了全局过滤器-1");
        }));
    }
}
