import javax.swing.*;

public class AdsImageIcon extends ImageIcon{
    private String fileName;
    private String hyperLink;
    
    public AdsImageIcon(String fileName, String hyperLink, byte[] imageBytes){
        super(imageBytes);
        this.fileName = fileName;
        this.hyperLink = hyperLink;
    }
    
    public String getFileName(){
        return fileName;
    }public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getHyperLink(){
        return hyperLink;
    }public void setHyperLink(String url){
        this.hyperLink = url;
    }
}