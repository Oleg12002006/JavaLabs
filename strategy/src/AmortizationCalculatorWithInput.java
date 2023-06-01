import java.util.Scanner;

public class AmortizationCalculatorWithInput {
    private AmortizationStrategy strategy;

    public AmortizationCalculatorWithInput(AmortizationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AmortizationStrategy strategy) {
        this.strategy = strategy;
    }

    public void printAmortizationSchedule(double initialCost, int usefulLife) {
        double depreciationRate = strategy.calculateYearlyDepreciation(initialCost, usefulLife);
        double remainingCost = initialCost;

        System.out.println("Depreciation rate: " + depreciationRate);

        for (int year = 1; year <= usefulLife; year++) {
            double yearlyDepreciation = depreciationRate * remainingCost;
            remainingCost -= yearlyDepreciation;

            System.out.printf("Year %d: yearly depreciation=%.2f, remaining cost=%.2f\n", year, yearlyDepreciation, remainingCost);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial cost: ");
        double initialCost = scanner.nextDouble();

        System.out.print("Enter useful life: ");
        int usefulLife = scanner.nextInt();

        AmortizationStrategy linearAmortization = new LinearAmortization();
        AmortizationStrategy sumOfYearsDigitsAmortization = new SumOfYearsDigitsAmortization();

        AmortizationCalculatorWithInput calculator = new AmortizationCalculatorWithInput(linearAmortization);
        calculator.printAmortizationSchedule(initialCost, usefulLife);

        calculator.setStrategy(sumOfYearsDigitsAmortization);
        calculator.printAmortizationSchedule(initialCost, usefulLife);

        scanner.close();
    }
}