package aisco.product.fullgallery;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import aisco.gallery.core.Gallery;
import aisco.gallery.core.GalleryComponent;
import aisco.gallery.GalleryFactory;
import java.util.ArrayList;
import java.util.List;

public class FullGallery {

    public static List<Program> addProgram() {
        System.out.println("\n Programs:");
        List<Program> programs = new ArrayList<>();
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                1, "Disaster Relief", "Emergency aid distribution after flood disaster", "1000 victims",
                "Relief Alliance", "https://fullgallery.id/logo/disaster"));
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                2, "Scholarship Program", "Annual scholarship for underprivileged students", "50 students",
                "EduFund Indonesia", "https://fullgallery.id/logo/scholarship"));
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "1", "01-03-2025", 20000000, "Emergency Grant - Government", programs.get(0), "11000"),
                "Transfer"));
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "2", "05-03-2025", 5000000, "Scholarship Fund Donation", programs.get(1), "11000"),
                "Transfer"));
        return incomes;
    }

    public static List<Gallery> addPhotoGallery(List<Program> programs) {
        System.out.println("\n Photo Gallery:");
        List<Gallery> gallery = new ArrayList<>();

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.photo.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        1, "Aid Tent Setup", "https://fullgallery.id/gallery/tent_setup.jpg",
                        "photo", "01-03-2025", "P001"),
                "Volunteers setting up emergency aid distribution tents", "Eko Prasetyo"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.photo.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        2, "Scholarship Award Ceremony", "https://fullgallery.id/gallery/scholarship.jpg",
                        "photo", "10-03-2025", "P002"),
                "Students receiving scholarship certificates from foundation director", "Rina Wati"));

        return gallery;
    }

    public static List<Gallery> addVideoGallery(List<Program> programs) {
        System.out.println("\n Video Gallery:");
        List<Gallery> gallery = new ArrayList<>();

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.video.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        3, "Flood Relief Documentary", "https://fullgallery.id/gallery/flood_relief.mp4",
                        "video", "03-03-2025", "P001"),
                "22:10", "MP4"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.video.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        4, "Scholar Testimonials", "https://fullgallery.id/gallery/scholar_testimonials.mp4",
                        "video", "12-03-2025", "P002"),
                "10:30", "MP4"));

        return gallery;
    }

    public static List<Gallery> addTaggedGallery(List<Program> programs) {
        System.out.println("\n Tagged Gallery:");
        List<Gallery> gallery = new ArrayList<>();

        // Tagged photo
        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.tagged.GalleryImpl",
                (GalleryComponent) GalleryFactory.createGallery(
                        "aisco.gallery.photo.GalleryImpl",
                        GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                                5, "Food Package Distribution", "https://fullgallery.id/gallery/food_pkg.jpg",
                                "photo", "02-03-2025", "P001"),
                        "Families receiving emergency food packages at relief center", "Eko Prasetyo"),
                "disaster, food, relief, emergency"));

        // Tagged video
        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.tagged.GalleryImpl",
                (GalleryComponent) GalleryFactory.createGallery(
                        "aisco.gallery.video.GalleryImpl",
                        GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                                6, "Scholarship Impact Stories", "https://fullgallery.id/gallery/impact.mp4",
                                "video", "20-03-2025", "P002"),
                        "05:45", "MP4"),
                "scholarship, education, impact, youth"));

        return gallery;
    }

    public static void main(String[] args) {
        System.out.println("Product: Full Gallery (Photo + Video + Tagged)");
        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).printHeader();
        System.out.println(incomes);
        int totalIncome = ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).total(incomes);
        System.out.println("Total Income (after fee): " + totalIncome);

        List<Gallery> photos = addPhotoGallery(programs);
        System.out.println(photos);
        System.out.println("\n Photo Gallery Details:");
        for (Gallery g : photos) { g.display(); }

        List<Gallery> videos = addVideoGallery(programs);
        System.out.println(videos);
        System.out.println("\n Video Gallery Details:");
        for (Gallery g : videos) { g.display(); }

        List<Gallery> tagged = addTaggedGallery(programs);
        System.out.println(tagged);
        System.out.println("\n Tagged Gallery Details:");
        for (Gallery g : tagged) { g.display(); }
    }
}
