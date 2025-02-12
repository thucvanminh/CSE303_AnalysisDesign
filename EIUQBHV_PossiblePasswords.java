import java.util.*;

public class EIUQBHV_PossiblePasswords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputString = sc.nextLine();

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            String temp = String.valueOf(inputString.charAt(i));
            arr.add(temp);
        }

        ArrayList<String> list = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();
        list.add("");
        for (int i = 0; i < inputString.length(); i++) {
            int count = list.size();
            String letter = arr.get(i);
            if (i == 0) {
                list.add(letter);

                list.remove(0);

            } else {
                for (int j = 0; j < count; j++) {
                    String string = list.get(j);
                    for (int k = 0; k <= string.length(); k++) {
                        String res = string.substring(0, k) + letter + string.substring(k);
                        list.add(res);

                    }
                }
                for (int j = 0; j < count; j++) {
                    list.remove(0);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        System.out.println(set.size());
        int size = set.size();
        for (int i = 0; i < size; i++) {
            System.out.println(set.pollFirst());
        }

    }
}
