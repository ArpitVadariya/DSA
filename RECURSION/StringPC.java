import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringPC {

    public static void main(String[] args) {

        // System.out.println("Random string generate in lowercase : " +
        // stringGenerateL(5));
        // System.out.println("Random string generate in uppercase : " +
        // stringGenerateU(5));
        // System.out.println("Random string generate in lowerand uppercase : " +
        // stringGenerate(5));
        System.out.println();

        // System.out.println(skipChar("", "bcaddacdaab", 'd'));

        // System.out.println(skipChar("bcaddacdaab", 'd'));

        // here we only remove string without another condition
        // System.out.println(skipString("bcapplddacdaab", "app"));

        // here we skip only app when not apple string into the inputstring
        // System.out.println(skipString("bcapplddacdaab", "app", "apple"));

        // System.out.println(subSeqRet("", "ab"));

        // subSeq(" ", "abc");

        // subSeqAscii(" ", "abc");

        // System.out.println(subSeqAsciiRet(" ", "ab"));

        // int arr[] = { 1, 2, 2 };
        // List<List<Integer>> ans = subSetDuplicate(arr);

        // for (List<Integer> list : ans) {
        // System.out.println(list);
        // }

        // permutation("", "abc");

        // System.out.println(permutationList("", "abc"));

        // System.out.println(permutationCount("", "abc"));

        // keypadButtons("", "11");

        // System.out.println(keypadButtonsList("", "11"));

        // System.out.println(keypadButtonsList("", "11").size());
        // System.out.println(keypadButtonsCount("", "11"));

        // dice("" , 4);

        // System.out.println(diceList("" , 2));

        System.out.println();

        System.out.println("EOF");

    }

    // Random string generate in lowercase
    public static String stringGenerateL(int length) {
        String characters = "qwertyuiopasdfghjklzxcvbnm";
        String word = "";

        Random rd = new Random();

        char[] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rd.nextInt(characters.length()));
        }

        for (int i = 0; i < length; i++) {
            word += text[i];
        }
        // System.out.println(word);
        return word;
    }

    // Random string generate in uppercase
    public static String stringGenerateU(int length) {
        String characters = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String word = "";

        Random rd = new Random();

        char[] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rd.nextInt(characters.length()));
        }

        for (int i = 0; i < length; i++) {
            word += text[i];
        }
        // System.out.println(word);
        return word;
    }

    // Random string generate in lowercase and uppercase
    public static String stringGenerate(int length) {
        String characters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        String word = "";

        Random rd = new Random();

        char[] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rd.nextInt(characters.length()));
        }

        for (int i = 0; i < length; i++) {
            word += text[i];
        }
        // System.out.println(word);
        return word;
    }

    // remove given character in string and return
    public static String skipChar(String p, String inputstring, char removechar) {
        if (inputstring.isEmpty()) {
            return p;
        }

        char ch1 = inputstring.charAt(0);

        if (ch1 == removechar) {
            return skipChar(p, inputstring.substring(1), removechar);
        } else {
            return skipChar(p + ch1, inputstring.substring(1), removechar);
        }
    }

    // remove given character in string and return
    public static String skipChar(String inputstring, char removechar) {
        if (inputstring.isEmpty()) {
            return " ";
        }

        char ch1 = inputstring.charAt(0);

        if (ch1 == removechar) {
            return skipChar(inputstring.substring(1), removechar);
        } else {
            return ch1 + skipChar(inputstring.substring(1), removechar);
        }
    }

    // remove given substring or string from string and return
    public static String skipString(String inputstring, String removestring) {
        if (inputstring.isEmpty()) {
            return " ";
        }

        if (inputstring.startsWith(removestring)) {
            return skipString(inputstring.substring(3), removestring);
        } else {
            return inputstring.charAt(0) + skipString(inputstring.substring(1), removestring);
        }
    }

    // remove given substring or string from string and return
    public static String skipString(String inputstring, String removestring, String substr) {
        if (inputstring.isEmpty()) {
            return " ";
        }

        if (inputstring.startsWith(removestring) && !inputstring.startsWith(substr)) {
            return skipString(inputstring.substring(3), removestring, substr);
        } else {
            return inputstring.charAt(0) + skipString(inputstring.substring(1), removestring, substr);
        }
    }

    // return subsequences
    public static void subSeq(String p, String inpuString) {
        if (inpuString.isEmpty()) {
            System.out.println(p);
            return;
        }

        subSeq(p + inpuString.charAt(0), inpuString.substring(1));
        subSeq(p, inpuString.substring(1));
    }

    // return subsequences with ascii values
    public static void subSeqAscii(String p, String inpuString) {
        if (inpuString.isEmpty()) {
            System.out.println(p);
            return;
        }

        subSeqAscii(p + inpuString.charAt(0), inpuString.substring(1));
        subSeqAscii(p, inpuString.substring(1));
        subSeqAscii(p + (inpuString.charAt(0) + 0), inpuString.substring(1));
    }

    // return subsequences in arraylist
    public static ArrayList<String> subSeqRet(String p, String inpuString) {
        if (inpuString.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> left = subSeqRet(p + inpuString.charAt(0), inpuString.substring(1));
        ArrayList<String> right = subSeqRet(p, inpuString.substring(1));

        left.addAll(right);

        return left;
    }

    // return subsequences with ascii values in arraylist
    public static ArrayList<String> subSeqAsciiRet(String p, String inpuString) {
        if (inpuString.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> first = subSeqAsciiRet(p + inpuString.charAt(0), inpuString.substring(1));
        ArrayList<String> second = subSeqAsciiRet(p, inpuString.substring(1));
        ArrayList<String> third = subSeqAsciiRet(p + (inpuString.charAt(0) + 0), inpuString.substring(1));

        first.addAll(second);
        first.addAll(third);

        return first;
    }

    // return subset of string with duplicates
    public static List<List<Integer>> subSet(int arr[]) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

    // return subset of string without duplicates
    public static List<List<Integer>> subSetDuplicate(int arr[]) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;
    }

    // kramchay sanchay jevu
    public static void permutation(String p, String inputstring) {
        if (inputstring.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = inputstring.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            permutation(f + ch + s, inputstring.substring(1));
        }
    }

    // kramchay sanchay jevu
    public static ArrayList<String> permutationList(String p, String inputstring) {
        if (inputstring.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = inputstring.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            ans.addAll(permutationList(f + ch + s, inputstring.substring(1)));
        }

        return ans;
    }

    // kramchay sanchay jevu
    public static int permutationCount(String p, String inputstring) {
        if (inputstring.isEmpty()) {

            return 1;
        }

        int cnt = 0;
        char ch = inputstring.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            cnt = cnt + permutationCount(f + ch + s, inputstring.substring(1));
        }

        return cnt;
    }

    // mobile keypad buttons 
    public static void keypadButtons(String p, String inputString) {
        if (inputString.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = inputString.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            keypadButtons(p + ch, inputString.substring(1));
        }
    }

    // return subset of moile keypad buttons
    public static ArrayList<String> keypadButtonsList(String p, String inputString) {
        if (inputString.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        int digit = inputString.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            list.addAll(keypadButtonsList(p + ch, inputString.substring(1)));
        }

        return list;
    }

    // mobile button
    public static int keypadButtonsCount(String p, String inputstring) {
        if (inputstring.isEmpty()) {

            return 1;
        }

        int cnt = 0;

        int digit = inputstring.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            cnt = cnt + keypadButtonsCount(p + ch, inputstring.substring(1));
        }

        return cnt;
    }

    // Ludo maate
    public static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    // Ludo maate
    public static ArrayList<String> diceList(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceList(p + i, target - i));
        }

        return list;
    }
}