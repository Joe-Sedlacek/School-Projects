public class Main {


        public static void main(String[] args) {

            // TODO: After implementing the generic version of the ThreeItemBag class,
            // comment out the first try/catch block below and uncomment the next two try/catch blocks
            // Appropriate changes to ThreeItemBag will support having a ThreeItemBag holding Integers,
            // and another ThreeItemBag holding Strings
/*
            try {
                ThreeItemBag playerBag = new ThreeItemBag();
                playerBag.addItem(7);
                playerBag.addItem(12);
                playerBag.printItems();
                Integer value =  playerBag.useItem();
                System.out.println("Item from bag used is: " + value);
                playerBag.printItems();
                playerBag.addItem(15);
                playerBag.addItem(8);
                playerBag.addItem(4);
                playerBag.printItems();
                value = playerBag.useItem();
                System.out.println("Item from bag used is: " + value);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}
*/



            try {
                ThreeItemBag<Integer> playerBag = new ThreeItemBag<Integer>();
                playerBag.addItem(7);
                playerBag.addItem(12);
                playerBag.printItems();
                Integer value = playerBag.useItem();
                System.out.println("Item from bag used is: " + value.toString());
                playerBag.printItems();
                playerBag.addItem(15);
                playerBag.addItem(8);
                playerBag.addItem(4);
                playerBag.printItems();
                value = playerBag.useItem();
                System.out.println("Item from bag used is: " + value.toString());
            }
            catch (Exception exception) {
                System.out.println(exception);
            }

            try {
                ThreeItemBag<String> playerStringBag = new ThreeItemBag<String>();
                playerStringBag.addItem("Bob");
                playerStringBag.addItem("Susan");
                String objectObtained = playerStringBag.useItem();
                System.out.println("Item from bag used is: " + objectObtained.toString());
                playerStringBag.printItems();
            }
            catch (Exception exception) {
                System.out.println(exception);
            }



        }
    }


