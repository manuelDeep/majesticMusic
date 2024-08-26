package org.majestic.majesticMusic.common;

public class Constants {

    public static class CodeConfig {
        /**
         * MM stands for Majestic Music
         */
        public static final String RESERVATION_CODE_PREFIX = "MM";
        public static final int RESERVATION_CODE_LENGTH = 7;
    }

    public static class Reservation {
        public static final String STARTING_STATUS_CODE = "P";
        public static  final String STATUS_APPROVED = "A";
        public static final String STATUS_REJECTED = "R";
    }
}
