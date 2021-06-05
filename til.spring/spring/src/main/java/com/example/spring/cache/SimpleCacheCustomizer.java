package com.example.spring.cache;

import java.util.Arrays;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

/*
- spring boot에서는 캐시 스타터와 @EnableCaching사용 시, 별도의 빈 설정없이
ConcurrentMapCacheManager가 빈으로 등록됨
- CacheManagerCustomizer를 이용해 자동설정된 CacheManager를 커스텀 할 수 있음
 */
@Component
public class SimpleCacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

  @Override
  public void customize(ConcurrentMapCacheManager cacheManager) {
    cacheManager.setCacheNames(Arrays.asList("users", "transactions"));
  }
}
