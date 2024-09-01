package com.resimanager.backoffice.service.mapper;

import com.resimanager.backoffice.dto.MnuDto;
import com.resimanager.backoffice.persistance.entity.MenuItem;
import com.resimanager.backoffice.service.MenuService;

import java.util.function.Function;

public class MnuToMnuDtoMapper implements Function<MenuItem, MnuDto> {

    @Override
    public MnuDto apply(MenuItem menuItem) {
        MnuDto mnuDto = new MnuDto();
        mnuDto.setId(menuItem.getId().getMItID());
        mnuDto.setNombre(menuItem.getMItNombre());
        mnuDto.setTipo(menuItem.getMItTipo());
        mnuDto.setEstado(menuItem.getMItSts());
        mnuDto.setControlador(menuItem.getMItControlador());
        mnuDto.setMetodo(menuItem.getMItMetodo());
        if (menuItem.getModulo() == null) {
            mnuDto.setModulo(menuItem.getMItNombre());
            if (menuItem.getMItNombre().equals("Super Admin")) {
                mnuDto.setIdModulo(1);
            }
            if (menuItem.getMItNombre().equals("Administradora")) {
                mnuDto.setIdModulo(2);

            }
            if (menuItem.getMItNombre().equals("Conjunto")) {
                mnuDto.setIdModulo(3);

            }
            if (menuItem.getMItNombre().equals("Propietario")) {
                mnuDto.setIdModulo(4);

            }
        } else {
            mnuDto.setIdModulo(menuItem.getModulo().getModId());
            mnuDto.setModulo(menuItem.getModulo().getModNombre());
            mnuDto.setIdAccion(menuItem.getAccion().getId());
            mnuDto.setAccion(menuItem.getAccion().getAccNombre());
            mnuDto.setIdOpcion(menuItem.getOpcion().getId().getOpcID());
            mnuDto.setOpcion(menuItem.getOpcion().getOpcNombre());
        }


        return mnuDto;
    }
}
