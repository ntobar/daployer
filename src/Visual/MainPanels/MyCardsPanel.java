package Visual.MainPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import Cards.ICard;


public class MyCardsPanel extends JPanel {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private ArrayList<JPanel> cards;
  private JButton addCard;
  private JPanel panel1;
  private JLayeredPane cardPane;


  public MyCardsPanel() {
    super();

    this.cards = new ArrayList<>();

    this.setPreferredSize(new Dimension(800, 1000));

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.setBackground(MAIA_BG_COLOR);


    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    this.setBorder(BorderFactory.createTitledBorder(border,
            "My Cards", 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


    cardPane = new JLayeredPane();
    cardPane.setPreferredSize(new Dimension(600, 800));
    cardPane.setBorder(BorderFactory.createTitledBorder(
            "My Card Stack---"));





  }

  public void updateCards() {
    int size = this.cards.size();

    for(int i = 0; i < size; i++) {
      cardPane.add(this.cards.get(i), new Integer(i));

    }


  }

}
