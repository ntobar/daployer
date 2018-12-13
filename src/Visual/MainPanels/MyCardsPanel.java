package Visual.MainPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
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

    String text = "<html>\n" +
            "Color and font test:\n" +
            "<ul>\n" +
            "<li><font color=red>red</font>\n" +
            "<li><font color=blue>blue</font>\n" +
            "<li><font color=green>green</font>\n" +
            "<li><font size=-2>small</font>\n" +
            "<li><font size=+2>large</font>\n" +
            "<li><i>italic</i>\n" +
            "<li><b>bold</b>\n" +
            "</ul>\n";
    JLabel theLabel = new JLabel(text);

    this.add(theLabel);


  }
}