class InsertionSort {
  private void dumpState(int j, List<Integer> list) {
        for(int i =0; i < list.size(); i++ ) {
            
           if (i == j) {
               System.out.print("(" + list.get(i) + ")");
           }else {
               System.out.print(list.get(i));
           }
           System.out.print(", ");
        }
        //try {
            //TimeUnit.SECONDS.sleep(2);
        //} catch (InterruptedException ex) {
            //Logger.getLogger(SortingExamples.class.getName()).log(Level.SEVERE, null, ex);
        //}
        System.out.println("");
    }
    
    public boolean insertionSort(List<Integer> mylist) {
        if (null == mylist) {
            System.out.println("Cannot sort a null list");
            return false;
        }
        
        if (mylist.isEmpty()) {
            System.out.println("Cannot sort an empty list");
            return false;
        }
        
        for (int i = 1; i < mylist.size(); i++) {
            int j = i;
            int testvar = mylist.get(i);
            System.out.print("Testing " + testvar + ": ");
            dumpState(j, mylist);
            
            while (j > 0 && mylist.get(j-1) > testvar ) {
                System.out.println(mylist.get(j-1) + " > " + testvar);
                mylist.set(j, mylist.get(j-1));
                //unsorted.set(j-1,0);
                j = j-1;
                
                //dumpState(testvar, data);
            }
            mylist.set(j, testvar);
        }
        return true;
    }
}