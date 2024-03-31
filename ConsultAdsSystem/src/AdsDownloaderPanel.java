

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class AdsDownloaderPanel extends JPanel implements MouseListener{
    private AdsDownloader downloader;
    
    private ArrayList<AdsImageIcon> imageIconArray;
    private ArrayList<JLabel> adsLabelArray = new ArrayList();
    
    private CardLayout cd = new CardLayout();
    
    private Thread workingThread;
    
    public AdsDownloaderPanel(String adress, String DBName, String DBTable, String SQLUserName, String SQLPassword){
        downloader = new AdsDownloader(adress, DBName, DBTable, SQLUserName, SQLPassword);
        this.setLayout(cd);
        adsLabelArray.removeAll(adsLabelArray);
        if (downloader.isConnectoinReady() && downloader.isTableReady()){
            imageIconArray = downloader.dowloadAds();
            for (AdsImageIcon adsImage : imageIconArray){
                JLabel adsLabel = new JLabel(adsImage);
                adsLabel.addMouseListener(this);
                adsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                adsLabelArray.add(adsLabel);
            }
        }
        for (JLabel eachAds : adsLabelArray){
            this.add(eachAds);
        }
        workingThread = new Thread(new ThreadHelperAds(this));
        workingThread.start();
    }
    
    public void adsNext(){
        cd.next(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        try{
            System.out.println("Trying to open URI...");
            JLabel clickedAds = (JLabel)me.getSource();
            AdsImageIcon adsImage = (AdsImageIcon)clickedAds.getIcon();
            Desktop.getDesktop().browse(new URI(adsImage.getHyperLink()));
            System.out.println("URI opened!!!");
        }catch(IOException | URISyntaxException e){
            System.out.println("###Failed to open URI###");
            System.out.println(e);
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent me){
        
    }
    
    @Override
    public void mouseExited(MouseEvent me){
        
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}

class ThreadHelperAds implements Runnable{
    private AdsDownloaderPanel adsPanel;
    public ThreadHelperAds(AdsDownloaderPanel adsPanel){
        this.adsPanel = adsPanel;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(5000);
                adsPanel.adsNext();
            }catch(InterruptedException ie){
                System.out.println("###Ads next interrupted###");
                System.out.println(ie);
            }
            
        }
    }
}
    
        