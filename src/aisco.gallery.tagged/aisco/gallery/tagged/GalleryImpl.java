package aisco.gallery.tagged;

import aisco.gallery.core.GalleryComponent;
import aisco.gallery.core.GalleryDecorator;

public class GalleryImpl extends GalleryDecorator {

    // delta adds attribute
    private String tags;

    // delta modifies constructor
    public GalleryImpl(GalleryComponent gallery, String tags) {
        super(gallery);
        this.tags = tags;
    }

    // delta adds method
    public String getTags() { return tags; }

    // delta modifies display() - adds tag information on top of wrapped gallery
    public void display() {
        gallery.display();
        System.out.println("  Tags   : " + tags);
    }

    public String toString() {
        return gallery.toString() + " [Tags: " + tags + "]";
    }
}
