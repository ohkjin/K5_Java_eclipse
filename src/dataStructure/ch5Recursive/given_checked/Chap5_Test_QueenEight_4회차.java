//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
/*
 * 체스판은 8 x 8
 * 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 *  Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 *  pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능
 *  체스판 최대 배치 문제 : king/16, Queen/8, rook/8, bishop/?, knight/?
 *  rook 2개/a, h, knight 2개/b, g, bishop 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
package dataStructure.ch5Recursive.given_checked;


class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}
	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

class Stack3 {
	private Point[] data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// --- 생성자(constructor) ---//
	public Stack3(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new Point[capacity]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public void push(Point p) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		data[top++] = p;
		return;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
//		Point ip = data[--top];
//		System.out.println("pop::"+ip.toString());
		return data[--top];
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data[top - 1];
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (data[i].equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data[i] + " ");
			System.out.println();
		}
	}
}

public class Chap5_Test_QueenEight_4회차 {

	public static void SolveQueen(int[][] d) {
		int count = 0, mode = 0;
		int ix = 0, iy = 0;
		Stack3 st = new Stack3(100);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1; count++;
		st.push(p);
		while (count < 8) {
			ix++;		int cy = 0;
			while (ix < d.length)
			{

				while (cy < d[0].length) {

						st.push(px); count++;
						break;

				}
				if (cy != d[0].length) {
					break;
				} else {
				 p = st.pop();	 count--;



				}


			}


		}
	}

	public static boolean checkRow(int[][] d, int crow) {

		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {

		return true;
	}

	public static boolean checkDiagSW(int[][] d, int cx, int cy) { //x++, y-- or x--, y++ where 0<= x,y <= 7

		return true;
	}

	public static boolean checkDiagSE(int[][] d, int cx, int cy) {//x++, y++ or x--, y--

		return true;
	}
    public static boolean CheckMove(int[][]d, int x, int y) {//(x,y)로 이동 가능한지를 check

    }
    public static Point nextMove(int[][]d, int row, int col) {//다음 row에 대하여 이동할 col을 조사

    	return true;
    }
	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);

		for (int[] element : data) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + element[j]);
			}
			System.out.println();
		}
	}
}


