package Visual;


import java.awt.*;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import Cards.ICard;
import Visual.MainPanels.CreatePanel;
import Visual.MainPanels.MyCardsPanel;


/**
 * Represents the Home View JFrame
 */
public class HomeView extends JFrame {
  private MenuPanel menuPanel;
  private CreatePanel createPanel;


  private MyCardsPanel myCardsPanel;
  private ICard card;
  private Color MAIA_BG_COLOR;
  private Color MAIA_LOGO_COLOR;



  //ICard card
  public HomeView() {
    super();


    this.setTitle("- daployer -");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setPreferredSize(new Dimension(1000,1000));

    this.MAIA_BG_COLOR = new Color(40,45,51);
    this.MAIA_LOGO_COLOR = new Color(144,195,240);

    //this.setBackground(MAIA_BG_COLOR);


    this.card = card;

    menuPanel = new MenuPanel();
    this.add(menuPanel, BorderLayout.WEST);

    createPanel = new CreatePanel();
    this.add(createPanel, BorderLayout.EAST);

    myCardsPanel = new MyCardsPanel();





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

  public ICard getCard() {
    return card;
  }

  public void setActionListener(ActionListener listen) {

    this.getMenuPanel().getMyCardsButton().addActionListener(listen);
    this.getMenuPanel().getCreateButton().addActionListener(listen);
    this.getMenuPanel().getExploreButton().addActionListener(listen);

    this.getCreatePanel().getChooseBackGroundImg().addActionListener(listen);




  }



}
