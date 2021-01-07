package org.fighter;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.concurrent.atomic.AtomicInteger;

public class TestApp {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("39.98.130.209", 6379, 100000);
        jedis.auth("123456");
        jedis.set("k1", "hello");
        jedis.set("k2", "world");
        System.out.println(jedis.get("k1") + jedis.get("k2"));
        System.out.println("连接成功");
        System.out.println(jedis.ping());
        Transaction multi = jedis.multi();
        try {
            multi.set("user3", "zSan");
            multi.set("user4", String.valueOf(1 / 0));
            multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            multi.discard();

        }
        System.out.println(jedis.get("user3"));
        System.out.println(jedis.get("user4"));
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.getAndDecrement();
    }


}
