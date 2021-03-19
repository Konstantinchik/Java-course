package by.it.novik.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String[] pred = Poem.text.split("[!|?]|(\\s*(?<!\\.)\\.(?!\\.)\\s*)");

        for (int i = 0; i < pred.length; i++) {
            pred[i] = pred[i].replaceAll("[^а-яА-ЯЁё]+", " ").trim();
        }

        for(int i = pred.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( pred[j].length() > pred[j+1].length() ){
                    String tmp = pred[j];
                    pred[j] = pred[j+1];
                    pred[j+1] = tmp;
                }
            }
        }

        for(int i = 0; i < pred.length; i++){
            System.out.println(pred[i]);
        }
    }
}
