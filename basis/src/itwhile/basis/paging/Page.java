/*
 * @(#)Paper.java		1.0.1	2012-08-28
 * 
 * Author bridge
 * CopyRight 2012 snowpack, All rights reserved.
 */

package itwhile.basis.paging;

/**
 * @version Revision: x.x, Date: 2013-6-26, Author: bridge; <br />
 * @version Jul 6, 2015; 2.0.0
 * @version Jul 8, 2015; 2.0.0 
 * @version Nov 24, 2015; 2.0.0 
 * @version Jan 26, 2016; 2.0.0 
 * */
public class Page {
	public static final Integer TEST_SIZE = 5;
	public static final Integer DEFAULT_SIZE = 20;

	// current page index; start by 1;
	private int index;
	// all count
	private long count;
	// page size
	private int size;

	/*
	 * Fields
	 */
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMax() {
		return (int) Math.ceil((double) this.count / this.size);
	}

	/*
         * Contructors
         */
	public Page() {
		this(0, DEFAULT_SIZE);
	}

	public Page(int index) {
		this(index, DEFAULT_SIZE);
	}

	public Page(int index, int size){
		this.index = index;
		this.size = size;
	}
	/*
	 * Methods.s
	 */
	public boolean gotoIndex(int index) {
		if (index > 0 && index < getMax()) {
			this.index = index;
			return true;
		} else {
			this.index = 0;
			return false;
		}
	}

	/**
	 * get start
	 * */
	public int getStart() {
		return this.size * (this.index - 1);
	}

	/**
	 * 
	 * */
	public boolean next() {
		if (index < getMax()) {
			index++;
			return true;
		} else
			return false;
	}

	public boolean previous() {
		if (index > 0) {
			index--;
			return true;
		} else
			return false;
	}

	public boolean first() {
		if (getMax() > 0) {
			index = 1;
			return true;
		} else
			return false;
	}

	public boolean end() {
		if (getMax() > 0) {
			index = getMax();
			return true;
		} else
			return false;
	}

	public boolean isFirst() {
		return index == 1 && getMax() > 0;
	}

	public boolean isEnd() {
		return index == getMax() && getMax() > 0;
	}

}
