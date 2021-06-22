import java.util.*;



class Bloom{

static int h1(String s, int arrSize)
{
    int hash = 0;
    for (int i = 0; i < s.length(); i++)
    {
        hash = (hash + ((int)s.charAt(i)));
        hash = hash % arrSize;
    }
    return hash;
}
 
// hash 2
static int h2(String s, int arrSize)
{
    int hash = 1;
    for (int i = 0; i < s.length(); i++)
    {
        hash = hash + (int)(Math.pow(2, i) * (int)s.charAt(i));
        hash = hash % arrSize;
    }
    return hash;
}
 
// hash 3
static int h3(String s, int arrSize)
{
    int hash = 7;
    for (int i = 0; i < s.length(); i++)
    {
        hash = (hash * 31 + s.charAt(i)) % arrSize;
    }
    return hash % arrSize;
}
 
// hash 4
static int h4(String s, int arrSize)
{
    int hash = 3;
    int p = 7;
    for (int i = 0; i < s.length(); i++) {
        hash += hash * 7 + (int)s.charAt(0) * Math.pow(p, i);
        hash = hash % arrSize;
    }
    return hash;
}
 
 
// loookup operation
static boolean lookup(boolean bitarray[], int arrSize, String s)
{
    int a = h1(s, arrSize);
    int b = h2(s, arrSize);
    int c = h3(s, arrSize);
    int d = h4(s, arrSize);
 
    if (bitarray[a] && bitarray[b] && bitarray[c] && bitarray[d])
        return true;
    else
        return false;
}
 
// insert operation
static void insert(boolean bitarray[], int arrSize, String s)
{
    // check if the element in already present or not
    if (lookup(bitarray, arrSize, s))
        System.out.println(s+" is Probably already present");
    else
    {
        int a = h1(s, arrSize);
        int b = h2(s, arrSize);
        int c = h3(s, arrSize);
        int d = h4(s, arrSize);
 
        bitarray[a] = true;
        bitarray[b] = true;
        bitarray[c] = true;
        bitarray[d] = true;
 
        System.out.println(s+" inserted");
    }
}
 
// Driver Code
public static void main(String[] args)
{
    boolean bitarray[] = new boolean[100];
    Arrays.fill(bitarray, false);
    int arrSize = 100;
    String sarray[]
        = new String[]{ "abound",   "abounds",       "abundance",
            "abundant", "accessable",    "bloom",
            "blossom",  "bolster",       "bonny",
            "bonus",    "bonuses",       "coherent",
            "cohesive", "colorful",      "comely",
            "comfort",  "gems",          "generosity",
            "generous", "generously",    "genial",
            "bluff",    "cheater",       "hate",
            "war",      "humanity",      "racism",
            "hurt",     "nuke",          "gloomy",
            "facebook", "geeksforgeeks", "twitter" };
    

    for (int i = 0; i < 33; i++) {
        insert(bitarray, arrSize, sarray[i]);
    }
}

}



HBase is schema-less, it doesn't have the concept of fixed columns schema; defines only column families.   
It is built for wide tables. HBase is horizontally scalable.    It is thin and built for small tables. Hard to scale.
No transactions are there in HBase. RDBMS is transactional.
It has de-normalized data.  It will have normalized data.
It is good for semi-structured as well as structured data.