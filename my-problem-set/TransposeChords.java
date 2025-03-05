import java.util.Arrays;

public class TransposeChords {
    public static void main(String[] args) {
        String[] chords = { "C", "G", "A", "E", "F", "C", "F", "G" }; // Canon
        String[] newChords = transpose(chords, 2);
        System.out.println("Transposed: " + Arrays.toString(newChords));

        // sharp keys
        String[] chords2 = { "A#", "F#", "C#", "G#" }; 
        String[] newChords2 = transpose(chords2, 2);
        System.out.println("Transposed: " + Arrays.toString(newChords2));

        // tranpose down: 
        String[] chords3 = { "C", "A", "F", "G" }; 
        String[] newChords3 = transpose(chords3, -2);
        System.out.println("Transposed: " + Arrays.toString(newChords3));        

        // TODO: support minor chords e.g. Am, C#m
        // ...
    }

    public static String[] transpose(String[] chords, int key) {
        String[] keys = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"}; // 12 keys
        String[] newChords = chords.clone();

        for (int i = 0; i < newChords.length; i++) {
            for (int j = 0; j < keys.length; j++) {
                if (newChords[i].equals(keys[j])) {
                    int newIndex = (j + key + 12) % keys.length;
                    // System.out.println(newIndex+keys[newIndex]);
                    newChords[i] = keys[newIndex];
                    break;
                }
            }
        }
        
        return newChords;
    }
}