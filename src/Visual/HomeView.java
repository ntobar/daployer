package Visual;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import javax.swing.*;

import Cards.ICard;
import Cards.dAppCard;
import Visual.MainPanels.CreatePanel;
import Visual.MainPanels.ExplorePanel;
import Visual.MainPanels.MyCardsPanel;


/**
 * Represents the Home View JFrame
 */
public class HomeView extends JFrame {
  private MenuPanel menuPanel;
  private CreatePanel createPanel;
  private ExplorePanel explorePanel;
  private JPanel basePanel;


  private MyCardsPanel myCardsPanel;
  private ICard card;
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;


  public HomeView() {
    super();


    this.setTitle("- daployer -");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setPreferredSize(new Dimension(1000, 1000));

    this.MAIA_BG_COLOR = new Color(40, 45, 51);
    this.MAIA_LOGO_COLOR = new Color(144, 195, 240);

    //this.setBackground(MAIA_BG_COLOR);


    this.card = new dAppCard();

    menuPanel = new MenuPanel();
    this.add(menuPanel, BorderLayout.WEST);

    //this.setLayout(new CardLayout());

    basePanel = new JPanel(new CardLayout());
    this.add(basePanel, BorderLayout.EAST);


    //--------
    createPanel = new CreatePanel();
    //this.add(createPanel, BorderLayout.EAST);
    basePanel.add(createPanel, "createPanel");
    //basePanel.add(createPanel);

    myCardsPanel = new MyCardsPanel();
    basePanel.add(myCardsPanel, "myCardsPanel");
    //this.add(myCardsPanel, BorderLayout.EAST);
    //myCardsPanel.setVisible(false);

    explorePanel = new ExplorePanel();
    basePanel.add(explorePanel, "explorePanel");
    //this.add(explorePanel, BorderLayout.EAST);
    //explorePanel.setVisible(false);


    //Making it Visible
    this.pack();
    this.setVisible(true);

  }




  public MenuPanel getMenuPanel() {
    return menuPanel;
  }

  public CreatePanel getCreatePanel() {
    return createPanel;
  }

  public MyCardsPanel getMyCardsPanel() {
    return myCardsPanel;
  }

  public ExplorePanel getExplorePanel() {
    return explorePanel;
  }

  public JPanel getBasePanel() {
    return basePanel;
  }

  public ICard getCard() {
    return card;
  }

  public void setFocusListener(FocusListener fListen) {
    this.getCreatePanel().getNameField().addFocusListener(fListen);

    //this.getCreatePanel().getNameLabel().addFocusListener(fListen);

  }



  public void setActionListener(ActionListener listen) {

    this.getMenuPanel().getMyCardsButton().addActionListener(listen);
    this.getMenuPanel().getCreateButton().addActionListener(listen);
    this.getMenuPanel().getExploreButton().addActionListener(listen);

    this.getCreatePanel().getChooseBackGroundImg().addActionListener(listen);

    this.getCreatePanel().getCreateCard().addActionListener(listen);
    this.getCreatePanel().getChooseLogoImg().addActionListener(listen);
    this.getCreatePanel().getChooseHTML().addActionListener(listen);
    this.getCreatePanel().getCreateHTML().addActionListener(listen);

    this.getCreatePanel().getPreviewButton().addActionListener(listen);


  }


}
