package com.alura.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Calculos {
    private final String monedaBase;
    private final String monedaDivisa;
    private final double cantidad;
    private final double monto;
    private final LocalDateTime timestamp;

    public Calculos(MoneyRate rate, double monto) {
        this.monedaBase = rate.base_code();
        this.monedaDivisa = rate.target_code();
        this.cantidad = monto * rate.conversion_rate();
        this.monto = monto;
        this.timestamp = LocalDateTime.now();
    }

    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "El valor del monto ingresado: " + monto + " " + monedaBase +
                " corresponde al valor final de --> " + cantidad + " " + monedaDivisa +
                "\nConversión realizada --> [" + timestamp.format(formato) + "]";
    }

    public static void listarCalculos(List<Calculos> historial) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Historial de conversiones");
        System.out.printf("%-12s %-15s %-10s %-20s %-13s %-20s\n",
                "Iteración", "Moneda Base", "Monto", "Moneda Convertida", "Convertido", "Fecha y Hora");
        System.out.println("------------------------------------------------------------------------------------------");

        int i = 1;
        for (Calculos registro : historial) {
            System.out.printf("%-12d %-15s %-10.2f %-20s %-13.2f %-20s\n",
                    i++, registro.monedaBase, registro.monto, registro.monedaDivisa, registro.cantidad,
                    registro.timestamp.format(formato));
        }
    }
}
