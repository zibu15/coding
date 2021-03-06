package Leetcode;

import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Implement an iterator to flatten a 2d vector.
 * For example,
 * Given 2d vector =
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class Q251_Flatten_2D_Vector {
    private List<List<Integer>> vec2d;
    private int rowId;
    private int colId;
    private int numRows;

    public Q251_Flatten_2D_Vector(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        rowId = 0;
        colId = 0;
        numRows = vec2d.size();
    }

    public int next() {
        if (!hasNext())
            return -1;

        int ans = vec2d.get(rowId).get(colId);
        colId++;
        return ans;
    }

    public boolean hasNext() {
        if (vec2d == null || vec2d.isEmpty())
            return false;

        while (rowId < numRows
                && (vec2d.get(rowId) == null || vec2d.get(rowId).isEmpty())) {
            rowId++;
        }

        if (colId == vec2d.get(rowId).size()) {
            colId = 0;
            rowId++;
        }

        return rowId < numRows && colId < vec2d.get(rowId).size();
    }
}
