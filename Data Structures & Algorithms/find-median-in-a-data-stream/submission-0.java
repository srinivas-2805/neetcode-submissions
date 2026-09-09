class MedianFinder {
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
        minheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty() || num<=maxheap.peek()){
            maxheap.add(num);
        }
        else{
            minheap.add(num);
        }
        if(maxheap.size()>minheap.size()+1){
            minheap.add(maxheap.poll());
        }

        else if(minheap.size()>maxheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()>minheap.size()){
           return  maxheap.peek();
        }
        else{
            return (maxheap.peek()+minheap.peek())/2.0;
        }
    }
}
