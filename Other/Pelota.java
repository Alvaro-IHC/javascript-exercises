
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Pelota extends JComponent{
    private int x;
    private int y;
    private int d;
    private int dx;
    private int v;
    private int th;
    private int tk;
    private int tr;
    private int alpha;
    private boolean contacto;

    private boolean tipoTray;
    public Pelota(int d, int th, int tk, int tr) {
        x = th-tr;
        this.d = d;
        this.th = th;
        this.tk = tk;
        this.tr = tr;
        alpha = 0;
        v = 2;
        dx = 1;
        tipoTray = Math.random()>0.5;
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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getTh() {
        return th;
    }

    public void setTh(int th) {
        this.th = th;
    }

    public int getTk() {
        return tk;
    }

    public void setTk(int tk) {
        this.tk = tk;
    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }
    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawOval(x, y, d, d);
        move();
    }
    
    void move(){
        if(tipoTray){
            move1();
        }else{
            move2();
        }
    }
    
    private void move1() {
        alpha = (alpha+v)%360;
        x = th+(int)(tr*Math.cos(alpha*2*Math.PI/360));
        y = tk+(int)(tr*Math.sin(alpha*2*Math.PI/360));
    }
    
    private void move2() {
        x = x+dx*v;
        if (x >= th+tr){
            dx = -1;
        }
        if (x <= th-tr){
            dx = 1;
        }
        y = tk + dx*(int)(Math.sqrt(tr*tr-(x-th)*(x-th)));
    }
    
}
