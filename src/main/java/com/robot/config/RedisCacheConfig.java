package com.robot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.timeout}")
    private int timeout;

    @Bean
    public RedisConnectionFactory factory() {
        //使用默认地址和端口
        RedisConnectionFactory factory = new JedisConnectionFactory();
        return factory;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间
        cacheManager.setDefaultExpiration(300);
//        Map<String,Long> expiresMap=new HashMap<>();
//        expiresMap.put("info",300L);
//        cacheManager.setExpires(expiresMap);
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        //使用 StringRedisSerializer 来序列化，JdkSerializationRedisSerializer or jackson2JsonRedisSerializer
        StringRedisTemplate template = new StringRedisTemplate(factory);
        return template;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method,
                                   Object... params) {
                //规定  本类名+方法名+参数名 为key
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName()+"_");
                sb.append(method.getName()+"_");
                for (Object obj : params) {
                    sb.append(obj.toString()+",");
                }
                return sb.toString();
            }
        };
    }
}
