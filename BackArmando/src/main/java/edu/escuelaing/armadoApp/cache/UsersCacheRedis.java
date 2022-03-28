package edu.escuelaing.armadoApp.cache;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
public class UsersCacheRedis implements ICacheRedis{
    private HashOperations<String,String,Long> hashOperations;
    public static final String Key = "edu:escuelaing:armadoApp:User";
    private RedisTemplate redisTemplate;
    public UsersCacheRedis(RedisTemplate redisTemplate){
        this.redisTemplate= redisTemplate;
        this.hashOperations=this.redisTemplate.opsForHash();
    }

    @Override
    public void incrementUsers(String idSala) {

        Long valor = hashOperations.get(Key,idSala);

        if(valor==null){
            hashOperations.put(Key,idSala,0L);

        }else{
            hashOperations.put(Key,idSala,valor+1L);
        }
    }
}
