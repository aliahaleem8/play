public class OneEditApart {

    public boolean editApart(String a, String b) {
        if (Math.abs(a.length()-b.length()) > 1)
                return false;

        int changes = 0;
        //begins with change

        for (int i =0 ; i< a.length(); i++){
            int ai = 0;
            int bi = 0;
            if (a.charAt(i)!=b.charAt(i))
                changes++;

        }


        // middle has change


        //end has change
        return true;
    }


    public static void main(String[] args) {
//
//        editApart("cat", "dog") = false
//        editApart("cat", "cats") = true
//        editApart("cat", "cut") = true
//        editApart("cat", "cast") = true
//        editApart("cat", "at") = true
//        editApart("cat", "act") = false
    }


}



