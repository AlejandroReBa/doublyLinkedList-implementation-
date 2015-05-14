package iis.doubly.linked.list;


public class DoublyLinkedList<T> {

	private class DoublyLinkedNode<E> {
		private DoublyLinkedNode<E> prev;
		private DoublyLinkedNode<E> next;
		private E data;

		private DoublyLinkedNode(E newData) {
			this.data = newData;
			this.prev = null;
			this.next = null;
		}
	}

	private DoublyLinkedNode<T> firstNode;
	private DoublyLinkedNode<T> lastNode;
	private int listSize;

	public DoublyLinkedList() {
		this.firstNode = null;
		this.lastNode = null;
		this.listSize = 0;
	}

	public boolean isEmpty() {
		return this.firstNode == null;
	}

	public int listSize() {
		return this.listSize;
	}

	public T first() {
		if (this.firstNode != null) {
			return this.firstNode.data;
		}else{
			System.err.println("La lista está vacía");
			return null;
		}
	}

	public T last() {
		if (this.lastNode != null) {
			return this.lastNode.data;
		}else{
			System.err.println("La lista está vacía");
			return null;
		}
	}

	public T elementAtPosition(int pos) {
		if (listSize < pos) {
			System.err.println("No existe un nodo en la posición " + pos);
			return null;
		}else{
			int cont = 0;
			DoublyLinkedNode<T> nodeAux = this.firstNode;
			while (cont < pos) {
				cont++;
				nodeAux = nodeAux.next;
			}
			return nodeAux.data;
		}

	}

	public void insertAfter(T afterNodeData, T newData) {
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(newData);
		DoublyLinkedNode<T> afterNode = this.firstNode;
		boolean find = false;

		while (afterNode != null && !find) {
			if (afterNode.data.equals(afterNodeData)) {
				find = true;
				newNode.prev = afterNode;
				newNode.next = afterNode.next;
				if (afterNode.next == null) {
					this.lastNode = newNode;
				}else{
					afterNode.next.prev = newNode;
				}
				afterNode.next = newNode;
			}else{
				afterNode = afterNode.next;
			}
		}
		if (find){
			this.listSize++;
		}
	}

	private void insertAfterNode(DoublyLinkedNode<T> node, T newData) {
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(newData);
		newNode.prev = node;
		newNode.next = node.next;
		if (node.next == null) {
			this.lastNode = newNode;
		}else{
			node.next.prev = newNode;
		}
		node.next = newNode;

	}

	public void insertBefore(T beforeNodeData, T newData) {
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(newData);
		DoublyLinkedNode<T> beforeNode = this.firstNode;
		boolean find = false;

		while (beforeNode != null && !find) {
			if (beforeNode.data.equals(beforeNodeData)) {
				find = true;
				newNode.prev = beforeNode.prev;
				newNode.next = beforeNode;
				if (beforeNode.prev == null) {
					this.firstNode = newNode;
				}else{
					beforeNode.prev.next = newNode;
				}
				beforeNode.prev = newNode;
			}else{
				beforeNode = beforeNode.next;
			}
		}
		if (find){
			this.listSize++;
		}
	}

	private void insertBeforeNode(DoublyLinkedNode<T> node, T newData) {
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(newData);
		newNode.prev = node.prev;
		newNode.next = node;
		if (node.prev == null) {
			this.firstNode = newNode;
		} else {
			node.prev.next = newNode;
		}
		node.prev = newNode;
	}

	public void insertBeginning(T newData) {
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>(newData);
		if (this.firstNode == null) {
			this.firstNode = newNode;
			this.lastNode = newNode;
			newNode.prev = null;
			newNode.next = null;
		} else {
			insertBeforeNode(this.firstNode, newData);
		}
		this.listSize++;
	}

	public void insertEnd(T newData) {
		if (this.lastNode == null) {
			insertBeginning(newData);
		} else {
			insertAfterNode(this.lastNode, newData);
		}
		this.listSize++;

	}

	public void removeAll(T dataToRemove) {
		DoublyLinkedNode<T> nodeAux = this.firstNode;
		while (nodeAux != null) {
			if (nodeAux.data.equals(dataToRemove)) {
				if (nodeAux.prev == null) {
					this.firstNode = nodeAux.next;
				} else {
					nodeAux.prev.next = nodeAux.next;
				}

				if (nodeAux.next == null) {
					this.lastNode = nodeAux.prev;
				} else {
					nodeAux.next.prev = nodeAux.prev;
				}
				nodeAux = nodeAux.next;
				this.listSize--;

			} else {
				nodeAux = nodeAux.next;
			}
		}
	}

	public void remove(T dataToRemove) {
		DoublyLinkedNode<T> nodeAux = this.firstNode;
		boolean find = false;
		while (nodeAux != null && !find) {
			if (nodeAux.data.equals(dataToRemove)) {
				find = true;
				if (nodeAux.prev == null) {
					this.firstNode = nodeAux.next;
				} else {
					nodeAux.prev.next = nodeAux.next;
				}

				if (nodeAux.next == null) {
					this.lastNode = nodeAux.prev;
				} else {
					nodeAux.next.prev = nodeAux.prev;
				}
				this.listSize--;

			} else {
				nodeAux = nodeAux.next;
			}
		}

	}

	public void destroyList() {
		this.firstNode = null;
		this.lastNode = null;
		this.listSize = 0;
	}

	public String toString() {
		DoublyLinkedNode<T> nodeAux = this.firstNode;
		String salida = "";
		while (nodeAux != null) {
			salida = salida + nodeAux.data + "--";
			nodeAux = nodeAux.next;
		}

		return salida;

	}

}
