public class ValidateIPAddress {


    public static void main(String[] args) {
        ValidateIPAddress v = new ValidateIPAddress();
        v.validIPAddress("1081:db8:85a3:01:0:8A2E:0370:7334:");
    }


    String neither = "Neither";

    public String validIPAddress(String IP) {

        String[] ip;

        ip = IP.split("\\.", -1);
        if (ip.length == 4) {
            return isValidIp4(ip);
        }

        ip = IP.split(":", -1);
        if (ip.length == 8) {
            return isValidIp6(ip);
        }
        return neither;
    }


    String isValidIp4(String[] ip) {
        if (hasWrongLength(ip, 1, 3)) return neither;
        if (hasLeadingZero(ip)) return neither;
        if (hasNonDigit(ip)) return neither;
        if (hasWrongRange(ip)) return neither;

        return "IPv4";
    }

    String isValidIp6(String[] ip) {
        if (hasWrongLength(ip, 1, 4)) return neither;
        if (hasNonDigit16(ip)) return neither;
        if (hasWrongRange16(ip)) return neither;

        return "IPv6";
    }



    boolean hasWrongRange(String[] ip) {
        for (String s : ip) {
            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                return true;
            }
        }
        return false;
    }


    boolean hasWrongRange16(String[] ip) {
        for (String s : ip) {
            if (Integer.valueOf(s,16) > 65535 || Integer.valueOf(s,16) < 0) {
                return true;
            }
        }
        return false;
    }

    boolean hasNonDigit16(String[] ip) {
        for (String s : ip) {
            if (s.startsWith("-")) return true;

            try {
                Integer.valueOf(s,16);
            } catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }

    boolean hasWrongLength(String[] ip, int minLength, int maxLength) {
        for (String s : ip) {
            if (s.length() < minLength || s.length() > maxLength) {
                return true;
            }
        }
        return false;
    }

    boolean hasNonDigit(String[] ip) {
        for (String s : ip) {
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasLeadingZero(String[] ip) {
        for (String s : ip) {
            if (s.length() != 1 && s.startsWith("0")) {
                return true;
            }
        }
        return false;
    }


}

