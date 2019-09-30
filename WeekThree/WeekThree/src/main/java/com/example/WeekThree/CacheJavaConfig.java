package com.example.WeekThree;


import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheJavaConfig {
    @Bean
    public CacheManager cacheManager(){
        String specAsString = "initialCapacity=100,maximumSize=500,expireAfterAccess=60s"; //cache config, expire after 60 second
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("FIRST_CACHE", "SECOND_CACHE");
        cacheManager.setAllowNullValues(false);
        cacheManager.setCacheSpecification(specAsString);  //this function uses the string specAsString to cache, there it is specified 60 second
//        cacheManager.setCaffeineSpec(caffeineSpec());
//        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

//    CaffeineSpec caffeineSpec(){
//        return CaffeineSpec.parse(
//                "initialCapacity=100,maximumSize=500,expireAfterAccess=60s,recordStats"
//        );
//    }
//
//    Caffeine<Object, Object> caffeineCacheBuilder(){
//        return Caffeine.newBuilder()
//                .initialCapacity(100)
//                .maximumSize(150)
//                .expireAfterAccess(60, TimeUnit.SECONDS)
//                .weakKeys()
//                .removalListener(new CustomRemoveListener())
//                .recordStats();
//    }
//
//    class CustomRemoveListener implements RemovalListener<Object, Object>{
//        @Override
//        public void onRemoval(Object key, Object value, RemovalCause cause){
//            System.out.println("removal listener called with key [%S], cause [%S], evicted [%S]\n",
//                    key, cause.toString(), cause.wasEvicted());
//        }
//    }

}
