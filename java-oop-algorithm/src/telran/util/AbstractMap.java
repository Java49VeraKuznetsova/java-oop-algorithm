package telran.util;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	protected Set<Entry<K, V>> set;
	@Override
	public V get(K key) {
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		
		return entry == null ? null : entry.getValue();
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		V res = null;
		if (entry != null) {
			res = entry.getValue();
			entry.setValue(value);
		} else {
			set.add(new Entry<>(key, value));
		}
		return res;
	}

	@Override
	public boolean containsKey(K key) {
		//  Auto-generated method stub
		if (key == null) {
			throw new NullPointerException("key is null");
		}
		
		return set.contains(new Entry<>(key, null));
	}

	@Override
	public boolean containsValue(V value) {
		//  Auto-generated method stub
		if (value == null) {
			throw new NullPointerException("value is null");
		}
		Collection <V> values = values();
		return values.contains(value);
	}

	@Override
	public Set<K> keySet() {
		Set<K> res = getKeySet();
		set.stream()
		.map(e -> e.getKey())
		.forEach(key -> res.add(key));
		return res;
	}

	abstract protected Set<K> getKeySet();

	@Override
	public Collection<V> values() {
		//  Auto-generated method stub
		List<V> res = new ArrayList<>();
		set.stream()
		.map(e -> e.getValue())
		.forEach(value -> res.add(value));
		return res;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		
		return set;
	}
	@Override
	public V remove(K key) {
		// 
		if (key == null) {
			throw new NullPointerException("key is null");
		}
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		V res = null;
		if(set.remove(entry)) {
			res = get(key);
			
		}
		return res;
	}

}