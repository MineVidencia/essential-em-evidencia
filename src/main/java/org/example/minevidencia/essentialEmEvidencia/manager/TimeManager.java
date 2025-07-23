package org.example.minevidencia.essentialEmEvidencia.manager;

public class TimeManager {
    public static String tickToHour(long ticks) {
        long totalMinutes = (long) (ticks / 1000.0 * 60);
        int hours = (int) ((totalMinutes / 60 + 6) % 24);
        int minutes = (int) (totalMinutes % 60);

        return String.format("%02d:%02d", hours, minutes);
    }

    public static long parseTimeToTicks(String timeString) throws IllegalArgumentException {
        switch (timeString.toLowerCase()) {
            case "day":
                return 1000;
            case "night":
                return 13000;
            case "dawn":
                return 23000;
            default:
                // Se não for nenhuma palavra-chave, lança um erro.
                throw new IllegalArgumentException("Input de tempo desconhecido");
        }
    }
}
