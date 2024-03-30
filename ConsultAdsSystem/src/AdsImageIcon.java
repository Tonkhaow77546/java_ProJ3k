import javax.swing.*;
import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class AdsImageIcon extends ImageIcon{
    private String name;
    private String hyperLink;
    
    public AdsImageIcon(String name, String hyperLink, byte[] imageBytes){
        super();
        this.setImage(imgByteToImage(imageBytes));
        this.name = name;
        this.hyperLink = hyperLink;
    }
    
    private Image imgByteToImage(byte[] imageBytes){
        try{
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
            return img.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
        }catch(IOException e){
            return null;
        }
    }
    
    public String getFileName(){
        return name;
    }public void setFileName(String fileName){
        this.name = fileName;
    }
    public String getHyperLink(){
        return hyperLink;
    }public void setHyperLink(String url){
        this.hyperLink = url;
    }
}