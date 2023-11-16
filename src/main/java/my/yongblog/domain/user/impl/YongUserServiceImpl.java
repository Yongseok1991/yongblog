package my.yongblog.domain.user.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.yongblog.domain.auth.Role;
import my.yongblog.domain.auth.RoleService;
import my.yongblog.domain.user.Yong;
import my.yongblog.domain.user.YongRepository;
import my.yongblog.domain.user.YongSaveRequest;
import my.yongblog.domain.user.YongUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class YongUserServiceImpl implements YongUserService {
    private final RoleService roleService;
    private final YongRepository yongRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Long join(YongSaveRequest dto) {
        List<Role> roles = new ArrayList<>(roleService.userRoles(dto.getRoleType()));
        if (roles.isEmpty()) {
            throw new IllegalArgumentException("there is no role type");
        }
        Yong user = Yong.yongSaveAndUpdateBuilder()
                .email(dto.getEmail())
                .name(dto.getName())
                .roles(roles)
                .nickname(dto.getNickname())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
        Yong save = yongRepository.save(user);
        return save.getId();
    }
}
