/*
IPv4: 1. consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
      2. leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
IPv6: 1. eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":").
         For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one
      2. can omit leading zeros, and can have both lower-and upper case letters e.g., 2001:db8:85a3:0:0:8A2E:0370:7334 (valid)
      3. no empty group value, e.g., 2001:0db8:85a3::8A2E:0370:7334 (invalid)  */

public class Solution {
    public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0) return "Neither";
        /* IPv4 */
        if(IP.contains(".")){
            if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return "Neither";/* get rid of cases like 1.1.1.1. */
            String[] ip4 = IP.split("\\.");
            if(ip4.length != 4){
                return "Neither";
            }
            if(checkIPv4(ip4)) return "IPv4";
        }
        /* Ipv6 */
        if(IP.contains(":")){
            /* get rid of leading or ending ":" */
            if(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return "Neither";
            String[] ip6 = IP.split(":");
            if(ip6.length != 8){
                return "Neither";
            }
            if(checkIPv6(ip6)) return "IPv6";
        }
        return "Neither";
    }
    private boolean checkIPv4(String[] ip4){
        for(String num : ip4){
            if(num.length() > 3 || !num.matches("[0-9]+") || Integer.parseInt(num) > 255
                    || num.length() > 1 && num.charAt(0) == '0'){
                return false;
            }
        }
        return true;
    }
    private boolean checkIPv6(String[] ip6){
        for(String num : ip6){
            if(num.length() == 0 || num.length() > 4 || !num.matches("[0-9a-fA-F]+")){
                return false;
            }
        }
        return true;
    }
}
