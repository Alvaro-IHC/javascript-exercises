
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Raton implements MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        Lienzo.p.setX(e.getX()-Lienzo.p.getW()/2-10);
        Lienzo.p.setY(e.getY()-Lienzo.p.getH()/2-60);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    
    
}
