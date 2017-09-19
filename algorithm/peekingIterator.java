/* Approach: cached the next element */
// Java Iterator interface reference:
class PeekingIterator implements Iterator<Integer> {
    private Integer next = null;
    private Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
        if (iter.hasNext()) {
            // obtain the next element in the constructor, so hasNext() becomes checking next != null
            next  = iter.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}
