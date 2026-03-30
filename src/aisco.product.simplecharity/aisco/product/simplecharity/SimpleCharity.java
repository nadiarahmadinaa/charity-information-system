package aisco.product.simplecharity;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import java.util.ArrayList;
import java.util.List;

public class SimpleCharity {

    public static List<Program> addProgram() {
        System.out.println("\n Programs:");
        List<Program> programs = new ArrayList<>();
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                1, "Clean Water Access", "Provide clean water to rural villages", "500 families",
                "WaterAid Foundation", "https://simplecharity.id/logo/cleanwater"));
        programs.add(ProgramFactory.createProgram("aisco.program.activity.ProgramImpl",
                2, "Food Bank", "Weekly food distribution for underprivileged families", "200 families",
                "Local Government", "https://simplecharity.id/logo/foodbank"));
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "1", "01-03-2025", 5000000, "Corporate Donation ABC", programs.get(0), "11000"),
                "Transfer"));
        incomes.add(FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.income.FinancialReportImpl",
                FinancialReportFactory.createFinancialReport(
                        "aisco.financialreport.core.FinancialReportImpl",
                        "2", "05-03-2025", 2000000, "Public Donation", programs.get(1), "11000"),
                "Cash"));
        return incomes;
    }

    public static void main(String[] args) {
        System.out.println("Product: Simple Charity (No Gallery)");
        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).printHeader();
        System.out.println(incomes);
        int totalIncome = ((aisco.financialreport.income.FinancialReportImpl) incomes.get(0)).total(incomes);
        System.out.println("Total Income (after fee): " + totalIncome);
    }
}
