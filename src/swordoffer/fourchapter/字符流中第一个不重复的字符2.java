package swordoffer.fourchapter;

public class 字符流中第一个不重复的字符2 {

    //一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表。
    int[] hashTable = new int[256];
    //时间复杂度为O(n)，空间复杂度O(n).
    StringBuffer s = new StringBuffer();

    public void insert(char ch){
        s.append(ch);
        if(hashTable[ch] == 0)
            hashTable[ch] = 1;
        else
            hashTable[ch] += 1;
    }

    public char FirstAppearingOnce(){

        char[] arr = s.toString().toCharArray();
        for (char c : arr) {
            if(hashTable[c] == 1)
                return c;
        }
        return '#';
    }


}
