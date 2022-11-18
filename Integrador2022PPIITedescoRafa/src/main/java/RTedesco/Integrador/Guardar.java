package main.java.RTedesco.Integrador;

import java.util.*;



public class Guardar {

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    public Guardar(){
        
    }

    public void guardarUsuario(Usuario usuario){
        usuarios.add(usuario);
        
    }
}
