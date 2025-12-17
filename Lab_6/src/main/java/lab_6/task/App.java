package lab_6.task;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;


class Car {
    private String brand;
    private double price;
    private double fuelConsumption;
    private int maxSpeed;

    public Car(String brand, double price, double fuelConsumption, int maxSpeed) {
        this.brand = brand;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public double getFuelConsumption() { return fuelConsumption; }
    public int getMaxSpeed() { return maxSpeed; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) return false;
        Car c = (Car) obj;
        return brand.equals(c.brand) && price == c.price &&
               fuelConsumption == c.fuelConsumption && maxSpeed == c.maxSpeed;
    }

    @Override
    public int hashCode() {
        return brand.hashCode() + (int)price + (int)fuelConsumption + maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s: price=%.2f, fuel=%.1f, speed=%d", brand, price, fuelConsumption, maxSpeed);
    }
}


class ArraySet<E> implements Set<E> {
    private Object[] elements;
    private int size;
    private int capacity;
    private static final int INITIAL_CAPACITY = 15;

    public ArraySet() {
        this.capacity = INITIAL_CAPACITY;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public ArraySet(E element) {
        this();
        add(element);
    }

    public ArraySet(Collection<? extends E> collection) {
        this();
        for (E e : collection) add(e);
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            int newCapacity = capacity + (int)(capacity * 0.3) + 1;
            Object[] newArr = new Object[newCapacity];
            System.arraycopy(elements, 0, newArr, 0, size);
            elements = newArr;
            capacity = newCapacity;
        }
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) return false;
        ensureCapacity();
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public int size() { return size; }
    @Override
    public boolean isEmpty() { return size == 0; }
    @Override
    public void clear() { for (int i = 0; i < size; i++) elements[i] = null; size = 0; }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int idx = 0;
            public boolean hasNext() { return idx < size; }
            @SuppressWarnings("unchecked")
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (E) elements[idx++];
            }
        };
    }
    @Override public Object[] toArray() { Object[] arr = new Object[size]; System.arraycopy(elements, 0, arr, 0, size); return arr; }
    @Override public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException(); }
    @Override public boolean containsAll(Collection<?> c) { for (Object o : c) if (!contains(o)) return false; return true; }
    @Override public boolean addAll(Collection<? extends E> c) { boolean changed = false; for (E e : c) if (add(e)) changed = true; return changed; }
    @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean removeAll(Collection<?> c) { boolean changed = false; for (Object o : c) if (remove(o)) changed = true; return changed; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ArraySet{");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}


public class App {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota Camry", 25000, 7.5, 210);
        Car car2 = new Car("Honda CR-V", 32000, 8.2, 200);
        Car car3 = new Car("Ford Fiesta", 18000, 5.9, 190);

        ArraySet<Car> set1 = new ArraySet<>();
        ArraySet<Car> set2 = new ArraySet<>(car1);
        java.util.List<Car> carList = java.util.Arrays.asList(car1, car2, car3);
        ArraySet<Car> set3 = new ArraySet<>(carList);

        set1.add(car2);
        set1.add(car3);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);

        System.out.println("Set3 contains car1? " + set3.contains(car1));
        set3.remove(car2);
        System.out.println("Set3 after removing car2: " + set3);

        for (int i = 0; i < 20; i++) {
            set1.add(new Car("Car" + i, 10000 + i * 1000, 6.0 + i * 0.1, 180 + i));
        }
        System.out.println("Set1 after adding 20 cars: size=" + set1.size());
    }
}
