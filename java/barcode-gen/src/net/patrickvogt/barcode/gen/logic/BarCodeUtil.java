package net.patrickvogt.barcode.gen.logic;

public class BarCodeUtil {

	private static final int[] upc_left_bitmask = { 0x0D, 25, 19, 61, 35, 49, 47,
			59, 55, 11 };
	private static final int upc_start_end = 0x5;
	private static final int upc_middle = 0xA;

	private static int getBitMask(int i, char[] ca) {
		int offset = (i > 0 && i < 7) ? 1 : 2;

		if (i == 0 || i == 14) {
			return (upc_start_end << 4);
		} else if (i == 7) {
			return (upc_middle << 2);
		} else {
			return upc_left_bitmask[ca[i - offset] - '0'];
		}
	}

	private static int[] int2Boolean(int i, boolean invert) {
		int[] result = new int[8];

		for (int j = 6; j >= 0; j = j - 1) {

			result[6-j] = (i >> j) & 1;
			if(invert)
			{
				result[6-j] = ~(result[6-j]) & 1;
			}
		}
		
		return result;
	}

	public static int[][] generateUPCBarcode(String s) {
		int[][] barcodeMask = new int[15][8];
		char[] ca = s.toCharArray();
		int length = 0;
		int bitmask = 0;
		int[] bitmaskarr = new int[8];

		for (int i = 0; i < (s.length() + 3) && i < 15; i = i + 1) {
			length = getLength(i);
			bitmask = getBitMask(i, ca);
			barcodeMask[i][0] = length;
			bitmaskarr = int2Boolean(bitmask, (i!=0 && i!=14 && i>7) ? true : false);

			for (int j = 7; j >= 1; j = j - 1) {
				barcodeMask[i][j] = bitmaskarr[j-1];
			}
		}

		return barcodeMask;
	}

	private static int getLength(int i) {
		if (i == 0 || i == 14) {
			return 3;
		} else if (i == 7) {
			return 5;
		} else {
			return 7;
		}
	}
	
	public static void main(String[] args) {
		//Test
		int[][] test = generateUPCBarcode("012345678901");
		System.out.println(test);
	}

}
