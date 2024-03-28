import javax.swing.*;

public class AdsImageIcon implements HasAdsDetails<ImageIcon>{
    private String fileName;
    private String hyperLink;
    private ImageIcon adsImage;
    
    public AdsImageIcon(String fileName, String hyperLink, byte[] imageBytes){
        this.adsImage = new ImageIcon(imageBytes);
        this.fileName = fileName;
        this.hyperLink = hyperLink;
    }
    
    @Override
    public String getFileName(){
        return fileName;
    }
    @Override
    public void setFileName(String name){
        this.fileName = name;
    }
    
    @Override
    public String getHyperLink(){
        return hyperLink;
    }
    @Override
    public void setHyperLink(String url){
        this.hyperLink = url;
    }
    
    @Override
    public ImageIcon getAdsImage(){
        return adsImage;
    }
    @Override
    public void setAdsImage(ImageIcon img){
        this.adsImage = img;
    }
}