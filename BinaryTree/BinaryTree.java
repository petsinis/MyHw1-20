/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package binarytree;


import java.util.concurrent.atomic.AtomicBoolean;


public class BinaryTree<T extends Comparable<T>> {

    /**
     * @param args the command line arguments
     */
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private int num_of_el;
    private AtomicBoolean indel; //Used only for testing AspectSynchronized
    private AtomicBoolean look;  //Used only for testing AspectSynchronized
    
    public BinaryTree(){
        data=null;
        left=null;
        right=null;
        num_of_el=0;
        indel=new AtomicBoolean();
        indel.set(false);
        look=new AtomicBoolean();
        look.set(false);
    }
    
    
    public BinaryTree(T data){
        this.data=data;
        left=null;
        right=null;
        num_of_el=1;
        indel=new AtomicBoolean();
        indel.set(false);
        look=new AtomicBoolean();
        look.set(false);
        
    }
    
    public void test(Integer k) {
    	System.out.println("it is:"+k);
    }
    
    public  boolean insert(T new_data){
    	if(look.get()||indel.get()) {
    		System.out.println("(Insert) Can't write, when read or write..."); //Just for testing
    	    System.exit(1);
    		//throw new AccessControlException("Can't write, when read or write...");
    		
    	}
    	indel.set(true);
        BinaryTree<T> checking_tree=this;
        BinaryTree<T> temp_tree=null;
        boolean flag=false;
        int path=0;
        
        if(checking_tree.data==null) {
        	checking_tree.data=new_data;
        	num_of_el++;
        	indel.set(false);
        	return(true);
        }
        
        while(!flag){
            if(new_data.compareTo((T) checking_tree.data)<0){//smaller
                temp_tree=checking_tree;
                path=-1;
                checking_tree=checking_tree.left;
                
            } 
            else if(new_data.compareTo((T) checking_tree.data)>0){//bigger
                temp_tree=checking_tree;
                path=1;
                checking_tree=checking_tree.right;
                
            }
            else{
            	indel.set(false);
                return false;
            }
            if(checking_tree==null){
                checking_tree=new BinaryTree<>(new_data);
                if(path<0){
                    temp_tree.left=checking_tree;
                }
                else{
                    temp_tree.right=checking_tree;
                }
                flag=true;
            }
            
        }
        num_of_el=num_of_el+1;
        indel.set(false);
        return true;
        
    }
    
    public boolean lookup(T old_data){
    	if(indel.get()) {
    		System.out.println("(Lookup) Can't read, when write..."); //Just for testing
    	    System.exit(1);
    		//throw new AccessControlException("Can't read, when write...");
    	}
    	look.set(true);
        BinaryTree<T> checking_tree=this;

        if(checking_tree.data==null) {
        	look.set(false);
        	return(false);
        }
        
        
        while(true){
            if(old_data.compareTo((T) checking_tree.data)<0){//smaller
                checking_tree=checking_tree.left;      
            } 
            else if(old_data.compareTo((T) checking_tree.data)>0){//bigger
                checking_tree=checking_tree.right;
                
            }
            else{
            	look.set(false);
                return true;
            }
            if(checking_tree==null){
            	look.set(false);
                return false;
            }
            
        }

        
            
        
        
    }
    
    
    
    private T findLeft(BinaryTree<T> tree,BinaryTree<T> root){
        if(tree.left==null){
            root.left=null;
            return tree.data;
        }   
        return(findLeft(tree.left, tree));    
    }
    
     private T findRight(BinaryTree<T> tree,BinaryTree<T> root){
        if(tree.right==null){
            root.right=null;
            return tree.data;
        }   
        return(findRight(tree.right, tree));    
    }
    
    
    private boolean deleteRoot(BinaryTree<T> root){
        T new_root_data;
        if(root.right==null&&root.left==null) {
        	return false;
        }
        else if(root.right!=null) {
	        if(root.right.left!=null){
	            new_root_data=findLeft(root.right.left, root.right);
	            root.data=new_root_data;
	            return true;
	        }
        }
        else if(root.right!=null) {
	         if(root.left.right!=null){
	            new_root_data=findRight(root.left.right, root.left);
	            root.data=new_root_data;
	            return true;
	        }
        }
   
		return false;
        
        
    }
    
    public boolean remove(T old_data){
    	if(look.get()||indel.get()) {
    		System.out.println("(Remove) Can't write, when write or read..."); //Just for testing
    	    System.exit(1);
    		//throw new AccessControlException("Can't write, when write or read...");
    	}
    	indel.set(true);
        BinaryTree<T> checking_tree=this;
        BinaryTree<T> temp_tree=null;
        boolean flag=false;
        int path=0;
        
        if(data==null||this==null) {
        	indel.set(false);
        	return false;
        }
        
        while(!flag){
            if(old_data.compareTo((T) checking_tree.data)<0){//smaller
                temp_tree=checking_tree;
                path=-1;
                checking_tree=checking_tree.left;
                
            } 
            else if(old_data.compareTo((T) checking_tree.data)>0){//bigger
                temp_tree=checking_tree;
                path=1;
                checking_tree=checking_tree.right;
                
            }
            else{
                if(!deleteRoot(checking_tree)){
                    if(path<0){
                        temp_tree.left=null;
                    }
                    else if(path>0){
                        temp_tree.right=null;
                    }
                    else{
                        this.data=null;
                    }
                }
                flag=true;
                num_of_el--;
                indel.set(false);
                return true;
            }
            if(checking_tree==null){
            	indel.set(false);
                return false;
            }
            
        }
        num_of_el--;
        indel.set(false);
        return true;
        
        
        
        
        
    }
    
    
    
    public void printTree(){
        printTree(this);
    }
    
    public void printTree( BinaryTree<T> root){
        if(root==null){
            
            return;
        }
              
        if(root.left!=null){System.out.println("left");}

       
        printTree(root.left); 
        
        System.out.println(root.data);
        
         if(root.right==null){System.out.println("up");}
        
        
        if(root.right!=null){System.out.println("right");}
        printTree(root.right); 
        
    }
    
    
    
    public synchronized  void printTree2(){
        printTree2(this);
    }
    
    public synchronized void printTree2( BinaryTree<T> root){

        String left="null", right="null";
        if(root.left!=null){
            left=""+root.left.data;
        }
        if(root.right!=null){
            right=""+root.right.data;
        }
        System.out.println(left+"<-"+root.data+"->"+right);
        System.out.println("---------------------------------------------");
        if(root.left!=null){
            printTree2(root.left);
        }
        if(root.right!=null){
            printTree2(root.right);
        }
        if(root.right==null&&root.right==null){
            return;
        }
        
    }
    
    
    void printLevelOrder()
    {
        int h = height(this);
        int i;
        for (i=1; i<=h; i++) {
            printGivenLevel(this, i);
        	System.out.println("");
        }	
    }
 

    int height(BinaryTree<T> root)
    {
        if (root == null)
           return 0;
        else
        {
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
 
    void printGivenLevel (BinaryTree<T> root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    
    
    public int get_num_of_elements() {
    	return num_of_el;
    }
    
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
    	
    	BinaryTree<Integer> T1=new BinaryTree<Integer>();
    	BinaryTree<Integer> T2=new BinaryTree<Integer>();
    	BinaryTree<Integer> T3=new BinaryTree<Integer>();
    	
    	
    	Thread Thr1 = new Thread(() -> {
            for (int i = 0; i < 250; i++) {
                T1.insert(i);
                T1.lookup(i);
                //T1.remove(i); //*****Uncomment for removing...*****
            }
        });
    	
    	
    	Thread Thr2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                T2.insert(i);
                T3.insert(i);
            }
        });
    	
    	Thread Thr3 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                T2.lookup(i);
                T3.lookup(i);
            }
        });
    	
    	Thread Thr4 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                T2.remove(i);
                T3.remove(i);
            }
        });
        
    	Thr1.start();
    	Thr2.start();
        Thr3.start();
        //Thr4.start(); //*****Uncomment for removing...*****
       
    	while(Thr1.isAlive()||Thr2.isAlive()||Thr3.isAlive()||Thr4.isAlive()) {
    		
    	}
    	System.out.println();
    	System.out.println("T1: number of elements: "+T1.get_num_of_elements()); //Without removing must print "T1: number of elements: 250"
    	System.out.println("T2: number of elements: "+T2.get_num_of_elements()); //Without removing must print "T2: number of elements: 500"
    	System.out.println("T3: number of elements: "+T3.get_num_of_elements()); //Without removing must print "T3: number of elements: 500"
    	System.out.println();
    	System.out.println("Finished Successfully...");
    	
    }
    
}
