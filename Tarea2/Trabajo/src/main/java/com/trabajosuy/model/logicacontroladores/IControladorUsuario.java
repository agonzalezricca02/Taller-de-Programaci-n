package com.trabajosuy.model.logicacontroladores;

import com.trabajosuy.model.excepciones.UsuarioNoExisteException;
import com.trabajosuy.model.excepciones.UsuarioRepetidoException;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTUsuario;

/**
 * @author TProg2017
 *
 */
public interface IControladorUsuario {
    

    public abstract DTUsuario[] getUsuarios() throws UsuarioNoExisteException;
    public abstract DTUsuario getUsuario(String nickname) throws UsuarioNoExisteException;

    public abstract DTEmpresa[] listarEmpresas()  throws UsuarioNoExisteException;

	public abstract DTPostulante[] listarPostulantes() throws UsuarioNoExisteException;

	public abstract void altaUsuario(DTUsuario usr) throws UsuarioRepetidoException;

	public abstract void modificarUsuario(DTUsuario usr);

}
