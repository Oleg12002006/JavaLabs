public class Main {
    public static void main(String[] args) {
        AmortizationStrategy linearAmortization = new LinearAmortization();
        AmortizationStrategy sumOfYearsDigitsAmortization = new SumOfYearsDigitsAmortization();

        AmortizationCalculator calculator = new AmortizationCalculator(linearAmortization);
        calculator.printAmortizationSchedule(10000.0, 5);

        calculator.setStrategy(sumOfYearsDigitsAmortization);
        calculator.printAmortizationSchedule(10000.0, 5);
    }
}