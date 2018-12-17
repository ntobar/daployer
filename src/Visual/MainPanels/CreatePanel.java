package Visual.MainPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    this.setBackground(MAIA_BG_COLOR);


    Border border = BorderFactory.createMatteBorder(6, 3, 6, 6,
            MAIA_LOGO_COLOR);
    this.setBorder(BorderFactory.createTitledBorder(border,
            "Card Factory", 0, 0, Font.getFont(Font.DIALOG),
            MAIA_LOGO_COLOR));


    //TODO: fix name label erasing


    JLabel daployerLabel = new JLabel("<html><p><span color=#90C3F0 style=\""
            + "font-family: terminal, monaco; font-size: 36pt;\">>_ daployer </span></p>");

    Border daployerBorder = BorderFactory.createMatteBorder(3,3,3,3,
            MAIA_LOGO_COLOR);
    daployerLabel.setBorder(daployerBorder);

    this.add(daployerLabel);

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
    //------------------------------------Order Setup ---------------------------------------------
    //---------------------------------------------------------------------------------------------

    this.add(nameLabel);
    this.add(nameField);

    this.add(titleLabel);
    this.add(titleField);

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
    //------------------------------------Button Setup --------------------------------------------
    //---------------------------------------------------------------------------------------------

    chooseBackGroundImg = new JButton("Choose Background Image");
    chooseBackGroundImg.setActionCommand("chooseBGIMG");
    this.add(chooseBackGroundImg);

    chooseLogoImg = new JButton("Choose Logo Image");
    chooseLogoImg.setActionCommand("chooseLogoImage");
    this.add(chooseLogoImg);

    chooseHTML = new JButton("Choose HTML Files");
    chooseHTML.setActionCommand("chooseHTMLImage");
    this.add(chooseHTML);

    createHTML = new JButton("HTML Lab");
    createHTML.setActionCommand("HTMLLab");
    this.add(createHTML);


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

  public JButton getCreateHTML() {
    return createHTML;
  }
}
