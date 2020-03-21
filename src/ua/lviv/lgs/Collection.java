package ua.lviv.lgs;

import java.util.ArrayList;

public class Collection {
	private static Number []array;
	
	Collection(Number [] array){
		Collection.array =array;
	}
	
	private class ForwardIterator implements Iterator{
		private int count=0;

		@Override
		public boolean hasNext() {
			return count<array.length;
		}

		@Override
		public Number next() {
			for(int i=0; i<array.length; i++) {
				if(array[i].intValue()%2!=0)
					array[i]=0;
			}
			return array[count++].intValue();
		}
	}
	public ForwardIterator returnForwardIterator(){
		return new ForwardIterator();
	}
	
	class BackwardIterator implements Iterator{

		private int count=array.length+1;
		@Override
		public boolean hasNext() {
			return count>=0;
		}

		@Override
		public Number next() {
			if(count==1||count==0) {
				System.exit(0);
			}	
			return array[count-=2];
		
		}
	}
	
	public BackwardIterator returnBackwardIterator() {
		return new BackwardIterator();
	}
	
	//MAX
	
	public Iterator createdAnonymous() {
		return new Iterator() {

			private int count=array.length+2;

			@Override
			public boolean hasNext() {
				return count>=0 ;
			}

			@Override
			public Number next() {
				if(count==1||count==0||count==2)
					System.exit(0);
				return array[count-=3];
			}

		};
	}
	public Iterator createdLocal()  {
		class LocalIterator implements Iterator{

			private int count=0;

			@Override
			public boolean hasNext() {
				return count<array.length;
			}

			@Override
			public Number next() {
				return array[count++];
			}
		}
		return new LocalIterator();
	}

	private static class StaticIterator implements Iterator{

		private int count=0;
		@Override
		public boolean hasNext() {
			return count<array.length;
		}

		@Override
		public Number next() {
			return array[count++];
		}
	}
	public static StaticIterator createdStaticIterator(){
		return new StaticIterator();
	}



}
