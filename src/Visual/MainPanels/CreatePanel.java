package Visual.MainPanels;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;


import javax.swing.*;
import javax.swing.border.Border;

import Cards.Card;
import Cards.ICard;
import Cards.dAppCard;

public class CreatePanel extends JPanel {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private ICard card;
  private JButton createCard;
  private JLabel nameLabel;
  private JLabel titleLabel;
  private JLabel descriptionLabel;
  private JTextField nameField;
  private JTextField titleField;
  private JButton chooseBackGroundImg;
  private JButton chooseLogoImg;
  private JButton chooseHTML;
  private JFileChooser backgroundImgChooser;
  private JFileChooser logoImgChooser;
  private JFileChooser htmlChooser;
  private String name;


  public CreatePanel() {
    super();

    this.card = new dAppCard();
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
            "Card Factory", 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));

    //this.setLayout(new BorderLayout());


    //---------------------------------------------------------------------------------------------
    //------------------------------------JLabels Setup -------------------------------------------
    //---------------------------------------------------------------------------------------------

    nameLabel = new JLabel("Card Name: ");
    titleLabel = new JLabel("Card Title: ");
    descriptionLabel = new JLabel("Card Description");


    //---------------------------------------------------------------------------------------------
    //------------------------------------JTextFields Setup ---------------------------------------
    //---------------------------------------------------------------------------------------------

    nameField = new JTextField();
    nameField.setColumns(10);
    nameField.setActionCommand("nameField");
    //String nameText = "";
    nameField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {

      }

      @Override
      public void focusLost(FocusEvent e) {

        String nameText = ((JTextField) e.getSource()).getText();

        setName(nameText);
      }
    });



    titleField = new JTextField();
    titleField.setColumns(10);
    titleField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {

      }

      @Override
      public void focusLost(FocusEvent e) {

        String nameText = ((JTextField) e.getSource()).getText();

        setTitle(nameText);

      }
    });


    //---------------------------------------------------------------------------------------------
    //------------------------------------Order Setup -------------------------------------------
    //---------------------------------------------------------------------------------------------

    this.add(nameLabel);
    this.add(nameField);

    this.add(titleLabel);
    this.add(titleField);

    backgroundImgChooser = new JFileChooser();
    backgroundImgChooser.setDialogTitle("Upload Background Image");

    logoImgChooser = new JFileChooser();
    logoImgChooser.setDialogTitle("Upload Logo Image");

    htmlChooser = new JFileChooser();
    htmlChooser.setDialogTitle("HTML Upload");
    htmlChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    htmlChooser.setAcceptAllFileFilterUsed(false);




    chooseBackGroundImg = new JButton("Choose Background Image");
    chooseBackGroundImg.setActionCommand("chooseBGIMG");
    this.add(chooseBackGroundImg);

    chooseLogoImg = new JButton("Choose Logo Image");
    chooseLogoImg.setActionCommand("chooseLogoImage");
    this.add(chooseLogoImg);

    chooseHTML = new JButton("Choose HTML Files");
    chooseHTML.setActionCommand("chooseHTMLImage");
    this.add(chooseHTML);


    this.createCard = new JButton("Create Card");
    createCard.setActionCommand("createCardButton");
    this.add(createCard);


  }

  public void setName(String text) {

    this.card.setName(text);

  }

  public void setTitle(String text) {

    this.card.setTitle(text);

  }


  public ICard getCard() {
    return card;
  }

  public JButton getCreateCard() {
    return createCard;
  }

  public JLabel getNameLabel() {
    return nameLabel;
  }

  public JLabel getTitleLabel() {
    return titleLabel;
  }

  public JLabel getDescriptionLabel() {
    return descriptionLabel;
  }

  public JButton getChooseBackGroundImg() {
    return chooseBackGroundImg;
  }

  public JButton getChooseLogoImg() {
    return chooseLogoImg;
  }

  public JFileChooser getBackgroundImgChooser() {
    return backgroundImgChooser;
  }

  public JFileChooser getLogoImgChooser() {
    return logoImgChooser;
  }

  public JTextField getNameField() {
    return nameField;
  }

  public JTextField getTitleField() {
    return titleField;
  }

  public JButton getChooseHTML() {
    return chooseHTML;
  }

  public JFileChooser getHtmlChooser() {
    return htmlChooser;
  }
}
