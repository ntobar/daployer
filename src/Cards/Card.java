package Cards;

import java.awt.Image;

import javax.swing.*;


/**
 * Represents a Cards.Card
 */
public abstract class Card implements ICard {
  private String name;
  private String title;
  private String description;
  private Image backgroundImage;
  private Image logoImage;

  public Card(String name, String title, Image backgroundImage, Image logoImage) {
    super();

    this.name = name;
    this.title = title;
    this.backgroundImage = backgroundImage;
    this.logoImage = logoImage;

  }



}
