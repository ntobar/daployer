package Cards;

import java.awt.*;

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
  private HTML description;
  private Image backgroundImage;
  private Image logoImage;

  //TODO: Implement this later , HTML description, Image backgroundImage, Image logoImage
  public Card(String name, String title) {
    super();

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.name = name;
    this.title = title;
    this.description = description;
    this.backgroundImage = backgroundImage;
    this.logoImage = logoImage;

  }

  public JPanel createCard(String name, String title) {

    JPanel card = new JPanel();

    card.setLayout(new GridBagLayout());

    JLabel nameLabel = new JLabel(name);
    JLabel titleLabel = new JLabel(title);

    card.setSize(300,500);

    card.add(nameLabel);
    card.add(titleLabel);

    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    card.setBorder(BorderFactory.createTitledBorder(border,
            title, 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


    return card;






  }



}
