package com.yangyang.thrift.service;

import com.yangyang.thrift.api.HelloService;
import org.apache.thrift.TException;

/**
 * Created by chenshunyang on 2016/10/30.
 */
public class HelloServiceImpl implements HelloService.Iface{
    public String hello(String name) throws TException {
        return "hello " + name;
    }

    @Override
    public String baseInfo(String name, int age) throws TException {
        return "your name:"+name+ ",age:"+age;
    }
}