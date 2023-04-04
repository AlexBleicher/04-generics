package ohm.softa.a04;

import java.util.function.Function;

public interface SimpleList<T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T o);

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */

	default SimpleList<T> filter(SimpleFilter<T> filter){
		SimpleList<T> result = new SimpleListImpl<T>();
		for(T o: this){
			if(filter.include(o)){
				result.add(o);
			}
		}
		return result;
	}

	default void addDefault(Class<T> clazz) throws IllegalAccessException, InstantiationException {
		add(clazz.newInstance());
	}
	default <R> SimpleList<R> map(Function<T,R> transform){
		SimpleList<R> newList= new SimpleListImpl<>();
		for(T t : this){
			newList.add(transform.apply(t));
		}
		return newList;
	}
}
