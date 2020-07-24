/*
 * Realizar un algoritmo que nos permita desarrollar 
   una composición de libro.
 */
package composicion1;

/**
 *
 * @author Ana Pico Solis
 */

import java.util.*;

class Pagina{
//ATRIBUTOS DE INSTANCIA
    private String contenido;
    private int numero;
    
    //CONSTRUCTOR CON PARAMETROS
    public Pagina(String contenido, int numero){
    this.contenido=new String(contenido);
    this.numero=numero;
    }
    
    //METODOS DE INSTANCIA
    public String getContenido(){
    return this.contenido;
    }
    public void setContenido(String nuevo_contenido){
    this.contenido=nuevo_contenido;
    }
    public int getNumero(){
    return this.numero;
    }
    public void setNumero(int nuevo_numero){
    this.numero=nuevo_numero;
    }
}
    class Libro{
    //ATRIBUTOS
        private String titulo;
        private long isbn;
        private String autor;
        private int anioPublicacion;
        
        //ATRIBUTOS REPRESENTANDO LA RELACION DE COMPOSICION
        private Pagina[] paginas;
        private int numeroPaginas;
        
        //CONSTRUCTOR
        public Libro(String titulo, long isbn, String autor, int anioPublicacion){
        this.titulo=titulo;
        this.isbn=isbn;
        this.autor=autor;
        this.anioPublicacion=anioPublicacion;
        
        //RESERVAMOS ESPACIO EN MEMORIA PARA EL OBJETO "array"
        this.paginas=new Pagina[999];
        //RESERVAMOS ESPACIO EN MEMORIA PARA LAS PAGINAS
        for(int i=0; i<999;i++){
         this.paginas[i]=new Pagina("",0);
        }
        this.numeroPaginas=0;      
    }
    
        //METODOS DE INSTANCIA
        public String getTitulo(){
        return this.titulo;
        }
        public void setTitulo(String titulo){
        this.titulo=titulo;
        }
        public long getIsbn(){
        return this.isbn;
        }
        public void setIsbn(long nuevo_Isbn){
        this.isbn=nuevo_Isbn;
        }
        public String getAutor(){
        return this.autor;
        }
        public void setAutor(String nuevo_autor){
        this.autor=nuevo_autor;
        }
        public int getAnioPublicacion(){
        return this.anioPublicacion;
        }
        public void setAnioPublicacion(int nuevo_anioPublicacion){
        this.anioPublicacion=nuevo_anioPublicacion;
        }

            //MÉTODOS PARA TRABAJAR CON LA CLASE DE COMPOSICIÓN
    public int getNumeroPaginas(){
        return this.numeroPaginas;
    }
    public void AnadirPagina(Pagina nueva_Pagina){
        if(this.numeroPaginas<999){
            this.paginas[this.numeroPaginas]=nueva_Pagina;
            this.numeroPaginas++;
        }
    }
    public Pagina getPaginaNumero(int numero_Pagina){
        for(int i=0;i<this.numeroPaginas;i++){
            if(this.paginas[i].getNumero()==numero_Pagina){
                return this.paginas[i];
            }
        }
        return this.paginas[0];
         
    }
}

public class Composicion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        //DECLARACION Y DEFINICION DE OBJETOS
        Libro Controles_Instrumentos=new Libro("Arranque y apagado del motor", 1234345296,"Chevrolet",2020);
        Pagina pagina1=new Pagina("Asegurese de que todos los interruptores esten en la posicion desactivada" ,1);
        Pagina pagina2=new Pagina("Gire interruptor de arranque a la posicion ON verifique luces y combustible normal", 2);
        
        //PASAMOS AL OBJETO Libro LOS OBJETOS DEL TIPO Pagina
        Controles_Instrumentos.AnadirPagina(pagina1);
        Controles_Instrumentos.AnadirPagina(pagina2);
        System.out.print("Título: "); 
        System.out.println(Controles_Instrumentos.getTitulo());
        System.out.print("Autor: "); 
        System.out.println(Controles_Instrumentos.getAutor());
        System.out.println(Controles_Instrumentos.getIsbn()); 
        System.out.println(Controles_Instrumentos.getAnioPublicacion());
        for(int i=1;i<=Controles_Instrumentos.getNumeroPaginas();i++){
          System.out.println(Controles_Instrumentos.getPaginaNumero(i).getContenido());
        }
        
    }

}

