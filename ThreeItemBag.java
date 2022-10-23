
import java.util.ArrayList;

public class ThreeItemBag<E> {

    int numberOfItems;
    ArrayList<E> instances;

    public ThreeItemBag() {
        numberOfItems = 0;
        instances = new ArrayList<E>();
    }

    public void addItem(E toAddArg) {
        if (numberOfItems < 3) {
            instances.add(toAddArg);
            numberOfItems = numberOfItems + 1;
        } else {
            for (int index = 1; index < 3; index = index + 1) {
                instances.set(index - 1, instances.get(index));
            }
            instances.set(2, toAddArg);
        }
    }

    public E useItem() throws Exception {
        if (numberOfItems > 0) {
            E toReturn = instances.get(0);
            instances.remove(0);
            numberOfItems = numberOfItems - 1;
            return toReturn;
        } else {
            throw new Exception("No items available to use from bag.");
        }
    }

    public void printItems() {
        E item;
        System.out.println("Contents of bag: ");
        if (numberOfItems > 0) {
            for (int index = 0; index < numberOfItems; index = index + 1) {
                item = instances.get(index);
                System.out.println("\t" + item);
            }
        } else {
            System.out.println("Bag is empty.");
        }
    }
}




