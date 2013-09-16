package org.ldv.melun.sio.swingpac.etudiants;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import org.ldv.melun.sio.swingpac.Bidule;

public class Laureen extends Bidule {
	
	private int incY, incX;
	  
	  private int nbImpact;
	  
	  private Image image=null;

  public Laureen(String name) {
    super(name);
  }

  public Laureen() {
    this("Laureen");
    //setBackground(Color.cyan); 
    
  }
  
  public void paintComponent(Graphics g){
	  image = getToolkit().getImage("images/image.png");
	  g.drawImage(image,  0, 0, 100, 100, this);
  }

 
  public void doMove() {
	    // obtenir les coordonnées de la scene
	    Rectangle rect = getParent().getBounds();

	    // changement de direction si une frontière est atteinte
	    if (getX() + getWidth() + incX > rect.width)
	      goOnLeft();
	    if (getX() + incX < 0)
	      goOnRight();
	    if (getY() + getHeight() + incY > rect.height)
	      goOnTop();
	    if (getY() + incY < -1)
	      goOnDown();
	    
	    super.doMove();
	  }

  @Override
  protected void doAfterImpactByOther() {
    super.doAfterImpactByOther();
    if (isGoDown())
    setLocation(getX() + incX, getY() + incY);
      goOnLeft();

  }
  

   
}
