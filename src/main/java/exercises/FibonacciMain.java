package exercises;


public class FibonacciMain {
    public static void main(String[] args) {
        FibonacciServices fs= new FibonacciServices(7);
        System.out.println(fs.getFibonacci(4));
      //  System.out.println(fs.getFibonacci(9));

    }


}
