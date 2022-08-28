import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet set =new HashSet();
        for(int i=0;i<N;i++){
            set.add(new Word(br.readLine()));
        }
        ArrayList<Word> list = new ArrayList<>(set);
        Collections.sort(list);
        for(Word word : list){
            System.out.println(word.word);
        }
    }
    public static class Word implements Comparable<Word>{
        String word;
        public Word(String word){
            this.word = word;
        }
        public int hashCode(){
            return word.hashCode();
        }
        public boolean equals(Object o){
            if(o instanceof Word){
                Word w = (Word) o;
                return w.word.equals(this.word);
            }
            return false;
        }
        @Override
        public int compareTo(Word o) {
            if(this.word.length() == o.word.length()){
                return this.word.compareTo(o.word);
            }
            else if(this.word.length() > o.word.length()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
