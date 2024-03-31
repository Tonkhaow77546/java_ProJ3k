

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class AdsUploaderPanel extends JPanel implements ActionListener{
    private final JFileChooser fileChooser = new JFileChooser();
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file", "jpg");
    private File selectedFile;
    
    private final JPanel infoPanel = new JPanel();
    private final JPanel idPanel = new JPanel();
    private final JPanel linkPanel = new JPanel();
    private final JLabel idLabel = new JLabel("Ads id:");
    private final JLabel linkLabel = new JLabel("Link:");
    private final JTextField adsId = new JTextField(25);
    private final JTextField hyperLink = new JTextField(25);
    private final JLabel adsPreview = new JLabel();
    
    private final JPanel buttonPanel = new JPanel();
    private final JButton selectFile = new JButton("Select file");
    private final JButton upload = new JButton("Upload");
    
    private final AdsUploader adsUploader;
    public AdsUploaderPanel(String adress, String DBName, String DBTable, String SQLUserName, String SQLPassword){
        adsUploader = new AdsUploader(adress, DBName, DBTable, SQLUserName, SQLPassword);
        
        this.setPreferredSize(new Dimension(200, 200));
        this.setLayout(new BorderLayout());
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(adsPreview, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        
        infoPanel.setLayout(new FlowLayout());
        infoPanel.add(idPanel);
        infoPanel.add(linkPanel);
        idPanel.setLayout(new FlowLayout());
        idPanel.add(idLabel);
        idPanel.add(adsId);
        linkPanel.setLayout(new FlowLayout());
        linkPanel.add(linkLabel);
        linkPanel.add(hyperLink);
        
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(selectFile);
        buttonPanel.add(upload);
        
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("."));
        
        selectFile.addActionListener(this);
        upload.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (adsUploader.isConnectoinReady() && adsUploader.isTableReady()){
            if (ae.getSource().equals(selectFile)){
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION){
                    selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    try{
                        FileInputStream fis = new FileInputStream(selectedFile);
                        adsPreview.setIcon(new ImageIcon(AdsImageIcon.imgByteToImage(fis.readAllBytes())));
                    }catch(IOException ie){
                        System.out.println("cant show preview ads");
                        System.out.println(ie);
                    }
                    
                }
            }else if(ae.getSource().equals(upload)){
                try{
                    adsUploader.uploadAds(Integer.parseInt(adsId.getText()), selectedFile, hyperLink.getText());
                    adsPreview.setIcon(null);
                }catch(Exception e){
                    System.out.println(e);
                }finally{
                    adsId.setText("");
                    hyperLink.setText("");
                    selectedFile = null;
                }
            }
        }
    }
}