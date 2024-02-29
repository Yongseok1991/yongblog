package my.yongblog.domain.menu.impl;

import lombok.RequiredArgsConstructor;
import my.yongblog.domain.menu.Menu;
import my.yongblog.domain.menu.MenuRepository;
import my.yongblog.domain.menu.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    @Override
    @Transactional
    public Long save(Menu menu) {
        return menuRepository.save(menu).getId();
    }
}
