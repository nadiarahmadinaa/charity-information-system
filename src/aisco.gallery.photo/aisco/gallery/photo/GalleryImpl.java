package aisco.gallery.photo;

import aisco.gallery.core.GalleryComponent;
import aisco.gallery.core.GalleryDecorator;

public class GalleryImpl extends GalleryDecorator {

    // delta adds attributes
    private String caption;
    private String photographer;

    // delta modifies constructor
    public GalleryImpl(GalleryComponent gallery, String caption, String photographer) {
        super(gallery);
        this.caption = caption;
        this.photographer = photographer;
    }

    // delta adds methods
    public String getCaption() { return caption; }
    public String getPhotographer() { return photographer; }

    // delta modifies display()
    public void display() {
        System.out.println("  [Photo] " + gallery.getTitle());
        System.out.println("  URL         : " + gallery.getUrl());
        System.out.println("  Caption     : " + caption);
        System.out.println("  Photographer: " + photographer);
        System.out.println("  Date        : " + gallery.getUploadDate());
        System.out.println("  Program ID  : " + gallery.getIdProgram());
    }

    public String toString() {
        return "- [Photo] " + gallery.getTitle() + " by " + photographer + " (" + gallery.getUploadDate() + ")";
    }
}
