package Visual;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


/**
 * Represents the Main Screen
 */
public class MenuPanel extends JPanel  {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private BufferedImage maia_LOGO;
  private JButton myCardsButton;
  private JButton createButton;
  private JButton exploreButton;

  public MenuPanel() {
    super();

    this.MAIA_BG_COLOR = new Color(40,45,51);
    this.MAIA_LOGO_COLOR = new Color(144,195,240);

    this.setPreferredSize(new Dimension(200,1000));
    this.setBackground(MAIA_BG_COLOR);
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));




    Border border = BorderFactory.createMatteBorder(6, 6, 6, 3,
            MAIA_LOGO_COLOR);
    this.setBorder(border);




    //---------------------------------------------------------------------------------------------
    //------------------------------------Maia Logo in Background----------------------------------
    //---------------------------------------------------------------------------------------------
    try {

      maia_LOGO = ImageIO.read(new File(
              "/Users/nicolastobar/Desktop/daployer/src/Resources/maiaLOGO.png"));
      JLabel maiaLogoLabel = new JLabel(new ImageIcon(maia_LOGO));
      this.add(maiaLogoLabel);

    } catch (IOException e) {

      e.getMessage();

    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------


    this.add(Box.createRigidArea(new Dimension(5,50)));


    createButton = new JButton("Create");
    createButton.setOpaque(true);
    createButton.setBackground(MAIA_BG_COLOR);
    createButton.setForeground(MAIA_LOGO_COLOR);
    createButton.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));
    this.add(createButton);



    this.add(Box.createRigidArea(new Dimension(5,50)));



    myCardsButton = new JButton("My Cards");
    myCardsButton.setOpaque(true);
    myCardsButton.setBackground(MAIA_BG_COLOR);
    myCardsButton.setForeground(MAIA_LOGO_COLOR);
    myCardsButton.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));
    this.add(myCardsButton);



    this.add(Box.createRigidArea(new Dimension(5,50)));



    this.exploreButton = new JButton("Explore");
    exploreButton.setOpaque(true);
    exploreButton.setBackground(MAIA_BG_COLOR);
    exploreButton.setForeground(MAIA_LOGO_COLOR);
    exploreButton.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));
    this.add(exploreButton);




  }



}
