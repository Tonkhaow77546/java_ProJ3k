public interface HasAdsDetails<O>{
    public String getFileName();
    public void setFileName(String name);
    public String getHyperLink();
    public void setHyperLink(String url);
    public O getAdsImage();
    public void setAdsImage(O img);
}