package com.philips.credit_simulator;

import com.philips.credit_simulator.models.CarLoan;
import com.philips.credit_simulator.models.Loan;
import com.philips.credit_simulator.util.UtilHelper;

import java.time.Year;
import java.util.Scanner;


// Philippus Muda Sinaga
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String vehicleType;
        String vehicleCondition;
        int vehicleYear;
        int totalLoan;
        int tenor;
        int downPayment;

        System.out.print("Input Jenis Kendaraan Motor|Mobil : ");
        vehicleType = scanner.nextLine();
        if (!UtilHelper.isValidVehicleType(vehicleType)) {
            System.out.println("Jenis Kendaraan Harus Motor | Mobil ");
        }

        System.out.print("Input Kendaraan Bekas|Baru : ");
        vehicleCondition = scanner.nextLine();
        if (!UtilHelper.isValidVehicleCondition(vehicleCondition)) {
            System.out.println("Jenis Kendaraan Harus Motor | Baru ");
        }

        System.out.print("input Tahun Kendaraan : ");
        vehicleYear = scanner.nextInt();
        if (!UtilHelper.isValidYear(vehicleYear)) {
            System.out.println("Tahun Kendaraan harus 4 Digit Numeric");
        }

        System.out.print("Input Jumlah Pinjaman Total : ");
        totalLoan = scanner.nextInt();
        if (!UtilHelper.isValidAmount(totalLoan)) {
            System.out.println("Jumlah Pinjaman Total Melebihi 1 Milyar");
        }

        System.out.print("input Tenor Pinjaman 1-6 thn : ");
        tenor = scanner.nextInt();
        if (!UtilHelper.isValidTenor(tenor)) {
            System.out.println("Jumlah Tenor Harus 1 - 6 Tahun Pinjaman");
        }

        System.out.print("Input Jumlah DP : ");
        downPayment = scanner.nextInt();
        if (!UtilHelper.isValidAmount(downPayment)) {
            System.out.println("Jumlah DP Invalid berdasarkan kondisi Kendaraan");
        }

        if (vehicleCondition.equalsIgnoreCase("Baru")){
            if (!UtilHelper.isValidVehicleYearByCondition(vehicleCondition, vehicleYear)){
                int year = Year.now().getValue() -1;
                System.out.println("Tahun Kendaraan Baru Minimal : "+ year);
            }
            if (!UtilHelper.isValidDownPayment("Baru",totalLoan,downPayment)){
                System.out.println("Downpayment Untuk Kendaraan Baru Minimal :  35%");
            }
        }
        if (!UtilHelper.isValidDownPayment("Bekas",totalLoan,downPayment)){
            System.out.println("Downpayment Untuk Kendaraan Bekas Minimal :  25%");
        }

        Loan loan = new CarLoan(totalLoan,tenor,downPayment);

        System.out.printf("Jumlah Cicilan Perbulan : Rp. %.2f%n ",loan.calculateMonthlyInstallment());
    }


}
