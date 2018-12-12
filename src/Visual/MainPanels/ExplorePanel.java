package Visual.MainPanels;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import Cards.ICard;

public class ExplorePanel extends JPanel {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private ArrayList<ICard> cards;

  public ExplorePanel() {
    super();

    this.cards = new ArrayList<>();

    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------

    this.setPreferredSize(new Dimension(800, 1000));

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.setBackground(MAIA_BG_COLOR);


    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    this.setBorder(BorderFactory.createTitledBorder(border,
            "Explore", 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


  }


}
