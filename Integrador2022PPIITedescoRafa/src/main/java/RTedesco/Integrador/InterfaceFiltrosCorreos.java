package main.java.RTedesco.Integrador;

import java.util.function.Predicate;

public interface InterfaceFiltrosCorreos {

    public Correo buscar(Predicate<Correo> filtro);

    public Predicate<Correo> crearFiltroAsunto(String asunto);

    public Predicate<Correo> seFiltraPorContenido(String contenido);

    public Predicate<Correo> combinarFiltros(Predicate<Correo> filtro1, Predicate<Correo> filtro2);



}
