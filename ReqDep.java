import java.util.Scanner;

public class ReqDep {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		LinkedListOfReq listOfReq = new LinkedListOfReq();
		LinkedListOfDep listOfDep = new LinkedListOfDep();
		String requirement = input.nextLine();
		while (true) {
			String[] array = input.nextLine().split(" ");
			if (array[0].equalsIgnoreCase("0")) {
				break;
			}
			listOfReq.insert(array);
		}
		System.out.println();
		int size = listOfReq.findSize();
		String R[][] = new String[size + 1][size + 1];
		initializeMatrix(R);
		fillMatrix(R, listOfReq);
		display(R);
		getDebendency(listOfReq, listOfDep, requirement, 1);
		if(listOfDep.empty()) {
			System.out.println("There is no requirements depends on "+requirement);
		}
		else {
		listOfDep.findFirst();
		listOfDep.sortListAlphabetically();
		listOfDep.sortListByLevel();
		listOfDep.print();
		}

	}

	public static void initializeMatrix(String[][] R) {
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[i].length; j++) {
				R[i][j] = new String();
			}
		}
		R[0][0] = " ";
		for (int i = 1; i < R.length; i++) {
			R[i][0] = "R" + i;
		}
		for (int i = 1; i < R.length; i++) {
			R[0][i] = "R" + i;
		}
	}

	public static void display(String matrix[][]) {
		System.out.print(" ");
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col].equalsIgnoreCase(""))
					System.out.print(matrix[row][col] + "    ");
				else if (matrix[row][col].equalsIgnoreCase("x"))
					System.out.print(matrix[row][col] + "   ");
				else
					System.out.print(matrix[row][col] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void fillMatrix(String[][] R, LinkedListOfReq list) {
		list.findFirst();
		while (!list.last()) {
			for (int i = 1; i < list.retrieve().length; i++)
				R[Integer.parseInt(list.retrieve()[0].substring(1))][Integer
						.parseInt(list.retrieve()[i].substring(1))] = "x";
			list.findNext();
		}
		for (int i = 1; i < list.retrieve().length; i++)
			R[Integer.parseInt(list.retrieve()[0].substring(1))][Integer
					.parseInt(list.retrieve()[i].substring(1))] = "x";
		list.findFirst();
	}

	public static void getDebendency(LinkedListOfReq listReq, LinkedListOfDep listDep, String req, int n) {
		listReq.findFirst();
		while (!listReq.last()) {
			for (int i = 1; i < listReq.retrieve().length; i++) {
				if (listReq.retrieve()[i].equalsIgnoreCase(req)) {
					Node s = listReq.getCuurent();
					getDebendency(listReq, listDep, listReq.retrieve()[0], n + 1);
					listReq.setCurrent(s);
					listDep.insert(n + " " + listReq.retrieve()[0]);
				}
			}
			listReq.findNext();
		}
		for (int i = 1; i < listReq.retrieve().length; i++) {
			if (listReq.retrieve()[i].equalsIgnoreCase(req)) {
				Node s = listReq.getCuurent();
				getDebendency(listReq, listDep, listReq.retrieve()[0], n + 1);
				listReq.setCurrent(s);
				listDep.insert(n + " " + listReq.retrieve()[0]);
			}
		}

	}
}
