package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import javax.swing.*;

import Visual.HomeView;

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



      CardLayout cl = (CardLayout)(homeView.getBasePanel().getLayout());
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




      //TODO: Call card.createCard()



    } else if (e.getActionCommand().equals("chooseBGIMG")) {




      int returnVal = homeView.getCreatePanel().getBackgroundImgChooser().showOpenDialog(homeView);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = homeView.getCreatePanel().getBackgroundImgChooser().getSelectedFile();
        //This is where a real application would open the file.
        log.append("Opening: " + file.getName() + "." + "\n");
      } else {
        log.append("Open command cancelled by user." + "/n");
      }


    }


  }


}
