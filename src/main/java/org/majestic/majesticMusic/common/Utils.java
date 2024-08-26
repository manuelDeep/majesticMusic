package org.majestic.majesticMusic.common;

public class Utils {

    public static String generateCode(int id) {

        // Calculate the length of the number of zeros needed to reach 8 digits.
        int idLength = Integer.toString(id).length();
        int zeroLength = Constants.CodeConfig.RESERVATION_CODE_LENGTH - idLength; // Zeros to add

        if (zeroLength < 0) {
            throw new IllegalArgumentException("ID too large for the expected format.");
        }

        // Generate zeros
        String zerosPart = "0".repeat(zeroLength);

        // Parse id in string
        String idPart = String.format("%d", id);

        // ex. MM00000001
        return Constants.CodeConfig.RESERVATION_CODE_PREFIX + zerosPart + idPart;
    }
}
