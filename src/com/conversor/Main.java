package com.conversor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Lista de monedas disponibles en el menú
    private static List<String> monedasDisponibles = new ArrayList<>();

    // Historial de conversiones
    private static List<String> historialConversiones = new ArrayList<>();

    // Inicializamos las monedas por defecto
    static {
        monedasDisponibles.add("USD - Dólar estadounidense");
        monedasDisponibles.add("EUR - Euro");
        monedasDisponibles.add("VES - Bolívar venezolano");
        monedasDisponibles.add("ARS - Peso argentino");
        monedasDisponibles.add("CNY - Yuan chino");
        monedasDisponibles.add("DOP - Peso dominicano");  // Nueva moneda agregada
    }

    // Método para mostrar el menú con solo líneas superior e inferior de asteriscos
    public static void mostrarMenu(String titulo) {
        int ancho = 35;  // Ancho del cuadro de asteriscos
        System.out.println("\n" + "*".repeat(ancho));  // Línea superior de asteriscos
        System.out.println(titulo);

        // Mostrar las opciones del menú
        for (int i = 0; i < monedasDisponibles.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, monedasDisponibles.get(i));
        }

        System.out.println((monedasDisponibles.size() + 1) + ". Agregar nueva moneda");
        System.out.println((monedasDisponibles.size() + 2) + ". Mostrar historial de conversiones");
        System.out.println((monedasDisponibles.size() + 3) + ". Salir");
        System.out.println("*".repeat(ancho));  // Línea inferior de asteriscos
        System.out.print("Seleccione una opción: ");
    }

    public static void convertirMoneda(String monedaOrigen) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        // Menú para elegir la moneda de destino
        mostrarMenu("Seleccione la moneda de destino");
        int opcionDestino = scanner.nextInt();

        if (opcionDestino < 1 || opcionDestino > monedasDisponibles.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        String monedaDestino = monedasDisponibles.get(opcionDestino - 1).split(" ")[0];

        try {
            double tasa = MonedasConverter.obtenerTasaDeCambio(monedaOrigen, monedaDestino);
            double resultado = cantidad * tasa;
            System.out.printf("%.2f %s son %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);

            // Guardar la conversión en el historial con la marca de tiempo
            String registro = String.format("[Fecha: %s] %.2f %s -> %.2f %s",
                    LocalDateTime.now(), cantidad, monedaOrigen, resultado, monedaDestino);
            historialConversiones.add(registro);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para agregar una nueva moneda
    public static void agregarMoneda() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código y nombre de la nueva moneda (ej: JPY - Yen japonés): ");
        String nuevaMoneda = scanner.nextLine();

        monedasDisponibles.add(nuevaMoneda);
        System.out.println("Moneda agregada exitosamente.");
    }

    // Método para mostrar el historial de conversiones
    public static void mostrarHistorial() {
        if (historialConversiones.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("\n--- Historial de Conversiones ---");
            for (String registro : historialConversiones) {
                System.out.println(registro);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu("Menú de Opciones");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= monedasDisponibles.size()) {
                String monedaOrigen = monedasDisponibles.get(opcion - 1).split(" ")[0];
                convertirMoneda(monedaOrigen);
            } else if (opcion == monedasDisponibles.size() + 1) {
                // Opción para agregar nueva moneda
                agregarMoneda();
            } else if (opcion == monedasDisponibles.size() + 2) {
                // Opción para mostrar historial de conversiones
                mostrarHistorial();
            } else if (opcion == monedasDisponibles.size() + 3) {
                System.out.println("Saliendo de la aplicación...");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != monedasDisponibles.size() + 3);

        scanner.close();
    }
}
