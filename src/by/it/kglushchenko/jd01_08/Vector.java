package by.it.kglushchenko.jd01_08;



import java.util.Arrays;
import java.util.StringJoiner;


    class Vector extends Var {

        private double[] value;

        public double[] getValue() {
            return value;
        }

        Vector(double[] value) {
            this.value = Arrays.copyOf(value, value.length);
        }

        Vector(String strVector) {
            this.value = Arrays.copyOf(number(strVector), number(strVector).length);
        }

        Vector(Vector vector) {
            this.value = Arrays.copyOf(vector.value, vector.value.length);
        }

        private static double[] number(String line) {

            String[] number = line.replaceAll("[{}]", "").trim().split(",");
            double[] arrayOfNumber = new double[number.length];

            for (int i = 0; i < arrayOfNumber.length; i++) {
                arrayOfNumber[i] = Double.parseDouble(number[i]);
            }
            return arrayOfNumber;
        }

        @Override
        public Var add(Var other) {
            if (other instanceof Scalar) {
                double otherValue = ((Scalar) other).getValue();
                double[] arr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] += otherValue;
                }
                return new Vector(arr);

            } else if (other instanceof Vector) {
                double[] arr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] += ((Vector) other).value[i];
                }
                return new Vector(arr);
            }
            return super.add(other);
        }

        @Override
        public Var sub(Var other) {
            if (other instanceof Scalar) {
                double[] arr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] -= ((Scalar) other).getValue();
                }
                return new Vector(arr);

            } else if (other instanceof Vector) {
                double[] arr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] -= ((Vector) other).value[i];
                }
                return new Vector(arr);
            }
            return super.sub(other);
        }

        @Override
        public Var mul(Var other) {
            if (other instanceof Scalar) {
                double[] arr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] *= ((Scalar) other).getValue();
                }
                return new Vector(arr);
            } else if (other instanceof Vector) {
                double sum = 0;
                for (int i = 0; i < this.value.length; i++) {
                    sum += this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(sum);
            } else {
                return super.mul(other);
            }
        }

        @Override
        public Var div(Var other) {
            if (other instanceof Scalar) {
                if (((Scalar) other).getValue() == 0) {
                    System.out.println("Division by zero");
                    return null;
                }
                double[] arr = Arrays.copyOf(value, value.length);
                for (int i = 0; i < arr.length; i++) {
                    arr[i] /= ((Scalar) other).getValue();
                }
                return new Vector(arr);
            } else {
                return super.div(other);
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            String delimiter = "";
            for (double element : value) {
                stringBuilder.append(delimiter).append(element);
                delimiter = ", ";
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
/*
        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(", ", "{", "}");
            for(double element : value){
                joiner.add(Double.toString(element));
            }
            return joiner.toString();
        }*/
    }