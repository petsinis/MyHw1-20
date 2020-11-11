//package binarytree;


import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public aspect AspectSynchronized {

	public ReadersWritersLock BinaryTree<T>.locktree = new ReadersWritersLock();

    
    pointcut insert_delete_pointcut(BinaryTree t, Comparable k):
    (target(t) && execution(public boolean BinaryTree.insert(Comparable)) && args(k))||	
    (target(t) && execution(public boolean BinaryTree.remove(Comparable)) && args(k));
    
    pointcut lookup_pointcut(BinaryTree t, Comparable k):
    (target(t) && execution(public boolean BinaryTree.lookup(Comparable)) && args(k));
    
    
    
    boolean around(BinaryTree t, Comparable k): insert_delete_pointcut(t, k) {
        try {
            t.locktree.enterWrite();
        	System.out.println("Inserting/Deleting "+k+" in "+t.toString());
            boolean b=proceed(t, k);
            System.out.println("Finishing Inserting/Deleting "+k+" in "+t.toString());
            t.locktree.exitWrite();
            return b;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
		return false;
        
    }
    
    boolean around(BinaryTree t, Comparable k): lookup_pointcut(t, k) {
        try {
            t.locktree.enterRead();
            System.out.println("Lookuping "+k+" in "+t.toString());
            boolean b=proceed(t, k);
            System.out.println("Finishing Lookuping "+k+" in "+t.toString());
            t.locktree.exitRead();
            return b;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
		return false;
        
    }
    
    
    
}
