package minidiscretemathcalc;

/**
 *
 * @author sabinaismailova
 */
import java.util.*;

public class MiniDiscreteMathCalc {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello! Welcome to the Mini Discrete Mathemetics Calculator");
        System.out.println("");
        System.out.println("The following is the key for the operations you can perform: ");
        System.out.println("");
        System.out.println("Factorial(n!) ---> fact");
        System.out.println("Subfactorial(!n) ---> subfact");
        System.out.println("Combinations(C(n,k)) ---> nCk");
        System.out.println("Generalized Fibonacci Numbers Recursion(aF(n-1) + bF(n-2) + c) ---> GFNR");
        System.out.println("Arithmetic Recursion(A(n-1) + d) ---> AR");
        System.out.println("Geometric Recursion(qG(n-1) + d) ---> GR");
        System.out.println("Greatest Common Divisor of two numbers(gcd(n, m)) ---> GCD");
        System.out.println("Least Common Multiple of two numbers(lcm(n, m)) ---> LCM");
        System.out.println("----**NOTE: Click \"enter\" after every input**----");
        System.out.println("");
        
        
        System.out.print("Enter abbriviation listed on the key for the operation you want to perform: ");
        String key = input.next();
        System.out.print("\n");
        
        System.out.println("-----Only integer and decimal numbers are accepted, no fractions-----");
        System.out.println("");
        
        try{
        if(!(key.equals("fact")||key.equals("subfact")||key.equals("nCk")||key.equals("GFNR")
                ||key.equals("AR")||key.equals("GR")||key.equals("GCD")||key.equals("LCM")))
            System.out.println("Invalid input. Please try again. ");
        
        if(key.equals("fact")){
            System.out.print("Enter factorial in form n!: ");
            String fact = input.next();
            System.out.print("\n");
            int n = Integer.parseInt(fact.substring(0, fact.indexOf("!")));
            int limitN = 100;
            if(fact(n)<fact(n-1)){
                System.out.println(fact + " is out of range.");
                limitN = n;
            }
            else if(n>limitN)
                System.out.println(fact + " is out of range.");
            else
                System.out.println(fact + " = " + fact(n));
        }
        
        else if(key.equals("subfact")){
            System.out.print("Enter subfactorial in form !n: ");
            String subfact = input.next();
            System.out.print("\n");
            int n = Integer.parseInt(subfact.substring(subfact.indexOf("!")+1, 
                                    subfact.length()));
            int limitN = 100;
            if(subfact(n)<subfact(n-1)){
                System.out.println(subfact + " is out of range.");
                limitN = n;
            }
            else if(n>limitN)
                System.out.println(subfact + " is out of range.");
            else
                System.out.println(subfact + " = " + subfact(n));
        }
        
        else if(key.equals("nCk")){
            System.out.print("Enter combination using notation C(n,k): ");
            String nCk = input.next();
            System.out.print("\n");
            int n = Integer.parseInt(nCk.substring(2, nCk.indexOf(",")));
            int k = Integer.parseInt(nCk.substring((nCk.indexOf(",")+1), 
                                    nCk.indexOf(")")));
            if(nCk(n,k)==0)
                System.out.println(nCk + " is out of range.");
            System.out.println(nCk + " = " + nCk(n, k));
        }
        
        else if(key.equals("GFNR")){
            System.out.println("Genral Fibonacci Numbers Recursive Function "
                            + "Form: F(n) = aF(n-1) + bF(n-2) + c");
            System.out.println("");
            
            System.out.print("Base-case value F(0): ");
            double base0 = input.nextDouble();
            System.out.print("\n");
            
            System.out.print("Base-case value F(1): ");
            double base1 = input.nextDouble();
            System.out.print("\n");
            
            System.out.print("Coefficient 'a' value: ");
            double coefficient1 = input.nextDouble();
            System.out.print("\n");
            
            System.out.print("Coefficient 'b' value: ");
            double coefficient2 = input.nextDouble();
            System.out.print("\n");
            
            System.out.print("Constant 'c' value: ");
            double c = input.nextDouble();
            System.out.print("\n");
            
            System.out.print("For what value of n would you like to find "
                            + "F(n)? ");
            int n = input.nextInt();
            System.out.print("\n");
            
            double ans = genericFibonacci(base0, base1, coefficient1, coefficient2, c, n);
            
            if(ans>Double.MAX_VALUE||ans<(-Double.MAX_VALUE))
                System.out.println("F(" + n + ") is out of range." );
            else 
                System.out.println("F(" + n + ") = " + ans);
        }
        
        else if(key.equals("AR")){
            System.out.println("Arithmetic Recursive Function Form: A(n) = A(n-1) + d");
            System.out.println("");
            
            System.out.print("What is the base-case value? ");
            double base = input.nextDouble();
            System.out.print("\n");
            
            System.out.print("What is the value of n for the base case? ");
            int baseN = input.nextInt();
            System.out.print("\n");
            
            System.out.print("Is 'd' a constant or a binomial expression in terms of n(constant/expression)? ");
            String dForm = input.next();
            System.out.print("\n");
            
            if(dForm.equals("expression")){
                    System.out.print("What is the coefficient of n? ");
                    double dCoef = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the constant of the expression for 'd'? ");
                    double dCons = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("For what value of n would you like to find A(n)?");
                    int n = input.nextInt();
                    System.out.print("\n");
                
                    System.out.println("A(" + n + ") = " + arithmeticRecursionComplex(base, baseN, dCoef, dCons, n));
            }
            
            else if(dForm.equals("constant")){
                    System.out.print("What is the value of constant 'd'? ");
                    double d = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("For what value of n would you like to find A(n)?");
                    int n = input.nextInt();
                    System.out.print("\n");
                
                    System.out.println("A(" + n + ") = " + arithmeticRecursion(base, baseN, d, n));
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        
        else if(key.equals("GR")){
            System.out.println("Geometric Recursive Function Form: G(n) = qG(n-1) + d");
            System.out.println("");
            
            System.out.print("What is the base-case value? ");
            double base = input.nextDouble();
            System.out.print("\n");
            
            System.out.print("What is the value of n for the base case? ");
            int baseN = input.nextInt();
            System.out.print("\n");
            
            System.out.print("Is 'q' a constant or a binomial expression in terms of n(contant/expression)? ");
            String qForm = input.next();
            System.out.print("\n");
            
            System.out.print("Is 'd' a constant or a binomial expression in terms of n(constant/expression)? ");
            String dForm = input.next();
            System.out.print("\n");
            
            if(qForm.equals("expression")&&dForm.equals("expression")){
                    System.out.print("What is the coefficient of n for the expression representing 'q'? ");
                    double qCoef = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the constant of the expression representing 'q'? ");
                    double qCons = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the coefficient of n for the expression representing 'd'? ");
                    double dCoef = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the constant of the expression representing 'd'? ");
                    double dCons = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("For what value of n would you like to find G(n)?");
                    int n = input.nextInt();
                    System.out.print("\n");
                
                    System.out.println("G(" + n + ") = " + geometricRecursionComplex(base, baseN, qCoef, qCons, dCoef, dCons, n));
            }
            
            else if(qForm.equals("expression")&&dForm.equals("constant")){
                    System.out.print("What is the coefficient of n for the expression representing 'q'? ");
                    double qCoef = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the constant of the expression representing 'q'? ");
                    double qCons = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the value of constant 'd'? ");
                    double d = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("For what value of n would you like to find G(n)?");
                    int n = input.nextInt();
                    System.out.print("\n");
                
                    System.out.println("G(" + n + ") = " + geometricRecursionComplexQ(base, baseN, qCoef, qCons, d, n));
            }
            
            else if(qForm.equals("constant")&&dForm.equals("expression")){
                    System.out.print("What is the value of constant coefficient 'q'? ");
                    double q = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the coefficient of n for the expression representing 'd'? ");
                    double dCoef = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the constant of the expression representing 'd'? ");
                    double dCons = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("For what value of n would you like to find G(n)?");
                    int n = input.nextInt();
                    System.out.print("\n");
                
                    System.out.println("G(" + n + ") = " + geometricRecursionComplexD(base, baseN, q, dCoef, dCons, n));
            }
            
            else if(qForm.equals("constant")&&dForm.equals("constant")){
                    System.out.print("What is the value of constant coefficient 'q'? ");
                    double q = input.nextDouble();
                    System.out.print("\n");
                
                    System.out.print("What is the value of constant 'd'? ");
                    double d = input.nextDouble();
                    System.out.print("\n");

                    System.out.print("For what value of n would you like to find G(n)?");
                    int n = input.nextInt();
                    System.out.print("\n");

                    System.out.println("G(" + n + ") = " + geometricRecursion(base, baseN, q, d, n));
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        
        else if(key.equals("GCD")){
            System.out.print("Enter problem in form gcd(n,m): ");
            String gcd = input.next();
            System.out.print("\n");
            
            int n = Integer.parseInt(gcd.substring(4, gcd.indexOf(",")));
            int m = Integer.parseInt(gcd.substring((gcd.indexOf(",")+1), gcd.indexOf(")")));
            System.out.println("gcd(" + n + "," + m + ") = " + gcd(n, m));
        }
        
        else if(key.equals("LCM")){
            System.out.print("Enter problem in form lcm(n,m): ");
            String lcm = input.next();
            System.out.print("\n");
            
            int n = Integer.parseInt(lcm.substring(4, lcm.indexOf(",")));
            int m = Integer.parseInt(lcm.substring((lcm.indexOf(",")+1), lcm.indexOf(")")));
            System.out.println("lcm(" + n + "," + m + ") = " + lcm(n,m));
        }
        }
        catch(Exception e){
            System.out.println("Invalid input. Please try again.");
        }
    }
    
    
    public static double genericFibonacci(double base0, double base1, double coefficient1, 
                                        double coefficient2, double c, int n){
        if(n==0)
            return base0;
        else if(n==1)
            return base1;
        double Fn = coefficient2*genericFibonacci(base0, base1, coefficient1, 
                    coefficient2, c, n-2) + coefficient1*genericFibonacci(base0, 
                                base1, coefficient1, coefficient2, c, n-1) + c;
        return Fn;
    }
    
    public static int gcd(int n, int m){
        if(m>n){
            int temp = n;
            n = m;
            m = temp;
        }
        int remainder = n%m;
        
        if(remainder==0)
            return m;
        else
            return gcd(m, remainder);
    }
    
    public static int lcm(int n, int m){
        return ((n*m)/gcd(n,m));
    }
    
    public static double arithmeticRecursion(double base, int baseN, double d, int n){
        if(n==baseN)
            return base;
        return arithmeticRecursion(base, baseN, d, n-1) + d;
    }
    
    public static double arithmeticRecursionComplex(double base, int baseN, double dCoef, double dCons, int n){
        if(n==baseN)
            return base;
        return arithmeticRecursionComplex(base,baseN, dCoef, dCons, n-1) + (dCoef*(n)+dCons);
    }
    
    public static double geometricRecursion(double base, int baseN, double q, double d, int n){
        if(n==baseN)
            return base;
        return (q*geometricRecursion(base, baseN, q, d, n-1)) + d;
    }
    
    public static double geometricRecursionComplex(double base, int baseN, double qCoef, double qCons, double dCoef, double dCons, int n){
        if(n==baseN)
            return base;
        return ((qCoef*(n))+qCons)*geometricRecursionComplex(base, baseN, qCoef, qCons, dCoef, dCons, n-1) + ((dCoef*(n))+dCons);
    }
    
    public static double geometricRecursionComplexQ(double base, int baseN, double qCoef, double qCons, double d, int n){
        if(n==baseN)
            return base;
        return ((qCoef*(n))+qCons)*geometricRecursionComplexQ(base, baseN, qCoef, qCons, d, n-1) + d;
    }
    
    public static double geometricRecursionComplexD(double base, int baseN, double q, double dCoef, double dCons, int n){
        if(n==baseN)
            return base;
        return (q*geometricRecursionComplexD(base, baseN, q, dCoef, dCons, n-1)) + ((dCoef*(n)) + dCons);
    }
    
    public static long fact(int n){
        if (n==0) 
            return 1;
        return n*fact(n-1);
    }
    
    public static long subfact(int n){
        if(n==0)
            return 1;
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        return (n-1)*((subfact(n-1))+(subfact(n-2)));
    }
    
    public static long nCk(int n, int k){
        if(fact(n)<0)
            return 0;
        return fact(n)/(fact(n-k)*fact(k));
    }
}
