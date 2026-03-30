package aisco.gallery.core;

public class GalleryImpl extends GalleryComponent {

    public GalleryImpl(int idGallery, String title, String url, String mediaType, String uploadDate, String idProgram) {
        super(idGallery, title, url, mediaType, uploadDate, idProgram);
    }

    public void display() {
        System.out.println("  [" + mediaType + "] " + title);
        System.out.println("  URL     : " + url);
        System.out.println("  Date    : " + uploadDate);
        System.out.println("  Program : " + idProgram);
    }
}
