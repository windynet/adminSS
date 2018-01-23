package site.fish119.adminss.repository;

import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import site.fish119.adminss.domain.sys.User;

@RepositoryRestResource
@Api
public interface SysUserRepository extends PagingAndSortingRepository<User, Long> {
    //    @Cacheable(cacheNames = "sysUsers", key = "#p0")
    User findByUsername(@Param("username") final String username);

    @Override
    User findOne(Long id);

    Page<User> findByUsernameIgnoreCaseContainingOrNicknameIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContaining(String username, String nickname, String phone, String email, Pageable pageable);

    @Override
//    @Caching(
//            evict = {@CacheEvict(cacheNames = "sysUsers", key = "#root.caches[0].get('useridAndName:'+#p0.id).get().username",beforeInvocation = true,condition ="#root.caches[0].get('useridAndName:'+#p0.id) != null" )},
//            put = {
//                    @CachePut(cacheNames = "sysUsers", key = "'useridAndName:'+#result.id", condition = "#result!=null"),
//                    @CachePut(cacheNames = "sysUsers", key = "#result.username", condition = "#result!=null")
//            }
//    )
    User save(User user);
}
