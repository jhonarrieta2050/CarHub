package org.carhub.java.controllerss;

public interface ControllerInterface<T> {
    public boolean add(String... info);
    public boolean remove(String... info);
    public T search(String... info);

}
