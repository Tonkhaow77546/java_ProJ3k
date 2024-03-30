import javax.swing.*;

public class AdsImageIcon extends ImageIcon{
    private String name;
    private String hyperLink;
    
    public AdsImageIcon(String name, String hyperLink, byte[] imageBytes){
        super(imageBytes);
        this.name = name;
        this.hyperLink = hyperLink;
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