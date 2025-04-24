package com.trabajosuy.controllers;

import java.util.Map;

import com.trabajosuy.model.logicacontroladores.Fabrica;
import com.trabajosuy.model.logicacontroladores.IControladorAdmin;

import java.util.HashMap;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class cargaDatos implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	Fabrica fab = Fabrica.getInstance();
    	IControladorAdmin cA = fab.getIControladorAdmin();
    	cA.cargarDatosDePrueba();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}