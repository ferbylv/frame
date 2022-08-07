package top.ferbylv.monkeyblogjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Configuration
public class RedisListenerConfig {
 

 
    /**
     * 处理乱码
     * @return
     */
    @Bean
    public RedisTemplate redisTemplateInit(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate redisTemplate = new RedisTemplate();
 
        // key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
 
        //val实例化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());


        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
 
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }
 
}
