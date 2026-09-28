public class ReverseWords {

    public static String reverseEachWord(String sentence) {

        StringBuilder result = new StringBuilder();

        for (String word : sentence.split(" ")) {

            result.append(new StringBuilder(word).reverse())
                  .append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("Hello world"));
    }
}
