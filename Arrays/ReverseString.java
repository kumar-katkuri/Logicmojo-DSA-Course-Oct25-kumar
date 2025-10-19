class ReverseString {
    public static void reverseString(char[] s) {
        int length = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[length];
            s[length] = temp;
            if (length != 0) {
                length--;
            }
        }
    }

    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }
}