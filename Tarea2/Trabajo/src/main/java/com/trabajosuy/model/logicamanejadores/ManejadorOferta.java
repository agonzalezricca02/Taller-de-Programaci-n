package com.trabajosuy.model.logicamanejadores;

import java.util.HashMap;
import java.util.Map;
import com.trabajosuy.model.logicaclases.Keyword;
import com.trabajosuy.model.logicaclases.OfertaLaboral;
import com.trabajosuy.model.logicaclases.TipoPublicacion;

public class ManejadorOferta {
	private Map<String, OfertaLaboral> ofertasNombre;
	private Map<String, TipoPublicacion> tiposPNombre;
	private Map<String, Keyword> keywordsNombre;
    private static ManejadorOferta instancia = null;

    // GetInstance
    public static ManejadorOferta getinstance() {
    	if (instancia == null)
    		instancia = new ManejadorOferta();
    	return instancia;
    }
    // Constructor
    private ManejadorOferta() {
    	ofertasNombre = new HashMap<String, OfertaLaboral>();
    	tiposPNombre = new HashMap<String, TipoPublicacion>();
    	keywordsNombre = new HashMap<String, Keyword>();
    }
    
    // Public Methods
    public void addOferta(OfertaLaboral oferta) {
    	ofertasNombre.put(oferta.getNombre(), oferta);;
    }
    public OfertaLaboral getOferta(String nombre) {
        return ofertasNombre.get(nombre);
    }

/*
    public OfertaLaboral[] getOfertas() {
        if (ofertasNombre.isEmpty())
            return null;
        else {
            Collection<OfertaLaboral> ofertas = ofertasNombre.values();
            Object[] o = ofertas.toArray();
            OfertaLaboral[] ofertasArray = new OfertaLaboral[o.length];
            for (int i = 0; i < o.length; i++) ofertasArray[i] = (OfertaLaboral) o[i];

            return ofertasArray;
        }
    }*/
    public OfertaLaboral[] getOfertas() {
        if (ofertasNombre.isEmpty()) {
            return new OfertaLaboral[0]; // Devuelve un arreglo vacío
        } else {
            return ofertasNombre.values().toArray(new OfertaLaboral[0]);
        }
    }
    
    
    public TipoPublicacion[] getTiposPublicacion() {
    	//if (tiposPNombre.isEmpty())
        //    return null;
        //else {            
            return tiposPNombre.values().toArray(new TipoPublicacion[0]);
        //}
    }
    
    public TipoPublicacion getTipoPublicacion(String tipoP) {
    	return tiposPNombre.get(tipoP);
    }
    
    public Keyword[] getKeywords() {
    	//if (keywordsNombre.isEmpty())
        //    return null;
        //else {            
            return keywordsNombre.values().toArray(new Keyword[0]);
        //}
    }
    
    public Keyword getKeyword(String key) {
    	return keywordsNombre.get(key);
    }
    
    public void addKeyword(Keyword key) {
    	keywordsNombre.put(key.getNombre(), key);
    }
    
    public void addTipoPubli(TipoPublicacion tipoP) {
    	tiposPNombre.put(tipoP.getNombre(), tipoP);;
    }
    
    public void reiniciarManejador(){
        ofertasNombre.clear();
        tiposPNombre.clear();
        keywordsNombre.clear();
    }
}
