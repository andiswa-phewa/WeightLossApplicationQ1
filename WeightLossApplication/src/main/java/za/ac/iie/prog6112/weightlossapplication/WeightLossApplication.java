/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package za.ac.iie.prog6112.weightlossapplication;
// Allows us to create our own number format.
// We will use this to control how many decimal places are shown.
import java.text.DecimalFormat;
// Gives us the NumberFormat type that will store
// the formatting rules we create using DecimalFormat.
import java.text.NumberFormat;

public class WeightLossApplication {

    /*
     * One-dimensional array containing
     * the names of the three gyms.
     *
     * private:
     * Only this class needs direct access to it.
     *
     * static:
     * It belongs to the class and can be used
     * by our static methods.
     *
     * final:
     * We do not intend to replace this array
     * while the program is running.
     */
    private static final String[] gym = {
        "GYM 1",
        "GYM 2",
        "GYM 3"
    };


    /*
     * Two-dimensional array containing
     * the weight-loss values.
     *
     * ROWS represent gyms.
     * COLUMNS represent months.
     *
     * Row 0 = GYM 1
     * Row 1 = GYM 2
     * Row 2 = GYM 3
     *
     * Column 0 = Month 1
     * Column 1 = Month 2
     * Column 2 = Month 3
     */
    private static final double[][] weightLoss = {

        {10, 20, 27},     // GYM 1
        {22, 5, 20},      // GYM 2
        {30, 20, 10}      // GYM 3
    };


    /*
     * Used for values that do not need
     * decimal places.
     *
     * Example: 57 instead of 57.0
     */
    private static final NumberFormat formatter =
            new DecimalFormat("#0");


    /*
     * Used for average values.
     *
     * It displays two decimal places.
     *
     * Example: 19.00
     */
    private static final NumberFormat avgFormatter =
            new DecimalFormat("#0.00");


    /*
     * Java starts running the program here.
     */
    public static void main(String[] args) {

        System.out.println(
                "GYM WEIGHTLOSS APPLICATION");

        /*
         * Call the method that displays
         * the table and calculations.
         */
        populateAndPrintData();
    }


    /*
     * This method prints the entire table.
     *
     * It is void because it performs
     * an action rather than returning a value.
     */
    private static void populateAndPrintData() {

        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------");


        /*
         * Print the column headings.
         */
        System.out.print("\t\tMONTH 1\t\t");
        System.out.print("MONTH 2\t\t");
        System.out.print("MONTH 3\t\t");
        System.out.print("| TOTAL\t\t");
        System.out.print("AVG\t\t");
        System.out.print("MIN\t\t");
        System.out.print("MAX\t\t");

        System.out.println();


      System.out.println(
                "-------------------------------------------------------------------------------------------------------------------");


        /*
         * OUTER LOOP
         *
         * Each row represents one gym.
         */
        for (int row = 0;
             row < weightLoss.length;
             row++) {


            /*
             * Print the gym name.
             *
             * row 0 = GYM 1
             * row 1 = GYM 2
             * row 2 = GYM 3
             */
            System.out.print(
                    gym[row] + "\t\t");


            /*
             * INNER LOOP
             *
             * Move through the three months
             * belonging to the current gym.
             */
            for (int column = 0;
                 column < gym.length;
                 column++) {


                /*
                 * row tells us which gym.
                 * column tells us which month.
                 */
                System.out.print(
                        formatter.format(
                                weightLoss[row][column])
                        + "kg\t\t");
            }


            /*
             * Separate the monthly values
             * from the calculations.
             */
            System.out.print("| ");


            /*
             * Calculate and display the total
             * for the current gym.
             */
            System.out.print(
                    formatter.format(
                            calculateTotal(row))
                    + "kg\t\t");


            /*
             * Calculate and display the average.
             */
            System.out.print(
                    avgFormatter.format(
                            calculateAverage(row))
                    + "kg\t\t");


            /*
             * Calculate and display
             * the minimum value.
             */
            System.out.print(
                    formatter.format(
                            calculateMin(row))
                    + "kg\t\t");


            /*
             * Calculate and display
             * the maximum value.
             */
            System.out.print(
                    formatter.format(
                            calculateMax(row))
                    + "kg\t\t");


            /*
             * Move to the next line before
             * displaying the next gym.
             */
            System.out.println();
        }
    }


    /*
     * Calculate the TOTAL for one gym.
     *
     * position represents the gym row:
     *
     * 0 = GYM 1
     * 1 = GYM 2
     * 2 = GYM 3
     */
    private static double calculateTotal(
            int position) {

        /*
         * Start at zero because we have
         * not added any values yet.
         */
        double total = 0.0;


        /*
         * Move through each month
         * belonging to the selected gym.
         */
        for (int month = 0;
             month < weightLoss[position].length;
             month++) {


            /*
             * Add the current month's
             * weight loss to the running total.
             */
            total =
                    total
                    + weightLoss[position][month];
        }


        /*
         * Send the result back.
         */
        return total;
    }


    /*
     * Calculate the AVERAGE for one gym.
     */
    private static double calculateAverage(
            int position) {

        double total = 0.0;


        /*
         * First calculate the total
         * for the selected gym.
         */
        for (int month = 0;
             month < weightLoss[position].length;
             month++) {

            total =
                    total
                    + weightLoss[position][month];
        }


        /*
         * Divide the total by the number
         * of months.
         *
         * There are 3 values in the row.
         */
        return total
                / weightLoss[position].length;
    }


    /*
     * Find the MINIMUM weight-loss value
     * for one gym.
     */
    private static double calculateMin(
            int position) {


        /*
         * Begin with the first actual value
         * belonging to the selected gym.
         *
         * We do not start with zero.
         */
        double min =
                weightLoss[position][0];


        /*
         * Compare all three months.
         */
        for (int month = 0;
             month < weightLoss[position].length;
             month++) {


            /*
             * If the current value is smaller
             * than the current minimum,
             * update min.
             */
            if (weightLoss[position][month]
                    < min) {

                min =
                        weightLoss[position][month];
            }
        }


        return min;
    }


    /*
     * Find the MAXIMUM weight-loss value
     * for one gym.
     */
    private static double calculateMax(
            int position) {


        /*
         * Start with the first actual value
         * belonging to the selected gym.
         */
        double max =
                weightLoss[position][0];


        /*
         * Compare all three months.
         */
        for (int month = 0;
             month < weightLoss[position].length;
             month++) {


            /*
             * If the current value is larger
             * than the current maximum,
             * update max.
             */
            if (weightLoss[position][month]
                    > max) {

                max =
                        weightLoss[position][month];
            }
        }


        return max;
    }
}
