package Cards;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.html.HTML;


/**
 * Represents a Cards.Card
 */
public abstract class Card implements ICard {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private String name;
  private String title;
  private JLabel html;
  private JPanel bgLogoPanel;
  String pathName;
  JPanel card;
  JLabel maiaLogoLabel;
  ImageIcon icon;
  //File file;


  private HTML description;
  private Image backgroundImage;
  private BufferedImage logoImage;




  //TODO: Implement this later , HTML description, Image backgroundImage, Image logoImage
  public Card() {
    //super();

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

//    try {
//      this.backgroundImage = ImageIO.read(new File(
//              "/Users/nicolastobar/Desktop/daployer/src/Resources/maiaLOGO.png"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    this.name = "";
    this.title = "";
    this.description = description;
    //this.backgroundImage = backgroundImage;
    this.logoImage = logoImage;
    this.pathName = "";

  }



  public JPanel createCard(String name, String title, String pName) {



    card = new JPanel();
    card.setLayout(new BoxLayout(card, BoxLayout.PAGE_AXIS));

    //card.setLayout(new GridBagLayout());

    JLabel nameLabel = new JLabel(name + " ");
    JLabel titleLabel = new JLabel(title);

    card.setPreferredSize(new Dimension(300,500));
    card.setBackground(Color.black);


//
//
//    //---------------------------------------------------------------------------------------------
//    //------------------------------------Logo and Background--------------------------------------
//    //---------------------------------------------------------------------------------------------
//
//    icon = new ImageIcon();
//
//    JLabel maiaLogoLabel = new JLabel(icon);

    //JLabel maiaLogoLabel = new JLabel(new ImageIcon(backgroundImage));
//    bgLogoPanel.add(maiaLogoLabel);

    bgLogoPanel = new JPanel();
    bgLogoPanel.setPreferredSize(new Dimension(card.getPreferredSize().width, 100));

    try {
      JLabel testLabel = new JLabel(new ImageIcon(ImageIO.read(new File("/Users/nicolastobar/Desktop/daployer/src/Resources/maiaLOGO.png"))));
      //bgLogoPanel.add(testLabel);

    } catch (IOException e) {
      e.printStackTrace();
    }





    try {
//      file = new File(
//              "/Users/nicolastobar/Desktop/daployer/src/Resources/maiaLOGO.png");



      File file = new File(pName);
      System.out.println(pName);





      backgroundImage = ImageIO.read(new File(pName));

      backgroundImage = backgroundImage.getScaledInstance(card.getPreferredSize().width,
              bgLogoPanel.getPreferredSize().height, Image.SCALE_DEFAULT);


//      JLabel maiaLogoLabel = new JLabel(new ImageIcon(backgroundImage));

      //JLabel maiaLogoLabel = new JLabel(new ImageIcon(ImageIO.read(new File(pName))));
      JLabel maiaLogoLabel = new JLabel(new ImageIcon(backgroundImage));
      //maiaLogoLabel.setPreferredSize(new Dimension(card.getWidth(), 100));
      bgLogoPanel.add(maiaLogoLabel);


      card.add(bgLogoPanel);

    } catch (IOException e) {

      e.getMessage();

    }



    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------

    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);




    JPanel infoPanel = new JPanel();
    infoPanel.setBackground(MAIA_BG_COLOR);
    infoPanel.setBorder(BorderFactory.createTitledBorder(border,
            name, 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));

    infoPanel.setPreferredSize(new Dimension(card.getPreferredSize().width, 400));

    infoPanel.add(nameLabel);
    infoPanel.add(titleLabel);

    card.add(infoPanel);





    card.setBorder(BorderFactory.createTitledBorder(border,
            name, 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


    return card;


  }

  public String getName() {
    return name;
  }

  public String getTitle() {
    return title;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public JLabel getHtml() {
    return html;
  }

  public void setHtml(JLabel html) {
    this.html = html;
  }

  public HTML getDescription() {
    return description;
  }

  public void setDescription(HTML description) {
    this.description = description;
  }

  public void setPathName(String pathName) {
    this.pathName = pathName;
  }


//  public void setBackgroundImage(String pathName) {
//
//    bgLogoPanel = new JPanel();
//    bgLogoPanel.setPreferredSize(new Dimension(card.getPreferredSize().width, 100));
//
//
//    //---------------------------------------------------------------------------------------------
//    //------------------------------------Logo and Background--------------------------------------
//    //---------------------------------------------------------------------------------------------
//
////    icon = new ImageIcon();
////
////    JLabel maiaLogoLabel = new JLabel(icon);
//
//    //JLabel maiaLogoLabel = new JLabel(new ImageIcon(backgroundImage));
////    bgLogoPanel.add(maiaLogoLabel);
//
//    try {
//      file = new File(pathName);
//
//      backgroundImage = ImageIO.read(file);
//
//      backgroundImage = backgroundImage.getScaledInstance(card.getPreferredSize().width,
//              bgLogoPanel.getPreferredSize().height, Image.SCALE_DEFAULT);
//
//
//      JLabel maiaLogoLabel = new JLabel(new ImageIcon(backgroundImage));
//      maiaLogoLabel.setPreferredSize(new Dimension(card.getWidth(), 100));
//      bgLogoPanel.add(maiaLogoLabel);
//
//
//
//    } catch (IOException e) {
//
//      e.getMessage();
//
//    }
//
//    card.add(bgLogoPanel);
//
//
////
////    try {
////      file = new File(pathName);
////
////      backgroundImage = ImageIO.read(file);
////
////
////      backgroundImage = backgroundImage.getScaledInstance(card.getPreferredSize().width,
////              bgLogoPanel.getPreferredSize().height, Image.SCALE_DEFAULT);
////
////
////      //JLabel maiaLogoLabel = new JLabel(new ImageIcon(backgroundImage));
////      //maiaLogoLabel.setPreferredSize(new Dimension(card.getWidth(), 100));
////      bgLogoPanel.add(maiaLogoLabel);
////
////
////
////    } catch (IOException e) {
////
////      e.getMessage();
////
////    }
//
//
//  }

  public void setLogoImage(BufferedImage logoImage) {
    this.logoImage = logoImage;
  }

  public String getPathName() {
    return pathName;
  }
}
