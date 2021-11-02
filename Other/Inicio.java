public class Inicio {
    public static void main(String[] args) {
        Lienzo l = new Lienzo();
        Thread hilo = new Thread(l);
        hilo.start();
    }
    
}
