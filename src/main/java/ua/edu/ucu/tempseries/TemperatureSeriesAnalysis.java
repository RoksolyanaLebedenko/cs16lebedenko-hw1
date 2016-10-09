package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries = {};


    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }


    public double average() {
        if (temperatureSeries.length != 0) {
            double amount = 0;
            double sum = 0;
            for (double i : temperatureSeries) {
                amount += 1;
                sum += i;
            }
            return sum / amount;
        } else throw new IllegalArgumentException();
    }


    public double deviation() {
        if (temperatureSeries.length != 0) {
            double average = average();
            double sum = 0;
            for (int i = 1; i < temperatureSeries.length; i++) {
                sum += Math.pow(temperatureSeries[i] - average, 2);
            }
            return Math.sqrt((sum) / (temperatureSeries.length - 1));

        } else throw new IllegalArgumentException();
    }


    public double min() {

        if (temperatureSeries.length != 0) {
            double min = temperatureSeries[0];
            for (int i = 1; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] < min)
                    min = temperatureSeries[i];
            }
            return min;
        } else throw new IllegalArgumentException();
    }

    public double max() {

        if (temperatureSeries.length != 0) {
            double max = temperatureSeries[0];
            for (int i = 1; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] > max)
                    max = temperatureSeries[i];
            }
            return max;
        } else throw new IllegalArgumentException();
    }


    public double findTempClosestToZero() {
        if (temperatureSeries.length != 0) {
            double closestToZero = temperatureSeries[0];
            for (int i = 1; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] > 0 && temperatureSeries[i] < closestToZero) {
                    closestToZero = temperatureSeries[i];
                }
            }
            return closestToZero;
        } else throw new IllegalArgumentException();
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length != 0) {
            double closestToValue = temperatureSeries[0];
            for (int i = 1; i < temperatureSeries.length; i++) {
                if (temperatureSeries[i] < tempValue && temperatureSeries[i] > closestToValue) {
                    closestToValue = temperatureSeries[i];
                }
            }
            return closestToValue;
        } else throw new IllegalArgumentException();
    }


    public double[] findTempsLessThen(double tempValue) {
        if (temperatureSeries.length != 0) {
            double[] arr = new double[temperatureSeries.length];
            int pos = 0;
            for (double i : temperatureSeries) {
                if (i < tempValue) {
                    arr[pos] = i;
                    pos++;
                }
            }
            double[] lessArray = new double[pos];
            System.arraycopy(arr, 0, lessArray, 0, pos);

            return lessArray;
        }
        else throw new IllegalArgumentException();
    }


    public double[] findTempsGreaterThen(double tempValue) {
        if (temperatureSeries.length != 0) {
            double[] arr = new double[temperatureSeries.length];
            int pos = 0;
            for (double i : temperatureSeries) {
                if (i > tempValue) {
                    arr[pos] = i;
                    pos++;
                }
            }
            double[] lessArray = new double[pos];
            System.arraycopy(arr, 0, lessArray, 0, pos);

            return lessArray;
        }
        else throw new IllegalArgumentException();
    }


    public TempSummaryStatistics summaryStatistics() {

        TempSummaryStatistics result = new TempSummaryStatistics(average(), deviation(), min(), max());
        return result;
    }

    public int addTemps(double... temps) {
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (temps[i] < -273) {
                throw new InputMismatchException();
            }
        }
        return 0;
    }
}
