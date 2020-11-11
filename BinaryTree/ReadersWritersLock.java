//package binarytree;

public class ReadersWritersLock {
	boolean writer;
	int readers;
	
	public ReadersWritersLock() {
        writer = false;
        readers = 0;
    }
	
	public synchronized void enterRead() throws InterruptedException {
		while(writer){
			wait();
		}
		readers++;
	}
	
	public synchronized void enterWrite() throws InterruptedException {
		while(writer||readers>0) {
			wait();
		}
		writer=true;
	}
	
	public synchronized void exitRead(){
		readers--;
		if(readers==0) {
			notify();
		}
	}
	
	
	public synchronized void exitWrite() {
		writer=false;
		notifyAll();
	}
	
	
}
