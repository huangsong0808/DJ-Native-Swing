/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 * 
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */
package chrriis.dj.nativeswing.demo.examples.componentoptions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import chrriis.common.WebServer;
import chrriis.dj.nativeswing.demo.examples.flashplayer.SimpleFlashExample;
import chrriis.dj.nativeswing.ui.JFlashPlayer;
import chrriis.dj.nativeswing.ui.JWebBrowser;
import chrriis.dj.nativeswing.ui.NativeComponent;
import chrriis.dj.nativeswing.ui.NativeComponent.Options.Shaping;

/**
 * @author Christopher Deckers
 */
public class ShapingOptions extends JPanel {

  protected static final String LS = System.getProperty("line.separator");
  protected static final int OFFSET_X = 150;
  protected static final int OFFSET_Y = 120;
  protected static final int WIDTH = 200;
  protected static final int HEIGHT = 200;

  public ShapingOptions() {
    super(new BorderLayout(0, 0));
    JLayeredPane layeredPane = new JLayeredPane();
    int layerIndex = 0;
    // A flash player
    NativeComponent.getNextInstanceOptions().setShaping(Shaping.ENABLED);
    JFlashPlayer player = new JFlashPlayer();
    player.setControlBarVisible(false);
    String resourceURL = WebServer.getDefaultWebServer().getClassPathResourceURL(SimpleFlashExample.class.getName(), "resource/Movement-pointer_or_click.swf");
    player.setURL(resourceURL);
    player.setBounds(OFFSET_X * layerIndex, OFFSET_Y * layerIndex, WIDTH, HEIGHT);
    layeredPane.setLayer(player, layerIndex++);
    layeredPane.add(player);
    // A swing panel
    JPanel swingPanel = new JPanel();
    swingPanel.setBorder(BorderFactory.createTitledBorder("Swing JPanel"));
    swingPanel.setBackground(Color.CYAN);
    swingPanel.setBounds(OFFSET_X * layerIndex, OFFSET_Y * layerIndex, WIDTH, HEIGHT);
    layeredPane.setLayer(swingPanel, layerIndex++);
    layeredPane.add(swingPanel);
    // A web browser
    NativeComponent.getNextInstanceOptions().setShaping(Shaping.ENABLED);
    JWebBrowser webBrowser = new JWebBrowser();
    webBrowser.setBarsVisible(false);
    webBrowser.setStatusBarVisible(true);
    webBrowser.setText(
        "<html>" + LS +
        "  <body>" + LS +
        "    <h1>Some header</h1>" + LS +
        "    <p>A paragraph with a <a href=\"http://www.google.com\">link</a>.</p>" + LS +
        "  </body>" + LS +
        "</html>");
    webBrowser.setBounds(OFFSET_X * layerIndex, OFFSET_Y * layerIndex, WIDTH, HEIGHT);
    layeredPane.setLayer(webBrowser, layerIndex++);
    // A swing button
    JButton swingButton = new JButton("Swing JButton");
    swingButton.setBounds(OFFSET_X * layerIndex, OFFSET_Y * layerIndex, WIDTH, HEIGHT);
    layeredPane.setLayer(swingButton, layerIndex++);
    layeredPane.add(swingButton);
    layeredPane.add(webBrowser);
    layeredPane.setPreferredSize(new Dimension(WIDTH + OFFSET_X * (layerIndex - 1), HEIGHT + OFFSET_Y * (layerIndex - 1)));
    add(new JScrollPane(layeredPane), BorderLayout.CENTER);
  }
  
}