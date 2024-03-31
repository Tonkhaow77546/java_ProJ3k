

import javax.swing.*;
import java.awt.*;

public class MainTest{
    public static void main(String[] args) {
        ChatJPanel chat = new ChatJPanel("localhost", "chat_test", "history", "admin", "1234", 1, "aom");
        ChatJPanel chat2 = new ChatJPanel("localhost", "chat_test", "history", "admin", "1234", 1, "handsome_aom");
        AdsUploaderPanel adsup = new AdsUploaderPanel("localhost", "ads_test", "ads_storage", "admin", "1234");
        AdsDownloaderPanel adspanel = new AdsDownloaderPanel("localhost", "ads_test", "ads_storage", "admin", "1234");
        
        JFrame frame = new JFrame("test");
        
        frame.setLayout(new GridLayout(2, 2));
        frame.add(chat);
        frame.add(chat2);
        frame.add(adsup);
        frame.add(adspanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}