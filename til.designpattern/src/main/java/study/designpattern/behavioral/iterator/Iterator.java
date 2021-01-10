package study.designpattern.behavioral.iterator;

interface Iterator<E> {

  E next();

  boolean hasNext();
}
