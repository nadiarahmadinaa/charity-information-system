package aisco.gallery.core;

public abstract class GalleryDecorator extends GalleryComponent {

    public GalleryComponent gallery;

    public GalleryDecorator(GalleryComponent gallery) {
        this.gallery = gallery;
    }

    public int getIdGallery() { return gallery.getIdGallery(); }
    public String getTitle() { return gallery.getTitle(); }
    public String getUrl() { return gallery.getUrl(); }
    public String getMediaType() { return gallery.getMediaType(); }
    public String getUploadDate() { return gallery.getUploadDate(); }
    public String getIdProgram() { return gallery.getIdProgram(); }

    public void display() { gallery.display(); }

    public String toString() { return gallery.toString(); }
}
