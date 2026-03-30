package aisco.gallery.video;

import aisco.gallery.core.GalleryComponent;
import aisco.gallery.core.GalleryDecorator;

public class GalleryImpl extends GalleryDecorator {

    // delta adds attributes
    private String duration;
    private String videoFormat;

    // delta modifies constructor
    public GalleryImpl(GalleryComponent gallery, String duration, String videoFormat) {
        super(gallery);
        this.duration = duration;
        this.videoFormat = videoFormat;
    }

    // delta adds methods
    public String getDuration() { return duration; }
    public String getVideoFormat() { return videoFormat; }

    // delta modifies display()
    public void display() {
        System.out.println("  [Video] " + gallery.getTitle());
        System.out.println("  URL    : " + gallery.getUrl());
        System.out.println("  Format : " + videoFormat);
        System.out.println("  Dur    : " + duration);
        System.out.println("  Date   : " + gallery.getUploadDate());
        System.out.println("  Program: " + gallery.getIdProgram());
    }

    public String toString() {
        return "- [Video] " + gallery.getTitle() + " (" + duration + ", " + videoFormat + ") (" + gallery.getUploadDate() + ")";
    }
}
