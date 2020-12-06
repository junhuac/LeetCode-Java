/*
 Author:     Junhua Chang, junhuac@hotmail.com
 Date:       Dec 5, 2020
 Problem:    Goat Latin
 Difficulty: Low
 Source:     https://leetcode.com/problems/goat-latin/
 Notes:
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
*/

class Solution {
    public String toGoatLatin(String S) {
        
        StringBuilder sb = new StringBuilder();
        boolean bStart = true;
        String vowels = "aeiouAEIOU";
        char ch = 0;
        char consonant = 0;
        int index = 0;
        
        for(int i = 0;  i < S.length(); i++)
        {
            ch = S.charAt(i);
            
            if(ch == ' ')
            {
                bStart = true;
                sb.append(ch);
                continue;
            }
        
            if(bStart)
            {
                index++;
                if(vowels.indexOf(ch) >= 0)
                {
                    consonant = 0;    
                    sb.append(ch);
                }
                else
                {
                    consonant = ch;
                }
                bStart = false;
            }
            else
            {
                sb.append(ch);
            }
                        
            if((i == S.length()-1) || S.charAt(i+1) == ' ')
            {
                if(consonant != 0)
                {
                    sb.append(consonant);
                }
                sb.append("ma");
                for(int j = 0; j < index; j++)
                {
                    sb.append("a");
                }
                continue;
            }    
        }
        
        return sb.toString();
    }
}