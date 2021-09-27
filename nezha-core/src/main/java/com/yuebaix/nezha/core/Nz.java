package com.yuebaix.nezha.core;

import lombok.SneakyThrows;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.StandardEnvironment;

public class Nz {
    private Nz() {}

    @SneakyThrows
    public static ConfigurableApplicationContext run(Class<?> primarySource, String... args) {
        StandardEnvironment environment = new StandardEnvironment();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setEnvironment(environment);
        context.register(primarySource);
        context.refresh();
        Server server = context.getBean(Server.class);
        Svc svc = context.getBean(Svc.class);
        svc.svc();
        Ctl ctl = context.getBean(Ctl.class);
        ctl.ctl();
        for (int i = 0; i < 100; i++) {
            server.stats();
            Thread.sleep(1000L);
        }
        return context;
    }

    public static void main(String[] args) {
        run(Bootstrap.class);
    }
}
