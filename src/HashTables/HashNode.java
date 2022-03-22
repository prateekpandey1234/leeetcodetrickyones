package HashTables;

public class HashNode<K,V> {
    K key;
    V value;
    final int hashcode;
    HashNode<K,V> next;
    public HashNode(int hashcode, K Key,V value) {
        this.key=Key;
        this.value=value;
        this.hashcode = hashcode;
    }
}
