package pp.gu.graph;

public class Pair<T1, T2> {
	String beginWord; int i;
	public Pair(String beginWord, int i) {
		// TODO Auto-generated constructor stub
		this.beginWord=beginWord;
		this.i=i;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return beginWord;
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return i;
	}

}
