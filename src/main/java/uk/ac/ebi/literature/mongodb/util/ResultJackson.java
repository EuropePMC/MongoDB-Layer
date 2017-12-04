package uk.ac.ebi.literature.mongodb.util;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.mongojack.DBCursor;

public class ResultJackson<T> implements Results<T> {

	
	DBCursor<T> dataCursor;
	
	public ResultJackson (DBCursor dataCursorData){
		this.dataCursor = dataCursorData;
	}

	
	public Iterator<T> iterator() {
		return new ResultsIterator<T>(dataCursor);
	}

	public void closeResult() {
		dataCursor.close();
	}
	
	public class ResultsIterator<E> implements Iterator<E>{

		DBCursor<E> resMongoDb;
		
		public ResultsIterator(DBCursor<E> resMongoDb){
			this.resMongoDb = resMongoDb;
		}
		
		public boolean hasNext() {
			return resMongoDb.hasNext();
		}

		public E next() {
			return resMongoDb.next();
		}

		public void remove() {
			
		}
		
	}

	@Override
	public void close() throws Exception {
		this.closeResult();
	}


	@Override
	public Stream<T> stream() {
		Iterator<T> sourceIterator = this.iterator();

		Iterable<T> iterable = () -> sourceIterator;
		Stream<T> targetStream = StreamSupport.stream(iterable.spliterator(), false);
		
		return targetStream;
	}


	@Override
	public List<T> toList() {
		return this.stream().collect(Collectors.<T>toList());
	}

}
