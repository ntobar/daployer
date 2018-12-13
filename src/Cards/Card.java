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


  private HTML description;
  private Image backgroundImage;
  private BufferedImage logoImage;


  //TODO: Implement this later , HTML description, Image backgroundImage, Image logoImage
  public Card() {
    super();

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.name = "";
    this.title = "";
    this.description = description;
    this.backgroundImage = backgroundImage;
    this.logoImage = logoImage;

  }



  public JPanel createCard(String name, String title) {



    JPanel card = new JPanel();
    card.setLayout(new BoxLayout(card, BoxLayout.PAGE_AXIS));

    //card.setLayout(new GridBagLayout());

    JLabel nameLabel = new JLabel(name + " ");
    JLabel titleLabel = new JLabel(title);

    card.setPreferredSize(new Dimension(300,500));
    card.setBackground(Color.black);

    JPanel bgLogoPanel = new JPanel();
    bgLogoPanel.setPreferredSize(new Dimension(card.getPreferredSize().width, 100));


    //---------------------------------------------------------------------------------------------
    //------------------------------------Logo and Background--------------------------------------
    //---------------------------------------------------------------------------------------------
    try {

      backgroundImage = ImageIO.read(new File(
              "/Users/nicolastobar/Desktop/daployer/src/Resources/maiaLOGO.png"));

      backgroundImage = backgroundImage.getScaledInstance(card.getPreferredSize().width,
              bgLogoPanel.getPreferredSize().height, Image.SCALE_DEFAULT);
      JLabel maiaLogoLabel = new JLabel(new ImageIcon(backgroundImage));
      //maiaLogoLabel.setPreferredSize(new Dimension(card.getWidth(), 100));
      bgLogoPanel.add(maiaLogoLabel);



    } catch (IOException e) {

      e.getMessage();

    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------

    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);


    card.add(bgLogoPanel);

    JPanel infoPanel = new JPanel();
    infoPanel.setBackground(MAIA_BG_COLOR);
    infoPanel.setBorder(BorderFactory.createTitledBorder(border,
            name, 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));

    infoPanel.setPreferredSize(new Dimension(card.getPreferredSize().width, 400));

    infoPanel.add(nameLabel);
    infoPanel.add(titleLabel);

    card.add(infoPanel);




//    card.add(nameLabel);
//    card.add(titleLabel);


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


  public void setBackgroundImage(String pathName) {
    try {
      this.backgroundImage = ImageIO.read(new File(pathName));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setLogoImage(BufferedImage logoImage) {
    this.logoImage = logoImage;
  }
}
