package by.it.evstratov.jd01_06;

import java.util.Arrays;

public class TaskC1 {

    public static void main(String[] args) {

        String[] rows = Poem.text.split("\n");
        StringBuilder[] stringBuilderRows = new StringBuilder[rows.length];

        int maxLength = 0;

        for (int i = 0; i < stringBuilderRows.length; i++) { //добавили строки в массив StrBuilder
            stringBuilderRows[i] = new StringBuilder(rows[i]);
            if(stringBuilderRows[i].length() > maxLength){
                maxLength = stringBuilderRows[i].length();   //находим самую длинную строку
            }
        }

        for (int i = 0; i < stringBuilderRows.length; i++) {
            StringBuilder row = stringBuilderRows[i];

            //находим строку имеющую длинну меньше, чем maxLength

            if(row.length() < maxLength){
                String[] segmentsRow = String.valueOf(row).split(" ");
                StringBuilder[] segmentsRowStrBuilder = new StringBuilder[segmentsRow.length];

                for (int k = 0; k < segmentsRowStrBuilder.length; k++) {
                    segmentsRowStrBuilder[k] = new StringBuilder(segmentsRow[k]);
                }

                StringBuilder result = new StringBuilder();
                int tmpLengthWithoutSpace = row.length() - segmentsRow.length +1;

                while (result.length()<maxLength){
                    StringBuilder tmpRow = new StringBuilder();
                    for (int j = 0; j < segmentsRow.length-1; j++) {
                        if(tmpLengthWithoutSpace<maxLength){
                            tmpLengthWithoutSpace++;
                            segmentsRowStrBuilder[j] = segmentsRowStrBuilder[j].append(" ");
                        }else{
                            break;
                        }
                    }
                    for (int k = 0; k < segmentsRowStrBuilder.length; k++) {
                        tmpRow.append(segmentsRowStrBuilder[k]);
                    }
                    result = tmpRow;
                }
                System.out.println(result);
            }else{
                System.out.println(row);
            }
        }

    }

}
