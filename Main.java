// Main.java
public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle(5);

        // Pattern matching for instanceof (Java 16+, standard in Java 17)
        if (shape instanceof Circle c) {
            System.out.println("Circle radius: " + c.radius());
            System.out.println("Area: " + c.area());
        }

        // Text block (Java 15+, works in Java 17)
        String json = """
                {
                    "type": "Circle",
                    "radius": 5
                }
                """;
        System.out.println("Shape JSON:\n" + json);
    }
}

// Sealed class hierarchy (Java 17 feature)
sealed interface Shape permits Circle, Rectangle {
    double area();
}

record Circle(double radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

record Rectangle(double width, double height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}
