package uk.ac.ebi.literature.mongodb.util;

import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * Interface to manage the scrollable results coming from the mongoDB database. It implements the AutoClosable interface and supports also streaming iteration. So you can use the try-with-resource statement as shown in the example below.
 *
 ** Example of usage
     * 
     * 
     * 
     * try(Results<AnnotationApi> results= dao.findEntries(COLLECTION_ANNOTATIONS, AnnotationApi.class, query, sortCriteria, pageSize)){
	     * 
	     * results.stream().map(annotationApi -> .....);
     *  }
     *  
     *  
 * @param <T> model class of the elements returned in the iteration
 */
public interface Results<T> extends Iterable<T>, AutoCloseable {
	  /**
	   * close the session and the statement from whom this results set has been retrieved. 
	   */
	  void closeResult();
	  
	  /**
	   * Method to get a stream of object of type T coming from the result set
	   */
	  Stream<T> stream();
	  
	  /**
	   * It scrolls the result set building the list of object of type T and returns it.
	   */
	  List<T> toList();
	}
