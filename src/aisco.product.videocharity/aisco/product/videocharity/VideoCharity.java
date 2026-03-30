package aisco.product.videocharity;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import aisco.gallery.core.Gallery;
import aisco.gallery.GalleryFactory;
import java.util.ArrayList;
import java.util.List;

public class VideoCharity {

    public static List<Program> addProgram() {
        System.out.println("\n Programs:");
        List<Program> programs = new ArrayList<>();
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                1, "Tree Planting Campaign", "Plant 10,000 trees in deforested areas", "local ecosystem",
                "GreenEarth Community", "https://videocharity.id/logo/trees"));
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                2, "Youth Skill Training", "Vocational training for unemployed youth", "150 youth",
                "SkillUp Foundation", "https://videocharity.id/logo/training"));
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "1", "01-03-2025", 8000000, "CSR Donation XYZ Corp", programs.get(0), "11000"),
                "Transfer"));
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "2", "03-03-2025", 4500000, "Youth Fund Grant", programs.get(1), "11000"),
                "Transfer"));
        return incomes;
    }

    public static List<Gallery> addVideoGallery(List<Program> programs) {
        System.out.println("\n Video Gallery:");
        List<Gallery> gallery = new ArrayList<>();

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.video.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        1, "Tree Planting Day Documentary", "https://videocharity.id/gallery/treeplanting.mp4",
                        "video", "05-03-2025", "P001"),
                "15:30", "MP4"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.video.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        2, "Youth Training Workshop Recap", "https://videocharity.id/gallery/workshop.mp4",
                        "video", "10-03-2025", "P002"),
                "08:45", "MP4"));

        gallery.add(GalleryFactory.createGallery(
                "aisco.gallery.video.GalleryImpl",
                GalleryFactory.createGallery("aisco.gallery.core.GalleryImpl",
                        3, "Graduation Ceremony Highlights", "https://videocharity.id/gallery/graduation.mp4",
                        "video", "25-03-2025", "P002"),
                "05:00", "MP4"));

        return gallery;
    }

    public static void main(String[] args) {
        System.out.println("Product: Video Charity (Video Gallery)");
        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).printHeader();
        System.out.println(incomes);
        int totalIncome = ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).total(incomes);
        System.out.println("Total Income (after fee): " + totalIncome);

        List<Gallery> videos = addVideoGallery(programs);
        System.out.println(videos);
        System.out.println("\n Gallery Details:");
        for (Gallery g : videos) {
            g.display();
        }
    }
}
