package com.resimanager.backoffice.service.mapper;

import com.resimanager.backoffice.dto.MnuDto;
import com.resimanager.backoffice.persistance.entity.MenuItem;
import com.resimanager.backoffice.service.MenuService;

import java.util.function.Function;

public class MnuToMnuDtoMapper implements Function<MenuItem, MnuDto> {

    @Override
    public MnuDto apply(MenuItem menuItem) {
        MnuDto mnuDto = new MnuDto();
        mnuDto.setMenuId(menuItem.getId().getMitMenuid());
        mnuDto.setItemId(menuItem.getId().getMItID());
        mnuDto.setNombre(menuItem.getMItNombre());
        mnuDto.setTipo(menuItem.getMItTipo());
        mnuDto.setIdPadre(menuItem.getMItItemPadre());
        mnuDto.setOrden(menuItem.getMItOrden());
        mnuDto.setIdUsrCrea(menuItem.getMitUsrCrea().getId());
        mnuDto.setUsrCrea(menuItem.getMitUsrCrea().getPerUsuario());
        mnuDto.setFechaHoraCrea(menuItem.getMItFchHorCrea());
        mnuDto.setEstCrea(menuItem.getMItEstCrea());
        mnuDto.setIdUsrModifica(menuItem.getMitUsrmod().getId());
        mnuDto.setUsrModifica(menuItem.getMitUsrmod().getPerUsuario());
        mnuDto.setFechaHoraModifica(menuItem.getMItFchHorMod());
        mnuDto.setEstModifica(menuItem.getMItEstMod());
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
