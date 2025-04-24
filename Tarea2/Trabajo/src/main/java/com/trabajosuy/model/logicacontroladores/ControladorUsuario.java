package com.trabajosuy.model.logicacontroladores;

import com.trabajosuy.model.excepciones.UsuarioNoExisteException;
import com.trabajosuy.model.excepciones.UsuarioRepetidoException;
import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.Usuario;
import com.trabajosuy.model.logicadatatype.DTEmpresa;
import com.trabajosuy.model.logicadatatype.DTPostulante;
import com.trabajosuy.model.logicadatatype.DTUsuario;
import com.trabajosuy.model.logicamanejadores.ManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario {

    public ControladorUsuario() {
    }

    public DTUsuario[] getUsuarios() throws UsuarioNoExisteException {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        Usuario[] usrs = manejadorUsr.getUsuarios();

        if (usrs != null) {
            DTUsuario[] datausr = new DTUsuario[usrs.length];
            Usuario usuario;

            for (int i = 0; i < usrs.length; i++) {
                usuario = usrs[i];
                datausr[i] = usuario.getDT();
            }

            return datausr;
        } else {
            throw new UsuarioNoExisteException("No existen usuarios registrados");
        }
    }

    public DTUsuario getUsuario(String nickname) throws UsuarioNoExisteException {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        Usuario usr = manejadorUsr.getUsuario(nickname);

        if (usr != null) {
            return usr.getDT();
        } else {
            throw new UsuarioNoExisteException("No existen usuarios registrados");
        }
    }

    public DTEmpresa[] listarEmpresas() throws UsuarioNoExisteException {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        Empresa[] emp = manejadorUsr.getEmpresas();

        if (emp == null) {
            throw new UsuarioNoExisteException("No existen empresas");
        } else {
            DTEmpresa[] dtemp = new DTEmpresa[emp.length];

            for (int i = 0; i < emp.length; i++) {
                dtemp[i] = emp[i].getDT();
            }

            return dtemp;
        }
    }

    public DTPostulante[] listarPostulantes() throws UsuarioNoExisteException {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        Postulante[] emp = manejadorUsr.getPostulantes();

        if (emp == null) {
            throw new UsuarioNoExisteException("No existen postulantes");
        } else {
            DTPostulante[] dtemp = new DTPostulante[emp.length];

            for (int i = 0; i < emp.length; i++) {
                dtemp[i] = emp[i].getDT();
            }

            return dtemp;
        }
    }

    public void altaUsuario(DTUsuario usr) throws UsuarioRepetidoException {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        Usuario user = manejadorUsr.getUsuario(usr.getNickname());
        
        if (user != null) {
            throw new UsuarioRepetidoException("El usuario " + usr.getNickname() + " ya está registrado");
        } else {
            user = manejadorUsr.getUsuarioEmai(usr.getEmail().toLowerCase());
            if (user != null) {
                throw new UsuarioRepetidoException("El E-mail " + usr.getEmail() + " ya está registrado");
            }
        }
        
        if (usr instanceof DTEmpresa) {
            DTEmpresa empresa = (DTEmpresa) usr;
            Empresa empr = new Empresa(empresa.getNickname(), empresa.getNombre(), empresa.getApellido(),
                    empresa.getEmail(), empresa.getContrasena(), empresa.getImagen(), empresa.getDescripcion(),
                    empresa.getSitioWeb());
            manejadorUsr.addUsuario(empr);
        } else if (usr instanceof DTPostulante) {
            DTPostulante postulante = (DTPostulante) usr;
            Postulante empl = new Postulante(postulante.getNickname(), postulante.getNombre(),
                    postulante.getApellido(), postulante.getEmail(), postulante.getContrasena(), postulante.getImagen(),
                    postulante.getFechaNacimiento(), postulante.getNacionalidad());
            manejadorUsr.addUsuario(empl);
        }
    }

    public void modificarUsuario(DTUsuario usr) {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        Usuario user = manejadorUsr.getUsuario(usr.getNickname());

        user.setNombre(usr.getNombre());
        user.setApellido(usr.getApellido());
        user.setImagen(usr.getImagen());

        if (usr instanceof DTEmpresa) {
            DTEmpresa empresa = (DTEmpresa) usr;
            Empresa empr = (Empresa) user;
            empr.setDescripcion(empresa.getDescripcion());
            empr.setSitioWeb(empresa.getSitioWeb());
        } else if (usr instanceof DTPostulante) {
            DTPostulante postulante = (DTPostulante) usr;
            Postulante post = (Postulante) user;
            post.setFechaNacimiento(postulante.getFechaNacimiento());
            post.setNacionalidad(postulante.getNacionalidad());
        }
    }

    public void linkearEmpresaPublicacion(String empresa, String oferta) {
        ManejadorUsuario manejadorUsr = ManejadorUsuario.getinstance();
        ((Empresa) manejadorUsr.getEmpresa(empresa)).addPublicacionOferta(oferta);
    }
}
