import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
  class MedianHeap{
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianHeap(int n){
        maxHeap = new PriorityQueue<Integer>(n,Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(n);
    }
    public void add(int x){
        if(minHeap.isEmpty()) minHeap.offer(x);
	//if x larger than smallest element in minHeap, add to min Heap, else add to maxHeap
        else if(x>minHeap.peek()) minHeap.offer(x);
        else maxHeap.offer(x);
	//rebalace heaps(swap min with max top element)
        if(minHeap.size()-maxHeap.size()>1) 
            maxHeap.add(minHeap.poll());
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.poll());
        }
        
    }
    public double getMedian(){
        // if(maxHeap.isEmpty()&&meanHeap.isEmpty()) return Integer.MIN_VALUE;
	//if same size,then even number of elements, get average of top 2
        if(maxHeap.size()==minHeap.size()) return (minHeap.peek()+maxHeap.peek()+0.0)/2;
	//else get element from heap with largest size
        if(maxHeap.size()>minHeap.size()) return maxHeap.peek()+0.0;
        return minHeap.peek()+0.0;
    }
    }
public class Solution {
  

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        MedianHeap mh=new MedianHeap(n);
        for(int a_i=0; a_i < n; a_i++){
            int i = in.nextInt();
            mh.add(i);
            System.out.println(mh.getMedian());
        }
    }
}