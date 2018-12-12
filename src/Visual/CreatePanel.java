package Visual;

import java.awt.*;


import javax.swing.*;
import javax.swing.border.Border;

public class CreatePanel extends JPanel {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private JButton addCard;

  public CreatePanel() {
    super();

    this.setPreferredSize(new Dimension(800, 1000));

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.setBackground(MAIA_BG_COLOR);

    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    this.setBorder(border);

    this.addCard = new JButton("Add Card");
    this.add(addCard);


  }
}
