
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;

public class Target extends JComponent{
    
    private int x;
    private int y;
    private int w;
    private int h;
    private int dx;
    private int dy;
    private int vx;
    private int vy;
    private boolean contacto;
    public Target(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        dx = 1;
        dy = 1;
        vx = 5;
        vy = 5;
        contacto = true;
        setBounds(0, 0, Lienzo.ANCHO, Lienzo.ALTO);
    }

    public int getPosX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getPosY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isContacto() {
        return contacto;
    }

    public void setContacto(boolean contacto) {
        this.contacto = contacto;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        GeneralPath gp = new GeneralPath();
        gp.moveTo(x+w/2, y);
        gp.lineTo(x+w, y+3*h/4);
        gp.lineTo(x, y+3*h/4);
        gp.closePath();
        g2.setColor(Color.red);
        g2.fill(gp);
        g2.rotate(Math.toRadians(180), x+w/2, y+h/2);
        g2.setColor(Color.red);
        g2.fill(gp);
        move();
    }
    private void move() {
        if(x<=0){
            dx = 1;
            vx = (int)(Math.random()*5)*3;
        }
        if(x+w>=Lienzo.ANCHO){
            dx = -1;
            vx = (int)(Math.random()*5)*3;
        }
        if(y<=0){
            dy = 1;
            vy = (int)(Math.random()*5)*3;
        }
        if(y+h>=Lienzo.ALTO){
            dy = -1;
            vy = (int)(Math.random()*5)*3;
        }
        x = x+dx*vx;
        y = y+dy*vy;
    }
    
    
}
