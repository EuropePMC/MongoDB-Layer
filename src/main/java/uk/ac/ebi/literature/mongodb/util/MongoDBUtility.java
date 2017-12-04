package uk.ac.ebi.literature.mongodb.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import uk.ac.ebi.literature.mongodb.dao.ICrudDAO.MONGODB_URL;

public class MongoDBUtility {

	public static <T> T parseJson(String json, Class<T> modelClass) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
	    T result = mapper.readValue(json, modelClass);
	    return result;
	}
	
	public static boolean isStringEmpty(String string){
		boolean isEmpty =false;
		if(string==null || string.trim().equals("")){
			isEmpty=true;
		}
		return isEmpty;
	}
	
	public static boolean isListEmpty(List<?> list){
		boolean isEmpty =false;
		if(list==null || (list.size()==0)){
			isEmpty=true;
		}
		return isEmpty;
	}
	
	public static <T> T parseJson(String json, TypeReference<T> modelClass) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
	    T result = mapper.readValue(json, modelClass);
	    return result;
	}
	
	public static <T> List<T> parseJsonList(String json, Class<T> classList) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		List<T> result = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, classList));
	    return result;
	}
	
	public static <T> T parseMap(Map<String, Object> values, Class<T> objectType) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		T ret =objectType.newInstance();
		
		Object val;
		String methodName;
		Method method;
		for (Entry<String,Object> mapEntries : values.entrySet()){
			methodName = mapEntries.getKey();
			methodName = "set"+methodName.substring(0, 1).toUpperCase()+methodName.substring(1);
			val = mapEntries.getValue();
			try{
				method = objectType.getMethod(methodName, val.getClass());
			}catch (NoSuchMethodException e){
				if (val instanceof List){
					method = objectType.getMethod(methodName, List.class);
				}else{
					throw e;
				}
			}
					
			method.invoke(ret, val);
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @param dbUrl string representing one DB_URL element.
	 * @return the DB URL matching the string. If no match is found it returns HX_TEST
	 */
	public static MONGODB_URL getMongoDBUrl(String dbUrl){
		MONGODB_URL ret=null;
		
		try{
			ret = MONGODB_URL.valueOf(dbUrl);
		}catch (Exception e){
			ret=null;
		}
		
		if (ret==null){
			ret=MONGODB_URL.HX_TEST;
		}
		
		return ret;
    }
	
	/**
	 * Method to check that two lists contains the same values regardless of the order of elements inside them
	 * @param list1
	 * @param list2
	 * @return true if the two list contains exactly the same values regardless of the order inside them
	 */
	public static <T> boolean equalsList(List<T> list1, List<T> list2){
		
		if ((list1==null && list2==null)){
			return true;
		}
		
		if ((list1== null&& list2!=null) || (list1!=null && list2==null)) {
				return false;
		}

		if (list1.size()!=list2.size()){
			return false;
		}
		
		for (T val : list1){
			if (list2.contains(val)==false){
				return false;
			}
		}
		
		for (T val : list2){
			if (list1.contains(val)==false){
				return false;
			}
		}
		
		return true;
	}
}
