// Encode And Decode a string
/*
Problem Statement:
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
    // ... your code
    return encoded_string;
}
Machine 2 (receiver) has the function:

vector<string> decode(string s) {
    //... your code
    return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Example 1:

Input: dummy_input = ["Hello","World"]

Output: ["Hello","World"]

Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);
Example 2:

Input: dummy_input = [""]

Output: [""]

Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains any possible characters out of 256 valid ASCII characters.
*/
class Solution {

    public String encode(List<String> strs) {
        /*
         step 1: create a string builder object.
                 for each string in strs
                    add the length of the string followed by any symbol like "#" as delimiter
                    then append the string to the builder obj.
        */
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        System.out.println(sb.toString());
        // convert the stringBuilder object to String and return.
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int pos = 0;
        
        while(pos < str.length()){
            int len = 0;
            /*
                traverse the string untill delimiter symbol ("#" here). this extracts the lengths of strings.
                add the strings to the list leaving the symbol.
            */
            while(str.charAt(pos) != '#'){
                len = len * 10 + (str.charAt(pos) - '0');
                pos++;
            }
                pos++;
                strs.add(str.substring(pos,pos+len));
                pos+=len;
        }
        return strs;
    }
}

// Time complexity:
//     encode -> O(n) where n = size(strs);
//     decode -> O(n) where n = length(str);

// Space complexity:
//     encode -> O(n) where n = length(str);
//     decode -> O(n) where n = size(strs);