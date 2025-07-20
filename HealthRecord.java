public class HealthRecord {
    // Instance field
    private int height;

    // Constants
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // Class-level tracking
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    // NEW STATIC FIELDS
    private static int counter = 0;               // number of objects
    private static double averageHeight = 0.0;    // average height

    public HealthRecord(int height) {
        setHeight(height);
        counter++; // Increment after setting height
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        int validHeight;

        // Validation logic
        if (height > MIN_PERMITTED_HEIGHT && height < MAX_PERMITTED_HEIGHT) {
            validHeight = height;
        } else {
            validHeight = DEFAULT_HEIGHT;
        }

        this.height = validHeight;

        // Tallest / shortest updates
        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }

        // Average update
        // Formula: y' = (y * n + x) / (n + 1)
        // y = old average, n = current counter BEFORE increment, x = new height
        if (counter == 0) {
            averageHeight = this.height;
        } else {
            averageHeight = ((averageHeight * counter) + this.height) / (counter + 1);
        }
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    // NEW METHOD
    public static double getAverageHeight() {
        return averageHeight;
    }

    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.printf("The average height (cm): %.2f%n", getAverageHeight());
    }
}
