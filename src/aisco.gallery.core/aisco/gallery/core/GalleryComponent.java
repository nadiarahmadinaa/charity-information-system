package aisco.gallery.core;

public abstract class GalleryComponent implements Gallery {

    protected int idGallery;
    protected String title;
    protected String url;
    protected String mediaType;
    protected String uploadDate;
    protected String idProgram;

    public GalleryComponent() {}

    public GalleryComponent(int idGallery, String title, String url, String mediaType, String uploadDate, String idProgram) {
        this.idGallery = idGallery;
        this.title = title;
        this.url = url;
        this.mediaType = mediaType;
        this.uploadDate = uploadDate;
        this.idProgram = idProgram;
    }

    public int getIdGallery() { return idGallery; }
    public String getTitle() { return title; }
    public String getUrl() { return url; }
    public String getMediaType() { return mediaType; }
    public String getUploadDate() { return uploadDate; }
    public String getIdProgram() { return idProgram; }

    public String toString() {
        return "- [" + mediaType + "] " + title + " (" + uploadDate + ")";
    }

    public abstract void display();
}
