package Visual.MainPanels;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import Cards.ICard;
import Cards.dAppCard;


/**
 *
 */
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
  private JButton createHTML;
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


    int panelWidth = this.getPreferredSize().width/3;


    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.setBackground(MAIA_BG_COLOR);


    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    this.setBorder(BorderFactory.createTitledBorder(border,
            "Card Factory", 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


    //---------------------------------------------------------------------------------------------
    //---------------------------------- Layout Setup ---------------------------------------------
    //---------------------------------------------------------------------------------------------

    GridBagConstraints g = new GridBagConstraints();
    this.setLayout(new GridBagLayout());
    //g.insets = new Insets(10,10,10,10);


    //Daployer Logo

    JLabel logoLeft = new JLabel("<html><p><span color=#90C3F0 style=\""
            + "font-family: terminal, monaco; font-size: 36pt;\"> ------ </span></p>");

    JLabel logoRight = new JLabel("<html><p><span color=#90C3F0 style=\""
            + "font-family: terminal, monaco; font-size: 36pt;\"> ------ </span></p>");


//    JLabel daployerLabel = new JLabel("<html><p><span color=#282D33 style=\""
//            + "font-family: terminal, monaco; font-size: 36pt;\">>_  daployer </span></p>");

//    JLabel daployerLabel = new JLabel("<html><p><span color=#90C379 style=\""
//            + "font-family: terminal, monaco; font-size: 36pt;\">>_  daployer </span></p>");

    JLabel daployerLabel = new JLabel("<html><p><span color=#90C3F0 style=\""
            + "font-family: terminal, monaco; font-size: 36pt;\">>_  daployer </span></p>");

    Border daployerBorder = BorderFactory.createMatteBorder(3,3,3,3,
            MAIA_LOGO_COLOR);
    //daployerLabel.setBorder(daployerBorder);

//    daployerLabel.setOpaque(true);
//
//    daployerLabel.setBackground(MAIA_LOGO_COLOR);


    daployerLabel.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));


//    daployerLabel.setBorder(BorderFactory.createBevelBorder(
//            BevelBorder.RAISED, MAIA_LOGO_COLOR,
//            MAIA_LOGO_COLOR,
//            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));




    g.gridx = 1;
    g.gridy = 0;
    g.ipady = 20;
    g.ipadx = 200;
    g.weightx = 0.5;
    g.weighty = 1.0;
    //g.ipadx = 5;
   // g.fill = GridBagConstraints.HORIZONTAL;
   // g.gridwidth = 0;

    this.add(daployerLabel, g);

    JLabel emptyLeft = new JLabel();
    emptyLeft.setOpaque(true);
    emptyLeft.setBackground(MAIA_BG_COLOR);
    emptyLeft.setBorder(BorderFactory.createMatteBorder(10,0,10,0, MAIA_LOGO_COLOR));
//    emptyLeft.setBorder(BorderFactory.createBevelBorder(
//            BevelBorder.RAISED,
//            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
//            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));


    JLabel emptyRight = new JLabel();
    emptyRight.setOpaque(true);
    //emptyRight.setBackground(MAIA_LOGO_COLOR);
    emptyRight.setBackground(MAIA_BG_COLOR);
    emptyRight.setBorder(BorderFactory.createMatteBorder(10,0,10,0, MAIA_LOGO_COLOR));

//    emptyRight.setBorder(BorderFactory.createBevelBorder(
//            BevelBorder.RAISED,
//            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
//            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));

    g.gridx = 0;
    g.gridy = 0;
    g.ipady = 20;
    g.ipadx = 300;

    this.add(emptyLeft,g);

    g.gridx = 2;
    g.gridy = 0;
    g.ipady = 20;
    g.ipadx = 310;

    this.add(emptyRight,g);


    g.ipady = 40;
    g.ipadx = 300;


    //this.add(Box.createRigidArea(new Dimension(this.getWidth(),100)));
    //---------------------------------------------------------------------------------------------
    //------------------------------------JLabels Setup -------------------------------------------
    //---------------------------------------------------------------------------------------------

    nameLabel = new JLabel("<html><font color=#90C3F0>Card Name: </font>");
    titleLabel = new JLabel("<html><font color=#90C3F0>Card Title: </font>");
    descriptionLabel = new JLabel("<html><font color=#90C3F0>Card Description: </font>");


    //---------------------------------------------------------------------------------------------
    //------------------------------------JTextFields Setup ---------------------------------------
    //---------------------------------------------------------------------------------------------

    nameField = new JTextField();
    nameField.setColumns(10);
    nameField.setActionCommand("nameField");

    nameField.setBorder(BorderFactory.createLineBorder(MAIA_LOGO_COLOR));


    //String nameText = "";
    nameField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {

        nameField.setBackground(Color.gray);




      }

      @Override
      public void focusLost(FocusEvent e) {

        String nameText = ((JTextField) e.getSource()).getText();

        setName(nameText);
        nameField.setBackground(Color.WHITE);
      }
    });



    titleField = new JTextField();
    titleField.setColumns(10);
    titleField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        titleField.setBackground(Color.gray);

      }

      @Override
      public void focusLost(FocusEvent e) {

        String nameText = ((JTextField) e.getSource()).getText();

        setTitle(nameText);
        titleField.setBackground(Color.WHITE);

      }
    });


    //---------------------------------------------------------------------------------------------
    //---------------------------- Adding Name & Title Label/Fields -------------------------------
    //---------------------------------------------------------------------------------------------

//    g.gridx = 0;
//    g.gridy = 1;

//    g.ipady = 5;
//    g.ipadx = 200;

   // this.add(new JSeparator(), g);

//    g.ipady = 50;
//    g.ipadx = 300;


    g.gridx = 0;
    g.gridy = 1;


    JPanel namePanel = new JPanel();
    namePanel.add(nameLabel);
    namePanel.add(nameField);
    namePanel.setBackground(MAIA_BG_COLOR);
    namePanel.setBorder(BorderFactory.createMatteBorder(5,0,5,0,
            MAIA_LOGO_COLOR));
    namePanel.setPreferredSize(new Dimension(panelWidth,100));
    this.add(namePanel, g);



    g.gridx = 1;
    g.gridy = 1;

    g.ipady = 58;
    g.ipadx = 300;


    JPanel emptyPanel = new JPanel();
    emptyPanel.setBackground(MAIA_BG_COLOR);
    emptyPanel.setBorder(BorderFactory.createMatteBorder(2,0,2,0,
            MAIA_LOGO_COLOR));
    emptyPanel.setPreferredSize(new Dimension(panelWidth,100));
    this.add(emptyPanel, g);


//    g.gridx = 0;
//    g.gridy = 1;
//    this.add(nameLabel,g);
//
//    g.gridx = 1;
//    g.gridy = 1;
//    this.add(nameField,g);

    g.ipady = 32;
    g.ipadx = panelWidth;


    g.gridx = 2;
    g.gridy = 1;

    JPanel titlePanel = new JPanel();
    titlePanel.add(titleLabel);
    titlePanel.add(titleField);
    titlePanel.setBackground(MAIA_BG_COLOR);
    titlePanel.setBorder(BorderFactory.createMatteBorder(5,0,5,0,
            MAIA_LOGO_COLOR));
    titlePanel.setPreferredSize(new Dimension(panelWidth,100));
    this.add(titlePanel, g);



//    this.add(titleLabel,g);
//
//
//
//    g.gridx = 3;
//    g.gridy = 1;
//    this.add(titleField,g);


    //this.add(new JSeparator());

    g.ipady = 0;
    g.ipadx = 100;



    //g.insets = new Insets(10, 10, 10, 10);

    //---------------------------------------------------------------------------------------------
    //---------------------------------- BG/LOGO/HTML Choosers ------------------------------------
    //---------------------------------------------------------------------------------------------

    backgroundImgChooser = new JFileChooser();
    backgroundImgChooser.setAcceptAllFileFilterUsed(false);
    FileFilter imageFilter = new FileNameExtensionFilter(
            "Image files", ImageIO.getReaderFileSuffixes());
    backgroundImgChooser.addChoosableFileFilter(imageFilter);
    backgroundImgChooser.setDialogTitle("Upload Background Image");


    logoImgChooser = new JFileChooser();
    logoImgChooser.setDialogTitle("Upload Logo Image");

    htmlChooser = new JFileChooser();
    htmlChooser.setDialogTitle("HTML Upload");
    htmlChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    htmlChooser.setAcceptAllFileFilterUsed(false);





    //---------------------------------------------------------------------------------------------
    //---------------------------------- Button Setup & Adding ------------------------------------
    //---------------------------------------------------------------------------------------------

    chooseBackGroundImg = new JButton("Choose Background Image");
    chooseBackGroundImg.setActionCommand("chooseBGIMG");
    chooseBackGroundImg.setOpaque(true);
    chooseBackGroundImg.setBackground(MAIA_LOGO_COLOR);
    chooseBackGroundImg.setForeground(MAIA_BG_COLOR);
    chooseBackGroundImg.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR,
            MAIA_BG_COLOR,
            MAIA_LOGO_COLOR, MAIA_BG_COLOR));

    g.gridx = 0;
    g.gridy = 2;
    this.add(chooseBackGroundImg,g);

    chooseLogoImg = new JButton("Choose Logo Image");
    chooseLogoImg.setActionCommand("chooseLogoImage");
    g.gridx = 1;
    g.gridy = 2;
    this.add(chooseLogoImg,g);

    chooseHTML = new JButton("Choose HTML Files");
    chooseHTML.setActionCommand("chooseHTMLImage");
    g.gridx = 2;
    g.gridy = 2;
    this.add(chooseHTML,g);

    createHTML = new JButton("HTML Lab");
    createHTML.setActionCommand("HTMLLab");
    g.gridx = 1;
    g.gridy = 3;
    this.add(createHTML,g);


    this.createCard = new JButton("Create Card");
    createCard.setActionCommand("createCardButton");
    g.gridx = 2;
    g.gridy = 3;
    this.add(createCard,g);


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

  public JButton getCreateHTML() {
    return createHTML;
  }
}
