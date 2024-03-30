import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class AdsUploaderPanel extends JPanel implements ActionListener{
    private final JFileChooser fileChooser = new JFileChooser();
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("Image filter", "png", "jpg");
    private File selectedFile;
    
    private final JPanel infoPanel = new JPanel();
    private final JPanel idPanel = new JPanel();
    private final JPanel namePanel = new JPanel();
    private final JPanel linkPanel = new JPanel();
    private final JLabel idLabel = new JLabel("Ads id:");
    private final JLabel nameLabel = new JLabel("Name:");
    private final JLabel linkLabel = new JLabel("Link:");
    private final JTextField adsId = new JTextField();
    private final JTextField adsName = new JTextField();
    private final JTextField hyperLink = new JTextField();
    
    private final JPanel buttonPanel = new JPanel();
    private final JButton selectFile = new JButton("Select file");
    private final JButton upload = new JButton("Upload");
    
    private final AdsUploader adsUploader;
    public AdsUploaderPanel(String adress, String DBName, String DBTable, String SQLUserName, String SQLPassword){
        adsUploader = new AdsUploader(adress, DBName, DBTable, SQLUserName, SQLPassword);
        
        this.setPreferredSize(new Dimension(200, 200));
        this.setLayout(new BorderLayout());
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        
        infoPanel.setLayout(new GridLayout(3, 1));
        infoPanel.add(idPanel);
        infoPanel.add(namePanel);
        infoPanel.add(linkPanel);
        idPanel.setLayout(new BorderLayout());
        idPanel.add(idLabel, BorderLayout.WEST);
        idPanel.add(adsId, BorderLayout.CENTER);
        namePanel.setLayout(new BorderLayout());
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(adsName, BorderLayout.CENTER);
        linkPanel.setLayout(new BorderLayout());
        linkPanel.add(linkLabel, BorderLayout.WEST);
        linkPanel.add(hyperLink, BorderLayout.CENTER);
        
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
                    adsName.setText(selectedFile.getName());
                }
            }else if(ae.getSource().equals(upload)){
                try{
                    adsUploader.uploadAds(Integer.parseInt(adsId.getText()), selectedFile, hyperLink.getText());
                }catch(Exception e){
                    System.out.println(e);
                }finally{
                    adsId.setText("");
                    adsName.setText("");
                    hyperLink.setText("");
                    selectedFile = null;
                }
            }
        }
    }
}