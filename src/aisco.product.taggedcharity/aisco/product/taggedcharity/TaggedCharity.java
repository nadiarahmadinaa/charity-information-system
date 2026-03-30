package aisco.product.taggedcharity;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import aisco.gallery.core.Gallery;
import aisco.gallery.core.GalleryComponent;
import aisco.gallery.GalleryFactory;
import java.util.ArrayList;
import java.util.List;

public class TaggedCharity {

    public static List<Program> addProgram() {
        System.out.println("\n Programs:");
        List<Program> programs = new ArrayList<>();
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                1, "Orphanage Support", "Monthly supply of food and clothing to orphanage", "120 children",
                "CareKids Foundation", "https://taggedcharity.id/logo/orphanage"));
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                2, "Elderly Care Program", "Weekly visit and health checkup for elderly", "80 elders",
                "ElderCare Society", "https://taggedcharity.id/logo/elderly"));
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "1", "02-03-2025", 6000000, "Monthly Corporate Donor", programs.get(0), "11000"),
                "Transfer"));
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "2", "04-03-2025", 1500000, "Community Collection", programs.get(1), "11000"),
                "Cash"));
        return incomes;
    }

    public static List<Gallery> addTaggedGallery(List<Program> programs) {
        System.out.println("\n Tagged Photo Gallery:");
        List<Gallery> gallery = new ArrayList<>();

        // Tagged photo: photo gallery wrapped with tags
        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.tagged.GalleryImpl",
                (GalleryComponent) GalleryFactory.createGallery(
                        "aisco.gallery.photo.GalleryImpl",
                        GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                                1, "Children Meal Distribution", "https://taggedcharity.id/gallery/meal.jpg",
                                "photo", "02-03-2025", "P001"),
                        "Children receiving nutritious meals at the orphanage", "Sari Dewi"),
                "orphanage, food, children, nutrition"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.tagged.GalleryImpl",
                (GalleryComponent) GalleryFactory.createGallery(
                        "aisco.gallery.photo.GalleryImpl",
                        GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                                2, "Elder Health Checkup", "https://taggedcharity.id/gallery/elderly_check.jpg",
                                "photo", "08-03-2025", "P002"),
                        "Volunteer doctors checking blood pressure of elderly residents", "Ahmad Fauzi"),
                "elderly, health, volunteer, medical"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.tagged.GalleryImpl",
                (GalleryComponent) GalleryFactory.createGallery(
                        "aisco.gallery.photo.GalleryImpl",
                        GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                                3, "Clothing Donation", "https://taggedcharity.id/gallery/clothing.jpg",
                                "photo", "15-03-2025", "P001"),
                        "Volunteers sorting donated clothing for the children", "Sari Dewi"),
                "orphanage, clothing, donation, volunteer"));

        return gallery;
    }

    public static void main(String[] args) {
        System.out.println("Product: Tagged Charity (Tagged Photo Gallery)");
        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).printHeader();
        System.out.println(incomes);
        int totalIncome = ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).total(incomes);
        System.out.println("Total Income (after fee): " + totalIncome);

        List<Gallery> tagged = addTaggedGallery(programs);
        System.out.println(tagged);
        System.out.println("\n Gallery Details:");
        for (Gallery g : tagged) {
            g.display();
        }
    }
}
