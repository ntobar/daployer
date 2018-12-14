package Cards;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;
import javax.swing.text.html.HTML;

/**
 * Cards.Card Interface
 */
public interface ICard {

  JPanel createCard(String name, String title, String pName);

  String getName();

  String getTitle();

  void setName(String name);

  void setTitle(String title);

  JLabel getHtml();

  void setHtml(JLabel html);

  HTML getDescription();

  void setDescription(HTML description);

  //void setBackgroundImage(String pathName);

  void setLogoImage(BufferedImage logoImage);

  void setPathName(String pathName);

  String getPathName();


}


