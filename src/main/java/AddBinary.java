public class AddBinary {
    public String addBinary(String a, String b) {
        char[] char1 = a.toCharArray();
        char[] char2 = b.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;
        int len = Math.max(len1, len2), carry = 0;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            carry += i < len1 ? (char1[len1 - i - 1] - '0') : 0;
            carry += i < len2 ? (char2[len2 - i - 1] - '0') : 0;
            buffer.append((char)(carry % 2 + '0'));
            carry /= 2;
        }
        if (carry == 1) {
            buffer.append('1');
        }
        buffer.reverse();
        return buffer.toString();
    }
}
