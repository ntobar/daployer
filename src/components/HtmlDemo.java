

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package components;

/* HtmlDemo.java needs no other files. */

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class HtmlDemo extends JPanel
        implements ActionListener {
  JLabel theLabel;
  JTextArea htmlTextArea;





  public HtmlDemo() {

    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

    String initialText = "<html>\n" +
            "Color and font test:\n" +
            "<ul>\n" +
            "<li><font color=red>red</font>\n" +
            "<li><font color=blue>blue</font>\n" +
            "<li><font color=green>green</font>\n" +
            "<li><font size=-2>small</font>\n" +
            "<li><font size=+2>large</font>\n" +
            "<li><i>italic</i>\n" +
            "<li><b>bold</b>\n" +
            "</ul>\n";

    htmlTextArea = new JTextArea(20, 40);
    htmlTextArea.setText(initialText);
    JScrollPane scrollPane = new JScrollPane(htmlTextArea);

    JButton changeTheLabel = new JButton("Change the label");
    changeTheLabel.setMnemonic(KeyEvent.VK_C);
    //changeTheLabel.setAlignmentX(Component.TOP_ALIGNMENT);
    //changeTheLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    changeTheLabel.setActionCommand("changeTheLabel");
    changeTheLabel.addActionListener(this);

    JButton submitHTML = new JButton("Submit HTML");
    submitHTML.setActionCommand("submitHTML");
    //submitHTML.setAlignmentX(Component.BOTTOM_ALIGNMENT);
    submitHTML.addActionListener(this);

    JButton otherTemplate = new JButton("Want another Template?");
    otherTemplate.setActionCommand("otherTemplate");
    otherTemplate.addActionListener(this);


    theLabel = new JLabel(initialText) ;
//    {
//      public Dimension getPreferredSize() {
//        return new Dimension(200, 200);
//      }
//      public Dimension getMinimumSize() {
//        return new Dimension(200, 200);
//      }
//      public Dimension getMaximumSize() {
//        return new Dimension(200, 200);
//      }
//    };
    theLabel.setVerticalAlignment(SwingConstants.CENTER);
    theLabel.setHorizontalAlignment(SwingConstants.CENTER);
    theLabel.setPreferredSize(new Dimension(300,500));


    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
    leftPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                    "Edit the HTML, then click the button"),
            BorderFactory.createEmptyBorder(10,10,10,10)));
    leftPanel.add(scrollPane);
    leftPanel.add(Box.createRigidArea(new Dimension(0,10)));
    leftPanel.add(changeTheLabel);
    leftPanel.add(otherTemplate);
    leftPanel.add(submitHTML);

    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
    rightPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("A label with HTML"),
            BorderFactory.createEmptyBorder(10,10,10,10)));
    rightPanel.add(theLabel);

    setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    add(leftPanel);
    add(Box.createRigidArea(new Dimension(10,0)));
    add(rightPanel);

    //card = new dAppCard();

  }

  //React to the user pushing the Change button.
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("changeTheLabel")) {
      theLabel.setText(htmlTextArea.getText());
    } else if(e.getActionCommand().equals("otherTemplate")) {

      String newText = "<html>\n" +
              "<p>Never worry about knowing<br>HTML ever again</p>\n" +
              "<p>At last, you can simply write what you wish \n" +
              "and have it converted instantly!\n" +
              "<br>It is easier than ever to make a beautiful description.\n" +
              "Just input your text to see\n" +
              "<br>the magic happen." +
              "</p>\n" +
              " <ul>\n" +
              "  <li>\n" +
              "   <p>Text to HTML.\n" +
              "</p>\n" +
              "  </li>\n" +
              "  <li>\n" +
              "<p>Convert to HTML on the Go.</p>\n" +
              "  </li>\n" +
              "  <li>\n" +
              "<p>\n" +
              "Say goodbye to ugly product descriptions.\n" +
              "</p>\n</li>\n</ul>";

      htmlTextArea.setText(newText);
      theLabel.setText(htmlTextArea.getText());



    } else if(e.getActionCommand().equals("submitHTML")) {



      UIManager uI = new UIManager();
      uI.put("OptionPane.background", new ColorUIResource(144, 195, 240));
      uI.put("Panel.background", new ColorUIResource(40, 45, 51));

      String text = "<html> <span style='color:#90C3F0'>" +
              "Your HTML has been added to your Card </span></html>";
      JOptionPane.showMessageDialog(this,
              text,
              "HTML Confirmation", 0,
              new ImageIcon(
                      "/Users/nicolastobar/Desktop/daployer/src/Resources/maiaLOGO.png"));

      //card.setDescription(htmlTextArea.getText());



    }
  }

  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event dispatch thread.
   */
  public static void createAndShowGUI() {
    //Create and set up the window.

    JFrame frame = new JFrame("HtmlDemo");
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JButton exitGUI = new JButton("Submit and Exit");
    exitGUI.addActionListener(e -> {
     frame.dispose();
    });


    //Add content to the window.
    frame.add(new HtmlDemo());






    //Display the window.
    frame.pack();
    frame.setVisible(true);



  }



  public String giveHTML() {
    return theLabel.getText();
  }


  public static void main(String[] args) {
    //Schedule a job for the event dispatch thread:
    //creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
      }
    });
  }



}
