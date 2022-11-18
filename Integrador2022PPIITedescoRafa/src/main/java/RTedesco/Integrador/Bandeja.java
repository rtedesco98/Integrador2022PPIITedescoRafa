package main.java.RTedesco.Integrador;
import java.time.*;
import java.util.ArrayList;
import java.util.function.Predicate;


public class Bandeja {


    public Bandeja() {
    }

    public String getBandejaString() {
        return Bandeja();
    }

    private String Bandeja() {
        return null;
    }

    private ArrayList<Correo> correos = new ArrayList<Correo>();
    private ArrayList<Correo> correosEnviados = new ArrayList<Correo>();


    public ArrayList<Correo> getCorreos() {
        return this.correos ;
    }
    
    public void agregarCorreoEnviado(Correo correo) {
        this.correosEnviados.add(correo);
    }

    public void agregaCorreo(Correo correo) {
    }

    public Predicate<Correo> crearFiltroAsunto(String string) {
        return null;
    }

   @Override
    public void agregarCorreo(Correo correo) {
        this.correos.add(correo);
    }

    @Override
    public Predicate<Correo> seFiltraPorContenido(String contenido) {
        Predicate<Correo> filtro = c -> c.getContenido().equals(contenido);
        return filtro;
    }

    public Correo buscar(Predicate<Correo> filtro1) {
        return null;
    }

    public Predicate<Correo> seDebeFiltrarPorContenido(String string) {
        return null;
    }
}
