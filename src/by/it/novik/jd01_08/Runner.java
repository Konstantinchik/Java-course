package by.it.novik.jd01_08;

public class Runner {
private static void print(Var var) {System.out.println(var);}
public static void main(String[] args) {
Var s = new Scalar(3.0);
Var v = new Vector(new double[]{1,2,3});


print(s.add(s)); //выведет в консоль 6.0
print(s.sub(s)); //выведет в консоль 0.0
print(s.mul(s)); //выведет в консоль 9.0
print(s.div(s)); //выведет в консоль 1.0

print(v.add(v)); //выведет в консоль {2.0, 4.0, 6.0}
print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
print(v.mul(v)); //выведет в консоль 14.0
print(v.div(v)); //сообщит о невозможности операции

}
}