package at.pxnet;

public class Grading {

    private Grading() {
        throw new UnsupportedOperationException("Utility Class");
    }

    public static boolean isFailing(Person person) {
        int[] grades = person.getGrades();

        // Sicherstellen, dass die Person mindestens zwei Noten hat
        if (grades.length < 2) {
            throw new IllegalStateException("Person must have at least two grades");
        }

        int countFours = 0;

        for (int grade : grades) {
            if (grade == 5) {
                return true; // Sofortiger Abbruch, wenn eine 5 gefunden wurde
            }
            if (grade == 4) {
                countFours++;
            }
        }

        return countFours >= 3;
    }
}

