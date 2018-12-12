package Visual;

import java.awt.*;
import java.awt.event.ActionListener;
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

    //TODO: DEBATE WHETHER TO COMMENT THIS OUT
    //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));




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




    //---------------------------------------------------------------------------------------------
    //----------------------------------- CREATE BUTTON -------------------------------------------
    //---------------------------------------------------------------------------------------------
    JPanel createPanel = new JPanel();
    //createPanel.setSize(new Dimension(200,60));
    createPanel.setBackground(MAIA_BG_COLOR);


    createButton = new JButton("   Create   ");
    createButton.setPreferredSize(new Dimension(190, 50));
    createButton.setOpaque(true);
    createButton.setBackground(MAIA_BG_COLOR);
    createButton.setForeground(MAIA_LOGO_COLOR);
    createButton.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));
    createButton.setActionCommand("createButton");
    createPanel.add(createButton);
    this.add(createPanel);
    //this.add(createButton);



    //this.add(Box.createRigidArea(new Dimension(5,50)));


    //---------------------------------------------------------------------------------------------
    //--------------------------------- MY CARDS BUTTON -------------------------------------------
    //---------------------------------------------------------------------------------------------

    JPanel cardsPanel = new JPanel();
    //cardsPanel.setSize(new Dimension(200,60));
    cardsPanel.setBackground(MAIA_BG_COLOR);



    myCardsButton = new JButton("   My Cards   ");
    myCardsButton.setPreferredSize(new Dimension(190, 50));
    myCardsButton.setOpaque(true);
    myCardsButton.setBackground(MAIA_BG_COLOR);
    myCardsButton.setForeground(MAIA_LOGO_COLOR);
    myCardsButton.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));
    myCardsButton.setActionCommand("myCardsButton");
    cardsPanel.add(myCardsButton);
    this.add(cardsPanel);
    //this.add(myCardsButton);



    //this.add(Box.createRigidArea(new Dimension(5,50)));


    //---------------------------------------------------------------------------------------------
    //---------------------------------- EXPLORE BUTTON -------------------------------------------
    //---------------------------------------------------------------------------------------------
    JPanel explorePanel = new JPanel();
    //explorePanel.setSize(new Dimension(200,60));
    explorePanel.setBackground(MAIA_BG_COLOR);


    exploreButton = new JButton("   Explore   ");
    exploreButton.setPreferredSize(new Dimension(190, 50));
    exploreButton.setOpaque(true);
    exploreButton.setBackground(MAIA_BG_COLOR);
    exploreButton.setForeground(MAIA_LOGO_COLOR);
    exploreButton.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));
    exploreButton.setActionCommand("exploreButton");
    explorePanel.add(exploreButton);
    this.add(explorePanel);
    //this.add(exploreButton);


  }


  public BufferedImage getMaia_LOGO() {
    return maia_LOGO;
  }

  public JButton getMyCardsButton() {
    return myCardsButton;
  }

  public JButton getCreateButton() {
    return createButton;
  }

  public JButton getExploreButton() {
    return exploreButton;
  }






}
