package com.ejb;

import javax.ejb.Stateless;

/**
 * Created by gao on 16-3-27.
 */
@Stateless(name = "HelloWorldEJB")
public class HelloWorldBean implements HelloWorld {
    public HelloWorldBean() {
    }

    @Override
    public String sayHello(String world) {
        return "Hello " + world + "!";
    }
}
