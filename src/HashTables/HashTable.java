package HashTables;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K,V> {
    private ArrayList<HashNode<K,V>> BucketArray;
    private int numbuckets;
    private int size;
    public HashTable(int capacity){
        BucketArray = new ArrayList<>();
        this.numbuckets = capacity;
        size=0;
        for(int i=0;i<numbuckets;i++){
            BucketArray.add(null);
        }
    }
    private int hashcode(K key){
        return Objects.hashCode(key);
    }
    public int getbucketindex(K key){
        int hashnode = hashcode(key);
        int index = hashnode%numbuckets;
        index  = (index<0) ? index*-1:index;
        return index;
    }
    public V get(K key){
        int bucketIndex = getbucketindex(key);
        int hashcode = hashcode(key);
        HashNode<K,V> head = BucketArray.get(bucketIndex);
        while(head!=null){
            if(head.key.equals((key)) && head.hashcode==hashcode){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    public void add(K key, V value)
    {
        // Find head of chain for given key
        int bucketIndex = getbucketindex(key);
        int hashcode = hashcode(key);
        HashNode<K, V> head = BucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key) && head.hashcode == hashcode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = BucketArray.get(bucketIndex);
        HashNode<K, V> newNode
                = new HashNode<K, V>(hashcode, key, value);
        newNode.next = head;
        BucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / numbuckets >= 0.7) {
            ArrayList<HashNode<K, V> > temp = BucketArray;
            BucketArray = new ArrayList<>();
            numbuckets = 2 * numbuckets;
            size = 0;
            for (int i = 0; i < numbuckets; i++)
                BucketArray.add(null);
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
    public void remove(K key)
    {
        // Apply hash function to find index for given key
        int bucketIndex = getbucketindex(key);
        int hashCode = hashcode(key);
        // Get head of chain
        HashNode<K, V> head = BucketArray.get(bucketIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key) && hashCode == head.hashcode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            BucketArray.set(bucketIndex, head.next);

    }
}
