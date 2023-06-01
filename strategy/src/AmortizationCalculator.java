interface AmortizationStrategy {
    double calculateYearlyDepreciation(double initialCost, int usefulLife);
}

class LinearAmortization implements AmortizationStrategy {
    @Override
    public double calculateYearlyDepreciation(double initialCost, int usefulLife) {
        double depreciationRate = 1.0 / usefulLife;
        double yearlyDepreciation = initialCost * depreciationRate;
        return yearlyDepreciation;
    }
}

class SumOfYearsDigitsAmortization implements AmortizationStrategy {
    @Override
    public double calculateYearlyDepreciation(double initialCost, int usefulLife) {
        double sumOfDigits = (usefulLife * (usefulLife + 1)) / 2.0;
        double yearlyDepreciation = initialCost * ((usefulLife + 1.0) / 2.0) / sumOfDigits;
        return yearlyDepreciation;
    }
}

public class AmortizationCalculator {
    private AmortizationStrategy strategy;

    public AmortizationCalculator(AmortizationStrategy strategy) {
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
}
