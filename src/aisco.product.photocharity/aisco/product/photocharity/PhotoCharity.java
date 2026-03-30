package aisco.product.photocharity;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import aisco.gallery.core.Gallery;
import aisco.gallery.core.GalleryComponent;
import aisco.gallery.GalleryFactory;
import java.util.ArrayList;
import java.util.List;

public class PhotoCharity {

    public static List<Program> addProgram() {
        System.out.println("\n Programs:");
        List<Program> programs = new ArrayList<>();
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                1, "Health Clinic Build", "Build a health clinic for remote village", "300 residents",
                "MedCare Foundation", "https://photocharity.id/logo/clinic"));
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                2, "School Renovation", "Renovate damaged school building", "400 students",
                "EduHelp NGO", "https://photocharity.id/logo/school"));
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "1", "10-03-2025", 10000000, "Grant from MedCare", programs.get(0), "11000"),
                "Transfer"));
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "2", "12-03-2025", 3000000, "Community Fundraising", programs.get(1), "11000"),
                "Cash"));
        return incomes;
    }

    public static List<Gallery> addPhotoGallery(List<Program> programs) {
        System.out.println("\n Photo Gallery:");
        List<Gallery> gallery = new ArrayList<>();

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.photo.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        1, "Clinic Foundation Laying", "https://photocharity.id/gallery/clinic_foundation.jpg",
                        "photo", "10-03-2025", "P001"),
                "Foundation laying ceremony attended by village elders", "Budi Santoso"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.photo.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        2, "School Wall Repair", "https://photocharity.id/gallery/school_wall.jpg",
                        "photo", "12-03-2025", "P002"),
                "Workers repairing the classroom walls", "Dewi Rahayu"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.photo.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        3, "Clinic Handover Ceremony", "https://photocharity.id/gallery/clinic_handover.jpg",
                        "photo", "20-03-2025", "P001"),
                "Official handover of clinic to village health committee", "Budi Santoso"));

        return gallery;
    }

    public static void main(String[] args) {
        System.out.println("Product: Photo Charity (Photo Gallery)");
        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).printHeader();
        System.out.println(incomes);
        int totalIncome = ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).total(incomes);
        System.out.println("Total Income (after fee): " + totalIncome);

        List<Gallery> photos = addPhotoGallery(programs);
        System.out.println(photos);
        System.out.println("\n Gallery Details:");
        for (Gallery g : photos) {
            g.display();
        }
    }
}
