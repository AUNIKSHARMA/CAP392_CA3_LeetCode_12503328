
class Solution {

    private String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();

        int[] values = {
            1000000000, 1000000, 1000, 1
        };

        String[] units = {
            "Billion", "Million", "Thousand", ""
        };

        for (int i = 0; i < values.length; i++) {

            if (num >= values[i]) {

                int part = num / values[i];

                result.append(convert(part));

                if (!units[i].isEmpty()) {
                    result.append(units[i]).append(" ");
                }

                num %= values[i];
            }
        }

        return result.toString().trim();
    }

    private String convert(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return below20[num] + " ";
        }

        if (num < 100) {
            return tens[num / 10] + " " + convert(num % 10);
        }

        return below20[num / 100] + " Hundred "
                + convert(num % 100);
    }
}
