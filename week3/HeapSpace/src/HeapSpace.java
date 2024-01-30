import edu.princeton.cs.algs4.BST;

public class HeapSpace {
    BST<String, Integer> mybst = new BST<>();  // Heap memory error with String keys??

    // Note:  FIRST set VM heap space to 100M with -Xmx100M VM option!
    public void start() {
        for (int num = 1; ; num++) {
            if (num % 1000 == 0) System.out.println(num + " treeheight=" + mybst.height()); //print every 1000th item
            mybst.put(("test" + num), num); // use mybst.put((num), num) to add Integers instead of Strings
        }
    }

    public static void main(String[] args) {
        new HeapSpace().start();
    }
}
