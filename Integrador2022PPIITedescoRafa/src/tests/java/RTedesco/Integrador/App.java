package tests.java.RTedesco.Integrador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.junit.Test;
import main.java.RTedesco.Integrador.Bandeja;
import main.java.RTedesco.Integrador.Contacto;
import main.java.RTedesco.Integrador.Correo;
import main.java.RTedesco.Integrador.Guardar;
import main.java.RTedesco.Integrador.Usuario;
import main.java.RTedesco.Integrador.InterfaceBandejaAccionesCorreos;
import main.java.RTedesco.Integrador.InterfaceFiltrosCorreos;
import main.java.RTedesco.Integrador.InterfaceFiltrosDeBusquedas;


public class App {

    @Test
    public void seDebeCrearUsuario(){
        Usuario usuario1 = new Usuario("RTedesco98", "Rafael", "rtedescosistemas@gmail.com" );
        assertEquals("RTedesco98", usuario1.getUsuario());
        assertEquals("Rafael", usuario1.getNombre());
        assertEquals("rtedescosistemas@gmail.com", usuario1.getEmail());
    }

    @Test
    public void seDebeAgendarContacto(){

        Usuario usuario1 = new Usuario("RTedesco98", "Rafael", "rtedescosistemas@gmail.com");
        usuario1.crearContacto("Rafael", "rtedescosistemas@gmail.com");
        assertEquals("Rafael", usuario1.getContactos().get(0).getNombre());
        assertEquals("rtedescosistemas@gmail.com", usuario1.getContactos().get(0).getEmail());

    }
    /**
     * @param usuario 
     * 
     */
    @Test
    public void seDebeCrearCorreo(){
      
        Usuario usuario1 = new Usuario("RTedesco98", "Rafael", "rtedescosistemas@gmail.com");
        usuario1.crearContacto("AdministracionUCP", "administracionUCP@gmail.com");
        usuario1.crearCorreo("Buenos días... adjunto pago de preinscripción de materias a cursar", "Preinscripciones de materias", usuario1.getContactos().get(0));
        assertEquals("Buenos días... adjunto pago de preinscripción de materias a cursar", usuario1.getCorreoBorrador().getContenido());
        assertEquals("Preinscripciones de materias", usuario1.getCorreoBorrador().getAsunto());
        assertEquals("AdministracionUCP", usuario1.getCorreoBorrador().getNombre());
        assertEquals("Rafael", usuario1.getCorreoBorrador().getRemitente().getNombre());
    
    }

    @Test
    public void seDebeEnviarElCorreo(){

        Usuario usuario1 = new Usuario("RTedesco98", "Rafael", "rtedescosistemas@gmail.com");
        Usuario usuario2 = new Usuario("LM1987", "Lio", "messiteamo@gmail.com");

        usuario1.agendarUsuario(usuario1);
        usuario2.agendarUsuario(usuario2);

        /*
        usuario.crearContacto();
        usuario.crearCorreo(); 
        
         */

        assertEquals(usuario1, usuario1);
        assertEquals(usuario2, usuario2);

    }

    @Test
    public void seDebeFiltrarPorAsunto(){

        Guardar guardarAsuntito = new Guardar();
        Usuario usuario1 = new Usuario("RTedesco98", "Rafael", "rtedescosistemas@gmail.com");
        Usuario usuario2 = new Usuario("JulianBury2", "Julian", "julianbury14@gmail.com");

        guardarAsuntito.guardarUsuario(usuario1);
        guardarAsuntito.guardarUsuario(usuario2);

        usuario1.crearContacto(usuario1.getNombre(), usuario1.getEmail());
        usuario1.crearCorreo("Anulo Mufa 27", "Scaloneta", usuario1.getContactos().get(0));
        usuario1.crearContacto(usuario2.getNombre(), usuario2.getEmail());
        usuario1.getCorreoBorrador().agregarDestinatario(usuario1.getContactos().get(1));
        usuario1.enviarCorreo(usuario1.getCorreoBorrador(), guardarAsuntito);

        Bandeja bandeja = usuario2.getBuzon();

        Predicate<Correo> filtro1 = bandeja.crearFiltroAsunto("Scaloneta");
        assertEquals("Scaloneta", bandeja.buscar(filtro1).getAsunto());

    }
    
    /*@Test
    public void seDebeFiltrarPorCorreo(){
        Usuario usuario1 = new Usuario("RTedesco98", "Rafael", "rtedescosistemas@gmail.com");
        Usuario usuario2 = new Usuario("JulianBury2", "Julian", "julianbury14@gmail.com");
        Usuario usuario3 = new Usuario("LM1987", "Lio", "messiteamo@gmail.com");
       
        usuario1.enviarCorreo(usuario1.getCorreoBorrador());

    }*/

    @Test
    public void seDebeFiltrarPorContenido(){

        Guardar guardarAsuntito = new Guardar();

        Usuario usuario1 = new Usuario("RTedesco98", "Rafael", "rtedescosistemas@gmail.com");
        Usuario usuario2 = new Usuario("JulianBury2", "Julian", "julianbury14@gmail.com");
        Usuario usuario3 = new Usuario("LM1987", "Lio", "messiteamo@gmail.com");

        usuario1.crearContacto(usuario2.getNombre(), usuario2.getEmail());
        usuario1.crearCorreo("Anulo Mufa 27", "LM1987", usuario2.getContactos().get(0));
        usuario1.enviarCorreo(usuario2.getCorreoBorrador(), guardarAsuntito);

        Bandeja bandeja = usuario2.getBuzon();
        Predicate<Correo> filtro1 = bandeja.seFiltraPorContenido("Anulo mufa");

        assertEquals("Anulo Mufa 27", bandeja.buscar(filtro1).getContenido());

    }


   /*  @Test
    public void seDebeFiltrarPorContenidoYAsunto(){


    }
    
    */
}


