package itwhile.basis.util.tree;

import java.util.Collection;

public interface Node<E, T> {

  public T getId();

  public T getParent();

  public Collection<E> getChildren();

  public void addChild(E child);
  
}
