package Visual.MainPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import Cards.ICard;
import Cards.dAppCard;

//TODO: Create Card Button needs to go in between title and name



/**
 * A Panel and Class fully supporting Card Creating functionality.
 * Class responsible for creating Cards.
 */
public class CreatePanel extends JPanel implements MouseListener {
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;
  private ICard card;
  private ICard previewCard;
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
  private JButton previewButton;
  private JFileChooser backgroundImgChooser;
  private JFileChooser logoImgChooser;
  private JFileChooser htmlChooser;
  private JPanel previewPanel;




  /**
   * Consutrcts a {@code CreatePanel} object.
   */
  public CreatePanel() {
    super();

    this.card = new dAppCard();
    this.previewCard = new dAppCard();


    //---------------------------------------------------------------------------------------------
    //------------------------------------ Panel Preferences --------------------------------------
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
    JLabel daployerLabel = new JLabel("<html><p><span color=#90C3F0 style=\""
            + "font-family: terminal, monaco; font-size: 36pt;\">>_  daployer </span></p>");




    daployerLabel.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));




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
    emptyLeft.setBorder(BorderFactory.createMatteBorder(10,0,10,0,
            MAIA_LOGO_COLOR));
//    emptyLeft.setBorder(BorderFactory.createBevelBorder(
//            BevelBorder.RAISED,
//            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
//            MAIA_LOGO_COLOR, MAIA_LOGO_COLOR));


    JLabel emptyRight = new JLabel();
    emptyRight.setOpaque(true);
    //emptyRight.setBackground(MAIA_LOGO_COLOR);
    emptyRight.setBackground(MAIA_BG_COLOR);
    emptyRight.setBorder(BorderFactory.createMatteBorder(10,0,10,0,
            MAIA_LOGO_COLOR));

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

        //updateCard("name", nameText);




      }
    });




    titleField = new JTextField();
    titleField.setColumns(10);

    titleField.setBorder(BorderFactory.createLineBorder(MAIA_LOGO_COLOR));

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

//    g.ipady = 58;
//    g.ipadx = 300;


    g.ipady = 40;
    g.ipadx = panelWidth;

    JPanel emptyPanel = new JPanel();
    emptyPanel.setBackground(MAIA_BG_COLOR);
    emptyPanel.setBorder(BorderFactory.createMatteBorder(2,0,2,0,
            MAIA_LOGO_COLOR));
    emptyPanel.setPreferredSize(new Dimension(panelWidth,100));

    this.createCard = new JButton("Create Card");
    createCard.setOpaque(true);
    createCard.setBackground(MAIA_LOGO_COLOR);
    createCard.setForeground(MAIA_BG_COLOR);
    createCard.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));
    createCard.setActionCommand("createCardButton");
    createCard.setPreferredSize(new Dimension(100,35));

    createCard.addMouseListener(this);

//    g.gridx = 1;
//    g.gridy = 4;
//    g.gridx = 1;
//    g.gridy = 1;
    //this.add(createCard,g);
    emptyPanel.add(createCard);

    this.add(emptyPanel, g);


//    g.gridx = 0;
//    g.gridy = 1;
//    this.add(nameLabel,g);
//
//    g.gridx = 1;
//    g.gridy = 1;
//    this.add(nameField,g);

    g.ipady = 39;
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

    g.ipady = 20;
    g.ipadx = 40;



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
    //--------------------------------------- Preview Panel ---------------------------------------
    //---------------------------------------------------------------------------------------------

    //TODO: PREVIEW BUTTON needs to go in (2, 1) and (3, 1)

    previewPanel = new JPanel();
    previewPanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,
            Color.BLACK));

    //g.weightx = 0.0;

    g.gridheight = 2;
    g.gridx = 1;
    g.gridy = 2;
    g.ipady = 400;
    g.ipadx = panelWidth;

    //this.add(previewPanel, g);







    //---------------------------------------------------------------------------------------------
    //---------------------------------- Button Setup & Adding ------------------------------------
    //---------------------------------------------------------------------------------------------

    //Reset
    g.gridheight = 1;
//
    g.ipady = 20;
    g.ipadx = 40;
    // end reset


    previewButton = new JButton("Card Preview");
    previewButton.setActionCommand("previewButton");
    previewButton.setOpaque(true);
    previewButton.setBackground(MAIA_LOGO_COLOR);
    previewButton.setForeground(MAIA_BG_COLOR);
    previewButton.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));

    previewButton.addMouseListener(this);

    g.gridx = 1;
    g.gridy = 4;
    this.add(previewButton, g);


    chooseBackGroundImg = new JButton("Choose Background Image");
    chooseBackGroundImg.setActionCommand("chooseBGIMG");
    chooseBackGroundImg.setOpaque(true);
    chooseBackGroundImg.setBackground(MAIA_LOGO_COLOR);
    chooseBackGroundImg.setForeground(MAIA_BG_COLOR);
    chooseBackGroundImg.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));

    chooseBackGroundImg.addMouseListener(this);

    g.gridx = 0;
    g.gridy = 2;
    this.add(chooseBackGroundImg,g);

    chooseLogoImg = new JButton("Choose Logo Image");
    chooseLogoImg.setActionCommand("chooseLogoImage");
    chooseLogoImg.setOpaque(true);
    chooseLogoImg.setBackground(MAIA_LOGO_COLOR);
    chooseLogoImg.setForeground(MAIA_BG_COLOR);
    chooseLogoImg.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));

    chooseLogoImg.addMouseListener(this);

    g.gridx = 2;
    g.gridy = 2;
    this.add(chooseLogoImg,g);

    chooseHTML = new JButton("Choose HTML Files");
    chooseHTML.setActionCommand("chooseHTMLImage");
    chooseHTML.setOpaque(true);
    chooseHTML.setBackground(MAIA_LOGO_COLOR);
    chooseHTML.setForeground(MAIA_BG_COLOR);
    chooseHTML.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));

    chooseHTML.addMouseListener(this);

    g.gridx = 0;
    g.gridy = 3;
    this.add(chooseHTML,g);

    createHTML = new JButton("HTML Lab");
    createHTML.setActionCommand("HTMLLab");
    createHTML.setOpaque(true);
    createHTML.setBackground(MAIA_LOGO_COLOR);
    createHTML.setForeground(MAIA_BG_COLOR);
    createHTML.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));

    createHTML.addMouseListener(this);

    g.gridx = 2;
    g.gridy = 3;
    this.add(createHTML,g);


//    this.createCard = new JButton("Create Card");
//    createCard.setOpaque(true);
//    createCard.setBackground(MAIA_LOGO_COLOR);
//    createCard.setForeground(MAIA_BG_COLOR);
//    createCard.setBorder(BorderFactory.createBevelBorder(
//            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));
//    createCard.setActionCommand("createCardButton");
//
//    createCard.addMouseListener(this);
//
////    g.gridx = 1;
////    g.gridy = 4;
//    g.gridx = 1;
//    g.gridy = 1;
//    this.add(createCard,g);


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


  public JButton getChooseHTML() {
    return chooseHTML;
  }

  public JFileChooser getHtmlChooser() {
    return htmlChooser;
  }

  public JButton getCreateHTML() {
    return createHTML;
  }

  public JPanel getPreviewPanel() {
    return previewPanel;
  }

  public void setPreviewPanel(JPanel previewPanel) {
    this.previewPanel = previewPanel;
  }

  public JButton getPreviewButton() {
    return previewButton;
  }

  public ICard getPreviewCard() {
    return previewCard;
  }

  public void updateCard() {

    String type;
    String newComponent;



//    switch(type) {
//
//      case "name":
//
//        previewCard.setName(newComponent);
//
//        break;
//
//      case "title":
//
//        previewCard.setTitle(newComponent);
//
//        break;
//
//      case "pathName":
//
//        previewCard.setPathName(newComponent);
//
//        break;
//
//      case "description":
//
//        previewCard.setDescription(newComponent);
//
//        break;
//
//
//      default:
//        break;
//    }
    //this.remove(previewPanel);


    GridBagConstraints g = new GridBagConstraints();
    g.gridheight = 2;
    g.gridx = 1;
    g.gridy = 2;
    g.ipady = 400;
    g.ipadx = 266;


    JPanel newP = previewCard.createCard(previewCard.getName(), previewCard.getTitle(),
            previewCard.getPathName(), previewCard.getDescription());

    newP.setPreferredSize(new Dimension(272,500));
//    previewPanel = newP;

//    System.out.println("name: " + previewCard.getName());

    //previewPanel.setVisible(true);

    previewPanel = previewCard.createCard(previewCard.getName(), previewCard.getTitle(),
            previewCard.getPathName(), previewCard.getDescription());

    //newP.setVisible(true);
    //previewPanel.add(newP);
    //previewPanel.setVisible(true);


    JFrame previewFrame = new JFrame("Preview");
    previewFrame.setSize(new Dimension(500,500));
    //previewFrame.setPreferredSize(new Dimension(300,500));
    previewFrame.add(previewPanel);
    previewFrame.setVisible(true);
    //JOptionPane.



    //this.add(previewPanel, g);





  }

  public void whenPressedFeature(JButton b) {


    b.setOpaque(true);
    b.setBackground(MAIA_BG_COLOR);
    b.setForeground(MAIA_LOGO_COLOR);
    b.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.LOWERED, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR, MAIA_LOGO_COLOR,
            MAIA_LOGO_COLOR));


  }

  public void whenReleasedFeature(JButton b) {

    b.setOpaque(true);
    b.setBackground(MAIA_LOGO_COLOR);
    b.setForeground(MAIA_BG_COLOR);
    b.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));

  }

  public void whenEnteredFeature(JButton b) {

    //Color color = new Color(144, 175, 215);

    Color color = new Color(173, 216, 230);

    b.setOpaque(true);
    b.setBackground(color);
    b.setForeground(MAIA_BG_COLOR);
    b.setBorder(BorderFactory.createBevelBorder(
            BevelBorder.RAISED, MAIA_LOGO_COLOR, MAIA_BG_COLOR, MAIA_LOGO_COLOR, MAIA_BG_COLOR));

  }


  @Override
  public void mouseClicked(MouseEvent e) {

    // N/A

  }

  @Override
  public void mousePressed(MouseEvent e) {

    JButton source =((JButton)e.getSource());

    whenPressedFeature(source);

  }

  @Override
  public void mouseReleased(MouseEvent e) {

    JButton source =((JButton)e.getSource());

    whenReleasedFeature(source);

  }

  @Override
  public void mouseEntered(MouseEvent e) {

    JButton source =((JButton)e.getSource());

    whenEnteredFeature(source);

  }

  @Override
  public void mouseExited(MouseEvent e) {

    JButton source = ((JButton)e.getSource());

    whenReleasedFeature(source);

  }
}
