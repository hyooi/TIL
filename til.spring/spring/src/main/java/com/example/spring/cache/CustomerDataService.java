package com.example.spring.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

//@CacheConfig(cacheNames = {"addresses"}) //클래스에 캐시 설정 가능
@Component
public class CustomerDataService {

  /*
  - getAddress호출 시 캐시를 먼저 확인함,
  - {"addresses", "directory"}와 같이 여러 캐시도 지원
  - 캐시에 필요한 결과가 있는 경우 실제 메소드는 호출하지 않고 결과를 반환함
   */
  @Cacheable("addresses")
  public String getAddress(Customer customer) {
    System.out.println("getAddress. name: " + customer.getName() + ", address: "+customer.getAddress());
    return customer.getAddress();
  }

  // 캐시가 거대해지는 경우, 오래되거나 미사용 데이터를 다시 로드하기 위해 사용
  // cache의 모든 데이터를 지우고 신규 데이터 준비
  // 큰 캐시에서 데이터를 찾는 오버헤드를 줄임
  @CacheEvict(value = "addresses", allEntries = true)
  public String getAddress2(Customer customer) {
    System.out.println("getAddress2. name: " + customer.getName() + ", address: "+customer.getAddress());
    return customer.getAddress();
  }

  /*
  - 캐시 외의 많은 데이터가 삭제되는 것을 피하기 위함
  - 데이터를 수정할 때마다 엔트리의 업데이트를 선택적으로 진행
  - cachable은 메소드의 실행을 스킵하고, cacheput은 실제로 메소드를 실행한 후 캐시에 결과를 입력
  - 최적화보다는 캐시 생성을 위해 사용
   */
  @CachePut(value = "addresses")
  public String getAddress3(Customer customer) {
    System.out.println("getAddress3. name: " + customer.getName() + ", address: "+customer.getAddress());
    return customer.getAddress();
  }

  /* 여러개 주석 사용 방법 */
  @Caching(evict = {
      @CacheEvict("addresses"),
      @CacheEvict(value = "directory", key = "#customer.name")
  })
  public String getAddress4(Customer customer) {
    System.out.println("getAddress4. name: " + customer.getName() + ", address: "+customer.getAddress());
    return customer.getAddress();
  }

  // condition에 따라 결과가 캐시됨
  @Cacheable(value = "addresses", condition = "#customer.name=='Tom'")
  public String getAddress5(Customer customer) {
    System.out.println("getAddress5. name: " + customer.getName() + ", address: "+customer.getAddress());
    return customer.getAddress();
  }

  // result가 64미만이 아닌경우에만 캐싱함
  @Cacheable(value = "addresses", unless = "#result.length()<10")
  public String getAddress6(Customer customer) {
    System.out.println("getAddress6. name: " + customer.getName() + ", address: "+customer.getAddress());
    return customer.getAddress();
  }

}
