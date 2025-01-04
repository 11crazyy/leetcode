package test;

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

    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(Integer.parseInt(date.substring(0,4))));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(date.substring(5,7))));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(date.substring(8,10))));
        return sb.toString();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m + n - 1,p1=m-1,p2=n-1;
        while(p2 >= 0){
            if(p1>=0 && nums1[p1]>nums2[p2]){
                nums1[index1--] = nums1[p1--];
            }else{
                nums1[index1--] = nums2[p2--];
            }
        }
    }


}
