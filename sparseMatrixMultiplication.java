/*
Problem: 
- https://leetcode.com/problems/sparse-matrix-multiplication/ 
- https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleMedium/311.html

A * B ==> A = m x n, B = n x p
*/


// Approach 1: Brute force
class Solution {
	public int[][] multiply(int[][] mat1, int[][] mat2) {
		int m = mat1.length;
		int n = mat1[0].length;
		int p = mat2[0].length;

		int mat3[][] = new int[m][p];

		// Answer will have dimensions m * p. so those need to be our first 2 loops
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < p; ++j) {
				for (int k = 0; k < n; ++k) {
					mat3[i][j] += mat1[i][k] * mat2[k][j];
				}
			}
		}

		return mat3;
	}
}

// Approach 2: optimized
class Solution {
	public int[][] multiply(int[][] mat1, int[][] mat2) {
		int m = mat1.length;
		int n = mat1[0].length;
		int p = mat2[0].length;

		int mat3[][] = new int[m][p];

		// Swap inner two loops
		for (int i = 0; i < m; ++i) {
			for (int k = 0; k < n; ++k) {
				// If value in A is 0, multiplying it with B will give 0. So skip.
				if (mat1[i][k] != 0) {
					for (int j = 0; j < p; ++j) {
						mat3[i][j] += mat1[i][k] * mat2[k][j];
					}
				}
			}
		}

		return mat3;
	}
}