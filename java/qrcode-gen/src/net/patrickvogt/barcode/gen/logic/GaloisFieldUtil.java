package net.patrickvogt.barcode.gen.logic;

public class GaloisFieldUtil {
	
	// GF(2^8)
	public static final int MOD_P = 256;
	
	public static int add(int a, int b)
	{
		return (a^b) & 0xFF;
	}
	
	public static int mul(int a, int b)
	{
		int p = 0;
	    int hi_bit_set;
	    int counter;
	 
	    for (counter = 0; counter < 8; counter++) {
	        if ((b & 1) == 1) 
	        {
	            p ^= a;
	            p = p & 0xFF;
	        }
	        hi_bit_set = (a & 0x80);    // xtime() ...
	        a <<= 1;
	        a = a & 0xFF;
	        if (hi_bit_set == 0x80) 
	        {	
	            a ^= 0x1b;              // ...
	            a = a & 0xFF;
	        }
	        b >>= 1;
	        b = b & 0xFF;
	    }
	 
	    return p & 0xFF;
	}
	
	public static void main(String[] args) {
		System.out.println(add(10,256));
		System.out.println(mul(0xd4,0x02));
	}

}
