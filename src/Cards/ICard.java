package Cards;

import javax.swing.*;

/**
 * Cards.Card Interface
 */
public interface ICard {

  JPanel createCard(String name, String title);

  String getName();

  String getTitle();

  void setName(String name);

  void setTitle(String title);


}


