package org.example.minevidencia.essentialEmEvidencia.manager;

public class TimeManager {
    public static String tickToHour(long ticks) {
        long totalMinutes = (long) (ticks / 1000.0 * 60);
        // Tempo começa das 6:00 da manhã
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
        }
        if (timeString.contains(":")) {
            try {
                long ticks = getTicks(timeString);
                return ticks;

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("A hora deve conter apenas números.");
            }
        }
        
        try {
            String numericString = timeString.toLowerCase().replace("ticks", "");
            return Long.parseLong(numericString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input de tempo desconhecido ou inválido.");
        }
    }

    private static long getTicks(String timeString) {
        String[] parts = timeString.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Formato de hora inválido.");
        }

        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Hora ou minutos fora do intervalo válido.");
        }

        // Tempo começa das 6:00 da manhã
        int adjustedHours = (hours - 6 + 24) % 24;

        long ticks = (long) (adjustedHours * 1000);
        ticks += (long) ((minutes / 60.0) * 1000);
        return ticks;
    }
}
