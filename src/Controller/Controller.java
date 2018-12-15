package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import Visual.HomeView;
import components.HtmlDemo;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Controller implements IController {
  private HomeView homeView;


  public Controller(HomeView homeView) {

    this.homeView = homeView;
    this.homeView.setActionListener(this);

  }


  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals("createButton")) {


      CardLayout cl = (CardLayout) (homeView.getBasePanel().getLayout());
      cl.show(homeView.getBasePanel(), "createPanel");

//      if(!(homeView.getCreatePanel().isVisible())) {
//        homeView.makeInvisible(homeView.getMenuPanel(), homeView.getExplorePanel());
//        homeView.getCreatePanel().setVisible(true);
//
//      }


//      homeView.getMyCardsPanel().setVisible(true);
//      homeView.makeInvisible(homeView.getCreatePanel(),homeView.getExplorePanel());


      //homeView.add(homeView.getMyCardsPanel(), BorderLayout.EAST);


    } else if (e.getActionCommand().equals("myCardsButton")) {


      CardLayout cl = (CardLayout) (homeView.getBasePanel().getLayout());

      cl.show(homeView.getBasePanel(), "myCardsPanel");


    } else if (e.getActionCommand().equals("exploreButton")) {


      CardLayout cl = (CardLayout) (homeView.getBasePanel().getLayout());
      cl.show(homeView.getBasePanel(), "explorePanel");


    } else if (e.getActionCommand().equals("createCardButton")) {

      String cardName = homeView.getCreatePanel().getCard().getName();
      String cardTitle = homeView.getCreatePanel().getCard().getTitle();
      String pathName = homeView.getCreatePanel().getCard().getPathName();
      String description = homeView.getCreatePanel().getCard().getDescription();

      String errorMsg1 = "<html> <span style='color:#90C3F0'>" +
              "Please fill in the Card Name field and Card Title field </span></html>";
      String errorMsg2 = "<html> <span style='color:#90C3F0'>" +
              "Are you sure you want to create a Card with no images or description? </span></html>";


      UIManager uI = new UIManager();
      uI.put("OptionPane.background", new ColorUIResource(144, 195, 240));
      uI.put("Panel.background", new ColorUIResource(40, 45, 51));

      ImageIcon MAIA_ERROR_MSG = new ImageIcon(
              "/Users/nicolastobar/Desktop/daployer/src/Resources/maiaLOGO.png");


      if(cardName.equals("") || cardTitle.equals("")) {
        JOptionPane.showMessageDialog(this.homeView, errorMsg1, "Error",
                JOptionPane.ERROR_MESSAGE, MAIA_ERROR_MSG);
      } else if (pathName.equals("") || description.equals("")) {

          int dialogButton = JOptionPane.YES_NO_OPTION;


          int dialogResult = JOptionPane.showConfirmDialog(null,
                  errorMsg2, "Warning", dialogButton, JOptionPane.WARNING_MESSAGE, MAIA_ERROR_MSG);

          if (dialogResult == JOptionPane.YES_OPTION) {


            JPanel newCard = homeView.getCreatePanel().getCard().createCard(cardName, cardTitle,
                    pathName, description);


//      JPanel newCard = homeView.getCreatePanel().getCard().createCard(cardName, cardTitle, pathName);
            //JPanel newCard = homeView.getCard().createCard(homeView.getCard().getName(), "Card1");
            homeView.getMyCardsPanel().add(newCard);
          } else {

            JPanel newCard = homeView.getCreatePanel().getCard().createCard(cardName, cardTitle,
                    pathName, description);


//      JPanel newCard = homeView.getCreatePanel().getCard().createCard(cardName, cardTitle, pathName);
            //JPanel newCard = homeView.getCard().createCard(homeView.getCard().getName(), "Card1");
            homeView.getMyCardsPanel().add(newCard);
          }



      }




    } else if (e.getActionCommand().equals("chooseBGIMG")) {


      int returnVal = homeView.getCreatePanel().getBackgroundImgChooser().showOpenDialog(homeView);

      if (returnVal == JFileChooser.APPROVE_OPTION) {

        File file = homeView.getCreatePanel().getBackgroundImgChooser().getSelectedFile();

        homeView.getCreatePanel().getCard().setPathName(file.getPath());
        //homeView.getCreatePanel().getCard().set


          //homeView.getCreatePanel().getCard().setBackgroundImage(file.getPath());


        log.append("Opening: " + file.getName() + "." + "\n");
      } else {
        log.append("Open command cancelled by user." + "/n");
      }


    } else if (e.getActionCommand().equals("chooseLogoImage")) {


      int returnVal = homeView.getCreatePanel().getLogoImgChooser().showOpenDialog(homeView);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = homeView.getCreatePanel().getLogoImgChooser().getSelectedFile();

        log.append("Opening: " + file.getName() + "." + "\n");
      } else {
        log.append("Open command cancelled by user." + "/n");
      }


    } else if (e.getActionCommand().equals("chooseHTMLImage")) {


      int returnVal = homeView.getCreatePanel().getHtmlChooser().showOpenDialog(homeView);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = homeView.getCreatePanel().getHtmlChooser().getSelectedFile();

        log.append("Opening: " + file.getName() + "." + "\n");
      } else {
        log.append("Open command cancelled by user." + "/n");
      }


    } else if (e.getActionCommand().equals("HTMLLab")) {


      HtmlDemo html = new HtmlDemo();
      homeView.getCreatePanel().getCard().setDescription(html.giveHTML());
      System.out.println(html.giveHTML());
      html.createAndShowGUI();
      //this.homeView.getCreatePanel().add(html);


    }
  }


}
