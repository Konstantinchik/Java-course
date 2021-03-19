package by.it.evstratov.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {

        String[] sentences = Poem.text.split("[!|?]|(\\s*(?<!\\.)\\.(?!\\.)\\s*)");
        StringBuilder[] stringBuilderSentences = new StringBuilder[sentences.length];

        for (int i = 0; i < stringBuilderSentences.length; i++) {
            stringBuilderSentences[i] = new StringBuilder(sentences[i].replaceAll("[^а-яА-ЯёЁ]+"," ").trim());
        }

        for (int i = 0; i < stringBuilderSentences.length; i++) {
            for (int j = 0; j <stringBuilderSentences.length-1; j++) {
                if(stringBuilderSentences[j].length()>stringBuilderSentences[j+1].length()){
                    StringBuilder tmp = stringBuilderSentences[j];
                    stringBuilderSentences[j] = stringBuilderSentences[j+1];
                    stringBuilderSentences[j+1] = tmp;
                }
            }
        }
        for (StringBuilder stringBuilderSentence : stringBuilderSentences) {
            System.out.print(stringBuilderSentence+"\n");
        }


    }

}
