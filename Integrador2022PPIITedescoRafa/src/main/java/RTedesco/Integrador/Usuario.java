package main.java.RTedesco.Integrador;
import java.time.LocalDate;
import java.util.*;

public class Usuario {

    private String usuario;
    private String nombre;
    private String email;
    private Correo correo;
    private Correo correoBorrador;
    private Bandeja bandeja = new Bandeja();

    ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    
    
    public Usuario(String usuario, String nombre, String email) {
        setUsuario(usuario);
        setNombre(nombre);
        setEmail(email);
    }
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bandeja getBuzon() {
        return bandeja;
    }

    public void crearContacto(String nombre, String email) {
        Contacto contacto = new Contacto(nombre, email);
        contactos.add(contacto);
    }


    public void crearCorreo(String contenido, String asunto, Contacto destinatario, LocalDate fecha) {
       
        correo = new Correo(contenido, asunto,new Contacto(this.getNombre(), this.getEmail()), destinatario, fecha);
        this.setCorreoBorrador(correo);

    }

    public void setCorreoBorrador(Correo correo){
        this.correoBorrador = correo;
    }

    public Correo getCorreoBorrador(){
        return correoBorrador;
    }

    private Bandeja getBandeja() {
        return null;
    }

    public void enviarCorreo(Correo correo, Guardar guardar){
        bandeja.agregarCorreoEnviado(correo);
        for (Contacto destinatario : correo.getPara()){
            guardar.usuarios.stream().filter(u -> u.getEmail().equals(destinatario.getEmail())).findFirst().get().getBandeja().agregarCorreo(correo);
            
        }
    }


    public void crearCorreo(String string, String string2, ArrayList<Contacto> contactos2, LocalDate fecha) {
    }


    public void agendarUsuario(Usuario usuario2) {
    }


    public void crearCorreo(String string, String string2, Contacto contacto) {
    }

   
}
