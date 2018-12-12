package Visual.MainPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class MyCardsPanel extends JPanel {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private JButton addCard;

  public MyCardsPanel() {
    super();


    this.setPreferredSize(new Dimension(800, 1000));

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.setBackground(MAIA_BG_COLOR);


    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    this.setBorder(BorderFactory.createTitledBorder(border,
            "My Cards", 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


  }
}
