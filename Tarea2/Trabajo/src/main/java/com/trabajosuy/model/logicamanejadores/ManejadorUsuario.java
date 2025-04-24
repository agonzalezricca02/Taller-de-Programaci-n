package com.trabajosuy.model.logicamanejadores;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.trabajosuy.model.logicaclases.Empresa;
import com.trabajosuy.model.logicaclases.Postulante;
import com.trabajosuy.model.logicaclases.Usuario;

public class ManejadorUsuario {
    private Map<String, Usuario> usuariosNickname;
    private Map<String, Usuario> usuariosEmail;
    private Map<String, Postulante> postulantesNickname;
    private Map<String, Empresa> empresasNickname;
    private static ManejadorUsuario instancia = null;

    // GetInstance
    public static ManejadorUsuario getinstance() {
    	if (instancia == null)
    		instancia = new ManejadorUsuario();
    	return instancia;
    }
    // Constructor
    private ManejadorUsuario() {
    	usuariosNickname = new HashMap<String, Usuario>();
    	usuariosEmail = new HashMap<String, Usuario>();
    	postulantesNickname = new HashMap<String, Postulante>();
    	empresasNickname = new HashMap<String, Empresa>();
    }
    
    // Public Methods
    public void addUsuario(Usuario usuario) {
        usuariosNickname.put(usuario.getNickname(), usuario);
        usuariosEmail.put(usuario.getEmail(), usuario);
        if (usuario instanceof Postulante) postulantesNickname.put(usuario.getNickname(), (Postulante) usuario);
        else empresasNickname.put(usuario.getNickname(), (Empresa) usuario);
    }
    
    public void deleteUsuario(Usuario usuario) {
        usuariosNickname.remove(usuario.getNickname());
        usuariosEmail.remove(usuario.getEmail());
        if (usuario instanceof Postulante) postulantesNickname.remove(usuario.getNickname());
        else empresasNickname.remove(usuario.getNickname());
    }

    public Usuario getUsuario(String nickname) {
        return (Usuario) usuariosNickname.get(nickname);
    }
    
    public Usuario getUsuarioEmai(String email) {
        return (Usuario) usuariosEmail.get(email);
    }
    
    public Usuario getEmpresa(String nickname) {
        return (Empresa) empresasNickname.get(nickname);
    }

    public Usuario getPostulante(String nickname) {
        return (Postulante) postulantesNickname.get(nickname);
    }


    public Usuario[] getUsuarios() {
        if (usuariosNickname.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuariosNickname.values();
            Object[] objeto = usrs.toArray();
            Usuario[] usuarios = new Usuario[objeto.length];
            for (int i = 0; i < objeto.length; i++) {
                usuarios[i] = (Usuario) objeto[i];
            }

            return usuarios;
        }
    }
    public Postulante[] getPostulantes() {
    	if (postulantesNickname.isEmpty())
    		return null;
    	else {
    		Collection<Postulante> usrs = postulantesNickname.values();
    		Object[] objeto = usrs.toArray();
    		Postulante[] postulantes = new Postulante[objeto.length];
    		for (int i = 0; i < objeto.length; i++) {
    			postulantes[i] = (Postulante) objeto[i];
    		}
    		
    		return postulantes;
    	}
    }
    public Empresa[] getEmpresas() {
        if (empresasNickname.isEmpty())
            return null;
        else {
            Collection<Empresa> usrs = empresasNickname.values();
            Object[] objeto = usrs.toArray();
            Empresa[] empresas = new Empresa[objeto.length];
            for (int i = 0; i < objeto.length; i++) {
            	empresas[i] = (Empresa) objeto[i];
            }

            return empresas;
        }
    }
    public void reiniciarUsuarios() {
        usuariosNickname.clear();
        usuariosEmail.clear();
        postulantesNickname.clear();
        empresasNickname.clear();
    }
}
