
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;

public class Barco extends JComponent{
    
    private int x;
    private int y;
    private int w;
    private int h;
    private int dx;
    private int v;
    private int linea;
    private boolean contacto;
    public Barco(int x, int y, int w, int h) {
        this.x = x;
        linea = y;
        this.w = w;
        this.h = h;
        dx = 1;
        v = 5;
        contacto = true;
        setBounds(0, 0, Lienzo.ANCHO, Lienzo.ALTO);
    }

    public boolean isContacto() {
        return contacto;
    }

    public void setContacto(boolean contacto) {
        this.contacto = contacto;
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath gp = new GeneralPath();
        int cx = w/21;
        int cy = h/11;
        gp.moveTo(x, y+5*cy);
        gp.lineTo(x+7*cx, y+5*cy);
        gp.lineTo(x+7*cx, y);
        gp.lineTo(x+14*cx, y);
        gp.lineTo(x+14*cx, y+5*cy);
        gp.lineTo(x+21*cx, y+5*cy);
        gp.curveTo(x+21*cx, y+5*cy, x+21*cy/2, y+20*cy, x, y+5*cy);
        g2.fill(gp);
        g2.setColor(Color.red);
        g2.fillRect(x+8*cx, y+cy, cx, cy);
        g2.fillRect(x+10*cx, y+cy, cx, cy);
        g2.fillRect(x+12*cx, y+cy, cx, cy);
        g2.fillRect(x+8*cx, y+3*cy, cx, cy);
        g2.fillRect(x+10*cx, y+3*cy, cx, cy);
        g2.fillRect(x+12*cx, y+3*cy, cx, cy);
        
        move();
    }
    private void move() {
        int a = 50;
        int l = 200;
        x = x+dx*v;
        if (x+w>=Lienzo.ANCHO){
            dx = -1;
        }
        if (x <= 0){
            dx = 1;
        }
        y = linea+(int)(a*Math.sin(x*Math.PI/l));
    }
    
    
}
