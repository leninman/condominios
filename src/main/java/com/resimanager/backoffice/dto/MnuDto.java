package com.resimanager.backoffice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MnuDto {

    private Integer id;
    private String nombre;
    private String tipo;
    private String estado;
    private Integer idAccion;
    private String accion;
    private Integer idOpcion;
    private String opcion;
    private Integer idModulo;
    private String modulo;
    private String controlador;
    private String metodo;
    private List<MnuDto> submenus;

}
