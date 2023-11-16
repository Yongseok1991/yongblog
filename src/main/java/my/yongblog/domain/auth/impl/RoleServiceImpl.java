package my.yongblog.domain.auth.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.yongblog.domain.auth.Role;
import my.yongblog.domain.auth.RoleRepository;
import my.yongblog.domain.auth.RoleService;
import my.yongblog.domain.auth.RoleType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public List<Role> userRoles(List<RoleType> roleTypes) {
        return roleRepository.findAllByRoleTypeIn(roleTypes);
    }
}
