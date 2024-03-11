import javax.swing.*;

public class AdsImageIcon extends ImageIcon{
    private final String fileName;
    private final String hyperLink;
    
    public AdsImageIcon(String fileName, String hyperLink, byte[] imageBytes){
        super(imageBytes);
        this.fileName = fileName;
        this.hyperLink = hyperLink;
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public String getAdsLink(){
        return hyperLink;
    }
}