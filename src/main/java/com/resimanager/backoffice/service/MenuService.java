package com.resimanager.backoffice.service;

import com.resimanager.backoffice.dto.MnuDto;
import com.resimanager.backoffice.persistance.entity.MenuItem;
import com.resimanager.backoffice.persistance.entity.MenuItemId;
import com.resimanager.backoffice.persistance.repository.MenuItemRepository;
import com.resimanager.backoffice.service.mapper.MnuToMnuDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuItemRepository menuItemRepository;

    public MenuService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MnuDto> Menus(){
        List<MenuItem> menuItems = menuItemRepository.findMenus();
        List<MnuDto> menusDto = new ArrayList<>();

        for (MenuItem menuItem : menuItems) {
            List<MnuDto> menusHijosDto = new ArrayList<>();
            MnuDto mnuDto = new MnuToMnuDtoMapper().apply(menuItem);
            List<MenuItem> menusHijos=SubMenus(menuItem.getId());
            for (MenuItem menuHijo : menusHijos) {
                MnuDto menuHijoDto =new MnuToMnuDtoMapper().apply(menuHijo);
                menuHijoDto.setSubmenus(new ArrayList<>());
                menusHijosDto.add(menuHijoDto);
            }
            mnuDto.setSubmenus(menusHijosDto);
            menusDto.add(mnuDto);
        }
        return menusDto;
    }

    public List<MenuItem> SubMenus(MenuItemId menuid){
        return menuItemRepository.findSubMenus(menuid.getMItID());
    }
}
