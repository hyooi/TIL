package study.designpattern.behavioral.iterator;

import java.util.NoSuchElementException;

interface Aggregate<E> {

  Iterator<E> createIterator();

  boolean add(E element);
}

class Aggregate1<E> implements Aggregate<E> { // E = Type parameter

  // Hiding the representation.
  private Object[] elementData; // represented as object array
  private int idx = 0;
  private int size;

  Aggregate1(int size) {
    if (size < 0) {
      throw new IllegalArgumentException("size: " + size);
    }
    this.size = size;
    elementData = new Object[size];
  }

  public boolean add(E element) {
    if (idx < size) {
      elementData[idx++] = element;
      return true;
    } else {
      return false;
    }
  }

  int getSize() {
    return size;
  }

  public Iterator<E> createIterator() {
    return new Iterator1<E>();
  }

  //
  // Implementing Iterator1 as inner class.
  //
  private class Iterator1<E> implements Iterator<E> {

    // Holds the current position in the traversal.
    private int cursor = 0; // index of next element to return

    public boolean hasNext() {
      return cursor < size;
    }

    public E next() { // E = Type of element returned by this method
      if (cursor >= size) {
        throw new NoSuchElementException();
      }
      return (E) elementData[cursor++]; // cast from Object to E
    }
  }
}