import java.util.InputMismatchException;
import java.util.Scanner;

void main() {

    System.out.println();

    int i = 0;

    for (Month month : Month.values()) {

        String ordinalNumberSuffix =
            ++i == 1 ? "st" :
            i == 2 ? "nd" :
            i == 3 ? "rd" :
            "th";

        System.out.println(
            "The " +
            i +
            ordinalNumberSuffix +
            " month is " +
            month.toString().charAt(0) +
            month.toString().substring(1).toLowerCase() +
            "."
        );
    }

    System.out.print("\nChoose a month by its number to get its season: ");

    Month chosenMonth;

    try {
        chosenMonth = Month.values()[
            (new Scanner(System.in))
            .nextInt() - 1
        ];
    } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {

        System.out.println("Failed: Input must be an integer between 1 and 12.");
        return;
    }

    String season = switch (chosenMonth) {
        case DECEMBER, JANUARY, FEBRUARY -> "winter";
        case MARCH, APRIL, MAY -> "spring";
        case JUNE, JULY, AUGUST -> "summer";
        case SEPTEMBER, OCTOBER, NOVEMBER -> "autumn";
    };

    System.out.println(
        "\n" +
        chosenMonth.toString().charAt(0) +
        chosenMonth.toString().substring(1).toLowerCase() +
        " is during " +
        season +
        "."
    );
}