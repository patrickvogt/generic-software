package net.patrickvogt.barcode.gen.logic;

public class BarCodeUtil {
	
	// for UPC code see: http://en.wikipedia.org/wiki/Universal_Product_Code

	// bitmask for barcode digits between start and middle barcode sign
	private static final int[] UPC_LEFT_BITMASK = { 0x0D, 0x19, 0x13, 0x3D, 0x23, 0x31,
			0x2F, 0x3B, 0x37, 0x0B };
	// bitmask for barcode start and end
	private static final int UPC_START_N_END_BITMASK = 0x5;
	// bitmask for the middle seperator of the barcode
	private static final int UPC_MIDDLE_BITMASK = 0xA;
	
	// length of normal barcode digit
	private static final int LENGTH_BARCODE_DIGIT = 7;
	// length of start and end barcode digit 
	private static final int LENGTH_START_N_END_DIGIT = 3;
	// length of middle barcode seperator
	private static final int LENGTH_MIDDLE = 5;
	// number of non data barcode 'digits'
	private static final int NUM_NON_DATA_DIGS = 3;

	// get the bitmask for the given position and in the given data array (if needed)
	private static int getBitMask(int i, char[] ca) {
		// correct the array offset (due to the start and middle barcode signs)
		int offset = (i > 0 && i < 7) ? 1 : 2;

		// get the corresponding bitmask (directly or from the given data array)
		if (isUPCStartPosition(i) || isUPCEndPosition(i)) {
			return (BarCodeUtil.UPC_START_N_END_BITMASK << 4);
		} else if (isUPCMiddlePosition(i)) {
			return (BarCodeUtil.UPC_MIDDLE_BITMASK << 2);
		} else {
			return BarCodeUtil.UPC_LEFT_BITMASK[ca[i - offset] - '0'];
		}
	}

	// convert a given byte (given as int) into an int array representing the bits of the given byte
	private static int[] int2Boolean(int i, boolean invert) {
		int[] result = new int[8];

		// slice the given byte into bits from LSB to MSB
		for (int j = 0; j <= 6; j = j + 1) {
			result[j] = (i >> j) & 1;
			// do we need to invert the bit (for the barcode digits between middle and end)?
			if (invert) {
				result[j] = ~(result[j]) & 1;
			}
		}

		return result;
	}
	
	// returns the length (number of stripes) for the position
	private static int getLength(int i) {
		if (isUPCStartPosition(i) || isUPCEndPosition(i)) {
			return BarCodeUtil.LENGTH_START_N_END_DIGIT;
		} else if (isUPCMiddlePosition(i)) {
			return BarCodeUtil.LENGTH_MIDDLE;
		} else {
			return BarCodeUtil.LENGTH_BARCODE_DIGIT;
		}
	}

	// if the position is the start of the barcode
	public static boolean isUPCStartPosition(int i) {
		return 0 == i;
	}

	// if the position is the end of the barcode
	public static boolean isUPCEndPosition(int i) {
		return 14 == i;
	}
	
	// of the postion is the middle of the barcode
	public static boolean isUPCMiddlePosition(int i) {
		return 7 == i;
	}

	// if the position is the real data of the barcode
	public static boolean isUPCPositionADataDigit(int i) {
		return (isUPCStartPosition(i) || isUPCMiddlePosition(i) || isUPCEndPosition(i)) ? false
				: true;
	}
	
	// if the position is on the right side (between middle and end)
	public static boolean isUPCPositionInverted(int i)
	{
		return (!isUPCStartPosition(i) && !isUPCEndPosition(i) && i > 7) ? true : false;
	}

	// generate the barcode from the given string
	public static int[][] generateUPCBarcode(String s) {
		final int ROWS = 15;
		final int COLS = 8;
		
		int[][] barcodeMatrix = new int[ROWS][COLS];
		char[] ca = s.toCharArray();
		int length = 0;
		int bitmask = 0;
		int[] bitmask_digit = new int[COLS];

		for (int i = 0; i < (s.length() + BarCodeUtil.NUM_NON_DATA_DIGS) && i < ROWS; i = i + 1) {
			// get the length of the barcode digit since this can be variable for start, middle, end or data digit
			length = getLength(i);
			// get the corresponding bitmask for the digit
			bitmask = getBitMask(i, ca);
			// save the length in the first column of the barcode matrix
			barcodeMatrix[i][0] = length;
			// get the bitmask for the i. position/digit of the barcode
			bitmask_digit = int2Boolean(bitmask, isUPCPositionInverted(i));

			// topsy turvy the bits and save it into the barcode matrix
			// the real bits of the digit are stored in the array elements with the index 1..7
			// since the array element with index 0 holds the length (number of stripes) of the barcode digit
			for (int j = (COLS-1); j >= 1; j = j - 1) {
				barcodeMatrix[i][j] = bitmask_digit[(COLS-1)-j];
			}
		}

		// return the built barcode matrix
		return barcodeMatrix;
	}

	// public static void main(String[] args) {
	// // small Test
	// int[][] test = generateUPCBarcode("012345678901");
	// System.out.println(test);
	// }

}
