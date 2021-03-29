public class LookSaySequence {
    /*
    1
11
21
1211
111221
312211
13112221
1113213211
31131211131221
13211311123113112211
     */



    public void run() {

        System.out.println("1");
        String s = "11";
        System.out.println(s);

        while (s.length() <= 30){
            s = lookSay(s);
            System.out.println(s);
        }



    }

    private String lookSay(String s) {
        StringBuilder r = new StringBuilder();
        int count = 1;
        for (int i = 0; i< s.length(); i++){
            if ((i+1 < s.length()) && ( s.charAt(i) == s.charAt(i+1))){
                count ++;
            }
            else {
                r.append(""+count + s.charAt(i));
                count = 1;
            }
        }

        return r.toString();
    }


    public static void main(String[] args) {
        new LookSaySequence().run();
    }
}
