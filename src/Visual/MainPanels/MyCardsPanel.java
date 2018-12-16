package Visual.MainPanels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    this.setLayout(new BorderLayout());


    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    this.setBorder(BorderFactory.createTitledBorder(border,
            "My Cards", 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


    cardPane = new JLayeredPane();
    cardPane.setPreferredSize(new Dimension(600, 800));
    cardPane.setBorder(BorderFactory.createTitledBorder(
            "My Card Stack---"));




    cardPane.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });


    this.add(cardPane);



  }

  public ArrayList<JPanel> getCards() {
    return cards;
  }

  public void updateCards() {
    //TODO: NEED TO FIX WHAT HAPPENS WHEN A LOT OF CARDS ARE ADDED AND IT OVERFLOWS, WHERE THEY GO
    //TODO: MAYBE SCROLLPANE?
    //TODO: Need to fix Order of layered Cards, newest ones first

    int size = this.cards.size();

    int x = 200;
    int y = 10;

    for(int i = 0; i < size; i++) {
      this.cards.get(i).setBounds(x, y, 400, 600);

      x = x + 50;
      y = y + 50;
      cardPane.add(this.cards.get(i), new Integer(i), 0);
//      cardPane.add(this.cards.get(i), new Integer(i));

    }

   // this.add(cardPane);


  }

}
