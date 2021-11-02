
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Lienzo extends JComponent implements Runnable{
    
    public static final int ALTO = 500;
    public static final int ANCHO = 700;
    public Vector<Pelota> vp = new Vector<>();
    public Vector<Barco> vb = new Vector<>();
    JFrame marco;
    public Target t;
    public static Player p;
    private boolean flagPelota;
    private boolean flagBarco;
    private boolean flagTarget;
    public Lienzo() {
        flagPelota = true;
        flagBarco = true;
        flagTarget = true;
        marco = new JFrame("Auxiliatura INF-200");
        marco.setSize(ANCHO+17, ALTO+63);
        marco.getContentPane().add(this);
        marco.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
        marco.addMouseMotionListener(new Raton());
        t = new Target(300, 200, 60, 80);
        marco.add(t);
        vp.add(new Pelota(50, 350, 250, 180));
        vb.add(new Barco(0, 250, 100, 50));
        marco.add(vp.lastElement());
        marco.add(vb.lastElement());
        p = new Player(100, 100, 30, 50);//30 50
        marco.add(p);
        ponerMenu();
    }
    
    int d = 70;
    int x = 0;
    int y = 0;
    int v = 5;
    int dx = 1;
    int alpha = 0;
    int k = ALTO/2;
    int h = ANCHO/2;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        g2.drawString("Puntos: "+p.getPuntos(), 240, 50);
        g2.drawString("Vidas: "+p.getVidas(), 250, 100);
        //g2.fillOval(x, y, d, d);
        //move1();//movimiento sinusoidal
        //move2();
        //move3();
    }

    private void move1() {
        int a = 50;
        int l = 200;
        x = x+dx*v;
        if (x+d>=ANCHO){
            dx = -1;
        }
        if (x <= 0){
            dx = 1;
        }
        y = ALTO/2+(int)(a*Math.sin(x*Math.PI/l));
    }
    int r = 200;
    private void move2() {
        
        alpha = (alpha+v)%360;
        x = h+(int)(r*Math.cos(alpha*2*Math.PI/360));
        y = k+(int)(r*Math.sin(alpha*2*Math.PI/360));
        System.out.println("x: "+x+"   y:"+y);
    }
    
    private void move3() {
        x = x+dx*v;
        if (x >= h+r){
            dx = -1;
        }
        if (x <= h-r){
            dx = 1;
        }
        y = k + dx*(int)(Math.sqrt(r*r-(x-h)*(x-h)));
    }
     
    @Override
    public void run() {
        for(;;){
            paintImmediately(0, 0, ANCHO, ALTO);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
            revisarColisionPelota();
        }
    }

    private void ponerMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Circulos");
        JMenu m2 = new JMenu("Otros");
        
        JMenuItem mi11 = new JMenuItem("Arriba");
        JMenuItem mi12 = new JMenuItem("Derecha");
        JMenuItem mi13 = new JMenuItem("Abajo");
        JMenuItem mi14 = new JMenuItem("Izquierda");
        
        JMenuItem mi21 = new JMenuItem("Barco");
        
        m1.add(mi11);
        m1.add(mi12);
        m1.add(mi13);
        m1.add(mi14);
        
        m2.add(mi21);
        
        mb.add(m1);
        mb.add(m2);
        
        marco.setJMenuBar(mb);
        
        mi11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vp.add(new Pelota(50, ANCHO/2, 0, 180));
                marco.add(vp.lastElement());
            }
        });
        mi12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vp.add(new Pelota(50, ANCHO, ALTO/2, 180));
                marco.add(vp.lastElement());
            }
        });
        mi13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vp.add(new Pelota(50, ANCHO/2, ALTO, 180));
                marco.add(vp.lastElement());
            }
        });
        mi14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vp.add(new Pelota(50, 0, ALTO/2, 180));
                marco.add(vp.lastElement());
            }
        });
        mi21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int y = (int)(Math.random()*(ALTO-50));
                vb.add(new Barco(0, y, 100, 50));
                marco.add(vb.lastElement());
            }
        });
    }

    private void revisarColisionPelota() {
        for (int i = 0; i < vp.size(); i++) {
            Pelota pe = vp.get(i);
            if(pe.getPosX()<=p.getPosX()+p.getW() &&
                    pe.getPosY()<=p.getPosY()+p.getH() &&
                    pe.getPosY()+pe.getD()>=p.getPosY() &&
                    pe.getPosX()+pe.getD()>=p.getPosX()){
                if(pe.isContacto()){
                    //System.out.println("colision pelota");
                    p.setVidas(p.getVidas()-1);
//                    System.out.println(vp.size()+"  "+flagPelota);
                    pe.setContacto(false);
                    if(p.getVidas()==0){
                        repaint();
                        int ans = JOptionPane.showConfirmDialog(marco, "Empezar un nuevo juego?");
                        if(ans==0){
                            p.setVidas(5);
                            p.setPuntos(0);
                        }else{
                            System.exit(0);
                        }
                        break;
                    }//0 si, 1 no, 2 cancel
                } 
            }else{
                pe.setContacto(true);
            }
        }
        for (int i = 0; i < vb.size(); i++) {
            Barco pe = vb.get(i);
            if(pe.getPosX()<=p.getPosX()+p.getW() &&
                    pe.getPosY()<=p.getPosY()+p.getH() &&
                    pe.getPosY()+pe.getH()>=p.getPosY() &&
                    pe.getPosX()+pe.getW()>=p.getPosX()){
                System.out.println("colision barco");
                if(pe.isContacto()){
                    //System.out.println("colision pelota");
                    p.setVidas(p.getVidas()-1);
//                    System.out.println(vp.size()+"  "+flagPelota);
                    pe.setContacto(false);
                    if(p.getVidas()==0){
                        repaint();
                        int ans = JOptionPane.showConfirmDialog(marco, "Empezar un nuevo juego?");
                        if(ans==0){
                            p.setVidas(5);
                            p.setPuntos(0);
                        }else{
                            System.exit(0);
                        }
                        break;
                    }//0 si, 1 no, 2 cancel
                } 
            }else{
                pe.setContacto(true);
            }
        }
        if(t.getPosX()<=p.getPosX()+p.getW() &&
                t.getPosY()<=p.getPosY()+p.getH() &&
                t.getPosY()+t.getH()>=p.getPosY() &&
                t.getPosX()+t.getW()>=p.getPosX()){
            if(t.isContacto()){
                System.out.println("colision objetivo");
                p.setPuntos(p.getPuntos()+1);
                t.setContacto(false);
            }
        }else{
            t.setContacto(true);
        }
    }

    

   
    
    
    
}
