package com.alura.modelos;

import com.alura.service.ConsultaApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();
        List<Calculos> historial = new ArrayList<>();

        int opcion = -1;

        while (opcion != 7) {
            System.out.println(
                    """
            \n*******************************************
            Sea bienvenido/a al Conversor de Moneda
            *******************************************
            1) Dólar (USD) => Peso chileno (CLP)
            2) Peso chileno (CLP) => Dólar (USD)
            3) Dólar (USD) => Peso argentino (ARS)
            4) Peso argentino (ARS) => Dólar (USD)
            5) Dólar (USD) => Real brasileño (BRL)
            6) Dólar (USD) => Peso colombiano (COP)
            7) Ver historial
            8) Salir
            Elija una opción válida:
        """
            );
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el monto en USD: ");
                    double monto = teclado.nextDouble();
                    MoneyRate rate = conversor.obtenerTasa("USD", "CLP");
                    Calculos conversion = new Calculos(rate, monto);
                    System.out.println(conversion);
                    historial.add(conversion);
                }
                case 2 -> {
                    System.out.print("Ingrese el monto en CLP: ");
                    double monto = teclado.nextDouble();
                    MoneyRate rate = conversor.obtenerTasa("CLP", "USD");
                    Calculos conversion = new Calculos(rate, monto);
                    System.out.println(conversion);
                    historial.add(conversion);
                }
                case 3 -> {
                    System.out.print("Ingrese el monto en USD: ");
                    double monto = teclado.nextDouble();
                    MoneyRate rate = conversor.obtenerTasa("USD", "ARS");
                    Calculos conversion = new Calculos(rate, monto);
                    System.out.println(conversion);
                    historial.add(conversion);
                }
                case 4 -> {
                    System.out.print("Ingrese el monto en ARS: ");
                    double monto = teclado.nextDouble();
                    MoneyRate rate = conversor.obtenerTasa("ARS", "USD");
                    Calculos conversion = new Calculos(rate, monto);
                    System.out.println(conversion);
                    historial.add(conversion);
                }
                case 5 -> {
                    System.out.print("Ingrese el monto en USD: ");
                    double monto = teclado.nextDouble();
                    MoneyRate rate = conversor.obtenerTasa("USD", "BRL");
                    Calculos conversion = new Calculos(rate, monto);
                    System.out.println(conversion);
                    historial.add(conversion);
                }
                case 6 -> {
                    System.out.print("Ingrese el monto en USD: ");
                    double monto = teclado.nextDouble();
                    MoneyRate rate = conversor.obtenerTasa("USD", "COP");
                    Calculos conversion = new Calculos(rate, monto);
                    System.out.println(conversion);
                    historial.add(conversion);
                }
                case 7 -> Calculos.listarCalculos(historial);
                case 8 -> System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        teclado.close();
    }
}


