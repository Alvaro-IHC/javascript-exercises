
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;

public class Player extends JComponent{
    
    private int x;
    private int y;
    private int w;
    private int h;
    private int puntos;
    private int vidas;
    
    
    public Player(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        puntos = 0;
        vidas = 5;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath gp = new GeneralPath();
        int cx = w/5;
        int cy = h/8;
        gp.moveTo(x, y+3*cy);
        gp.lineTo(x, y+2*cy);
        gp.lineTo(x+cx/2, y+2*cy);
        gp.lineTo(x+cx, y+3*cy);
        gp.lineTo(x+cx, y+cy);
        gp.curveTo(x+cx, y+cy, x+3*cx/2, y-cy, x+2*cx, y+cy);
        gp.lineTo(x+2*cx, y+3*cy);
        gp.curveTo(x+2*cx, y+3*cy, x+5*cx/2, y+cy, x+3*cx, y+3*cy);
        gp.curveTo(x+3*cx, y+3*cy, x+7*cx/2, y+3*cy/2, x+4*cx, y+3*cy);
        gp.curveTo(x+4*cx, y+3*cy, x+9*cx/2, y+2*cy, x+5*cx, y+3*cy);
        gp.lineTo(x+5*cx, y+5*cy);
        gp.lineTo(x+4*cx, y+7*cy);
        gp.lineTo(x+4*cx, y+8*cy);
        gp.lineTo(x+cx, y+8*cy);
        gp.lineTo(x+cx, y+7*cy);
        gp.closePath();
        g2.draw(gp);
    }
    
    
    
}
