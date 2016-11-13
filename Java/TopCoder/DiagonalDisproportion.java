// https://community.topcoder.com/stat?c=problem_statement&pm=6003

public class DiagonalDisproportion {
	public static int getDisproportion(String[] matrix) {
		int diagonalDisproportion = 0;
		int mainDiagonalSum = 0;
		int collateralDiagonalSum = 0;
		int mainDiagonalElementIndex = 0;
		int collateralDiagonalElementIndex = matrix[0].length()-1;
		
		for (String stringInMatrix : matrix) {
			char mainDiagonalElement = stringInMatrix.charAt(mainDiagonalElementIndex);
			mainDiagonalElementIndex++;
			char collateralDiagonalElement = stringInMatrix.charAt(collateralDiagonalElementIndex);
			collateralDiagonalElementIndex--;
			mainDiagonalSum += Character.getNumericValue(mainDiagonalElement);
			collateralDiagonalSum += Character.getNumericValue(collateralDiagonalElement);
		}
		
		diagonalDisproportion = mainDiagonalSum - collateralDiagonalSum;
		return diagonalDisproportion;
	}
}
