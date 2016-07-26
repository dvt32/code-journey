// https://www.hackerrank.com/challenges/calculating-volume

class Calculate {
    public static Scanner read = new Scanner(System.in).useLocale(Locale.ENGLISH);
    
    // Handle input
    public int get_int_val() throws IOException {
       int input = read.nextInt();
       return input;
    }
    public double get_double_val() throws IOException {
       double input = read.nextDouble();
       return input;
    }
    
    // Throw exception if any argument's value is <= 0
    public static void throwException() {
        throw new NumberFormatException("All the values must be positive");
    }
    
    // Display volume
    public void display(double volume) {
        System.out.println(String.format("%.3f", volume));
    }
 
    // Calculate cube volume
    public static double get_volume(int a) {
        if (a <= 0) { throwException(); }
        double volume = Math.pow((double) a, 3.0);
        return volume;
    }
    // Calculate cuboid volume
    public static double get_volume(int l, int b, int h) {
        if (l <= 0 || b <= 0 || h <= 0) { throwException(); }
        double volume = (double) l * b * h;
        return volume;
    }
    // Calculate hemisphere volume
    public static double get_volume(double r) {
        if (r <= 0) { throwException(); }
        double volume =  (2d/3d) * Math.PI * Math.pow(r, 3.0d);
        return volume;
    }
    // Calculate cylinder volume
    public static double get_volume(double r, double h) {
        if (r <= 0 || h <= 0) { throwException(); }
        double volume = Math.PI * Math.pow(r, 2.0d) * h;
        return volume;
    }
    
    // Completely pointless nested class
    public static class Output extends Calculate {}
    // Completely pointless object
    public static Output output = new Output(); // WARNING: Pointless
    // Completely pointless method
    public static Output do_calc() {
        return new Output();
    }
}
