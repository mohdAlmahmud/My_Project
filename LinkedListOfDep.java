
public class LinkedListOfDep {
	private NodeDep head;
	private NodeDep current;

	public LinkedListOfDep() {
		head = current = null;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public String retrieve() {
		return current.data;
	}

	public void update(String e) {
		current.data = e;
	}

	public void insert(String e) {
		if(checkRepeated(e))
			return;
		NodeDep tmp;

		if (empty()) {
			head = current = new NodeDep(e);
			;
		} else {
			tmp = current.next;
			current.next = new NodeDep(e);
			;
			current = current.next;
			current.next = tmp;
		}
	}
	
	public void removeRepeated(String e) {
		if(empty()) {
			return;
		}
		current = head;
		while(current != null) {
			if(current.data.substring(2).equalsIgnoreCase(e.substring(2))) {
				remove();
				break;
			}
			current = current.next;
		}
		current = head;
		
	}
	
	public boolean checkRepeated(String e) {
		if(empty()) {
			return false;
		}
		current = head;
		while(current != null) {
			if(current.data.substring(2).equalsIgnoreCase(e.substring(2))) {
				current = head;
				return true;
			}
			current = current.next;
		}
		current = head;
		return false;
		
	}

	public void remove() {
		if (head == current) {
			head = head.next;
		} else {
			NodeDep tmp = head;

			while (tmp.next != current) {
				tmp = tmp.next;
			}
			tmp.next = current.next;
		}
		if (current.next == null) {
			current = head;
		} else {
			current = current.next;
		}

	}

	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null ? true : false;
	}

	public boolean last() {
		return current.next == null ? true : false;
	}
	
	
	public void sortListAlphabetically() {

		current = head;
		NodeDep index = null;

		String temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {

				index = current.next;

				while (index != null) {

					if (current.data.charAt(3) > index.data.charAt(3)) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}

					index = index.next;
				}
				current = current.next;
			}
		}
	}
	
	public void sortListByLevel() {

		current = head;
		NodeDep index = null;

		String temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {

				index = current.next;

				while (index != null) {

					if (current.data.charAt(0) > index.data.charAt(0)) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}

					index = index.next;
				}
				current = current.next;
			}
		}
	}

	public void print() {
		current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
		current = head;
	}
}
