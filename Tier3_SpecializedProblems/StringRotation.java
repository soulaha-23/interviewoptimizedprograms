public class StringRotation {

    public static boolean isRotation(
            String first,
            String second) {

        if (first == null || second == null) {
            return false;
        }

        if (first.length() != second.length()) {
            return false;
        }

        return (first + first).contains(second);
    }

    public static void main(String[] args) {
        System.out.println(
                isRotation("ABCD", "BCDA")
        );
    }
}
