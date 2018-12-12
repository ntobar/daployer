package Visual;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import Cards.ICard;


/**
 * Represents the Home View JFrame
 */
public class HomeView extends JFrame {
  private MenuPanel menuPanel;
  private CreatePanel createPanel;
  private ICard card;



//ICard card
  public HomeView() {
    super();

    this.setTitle("- daployer -");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setPreferredSize(new Dimension(1000,1000));


    this.card = card;

    menuPanel = new MenuPanel();
    this.add(menuPanel, BorderLayout.WEST);

    createPanel = new CreatePanel();
    this.add(createPanel, BorderLayout.EAST);




    //Making it Visible
    this.pack();
    this.setVisible(true);

  }




}
