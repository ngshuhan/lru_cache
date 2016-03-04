# LRU Caching
This is a simple implementation of LRU (Least Recent Used) Algorithm with Javascript. The data structure is also tested with mocha in browser.  (Just updated the JAVA version, but have not done the unit test)

**Unit Test**
![screen shot 2016-03-02 at 11 13 57 pm](https://cloud.githubusercontent.com/assets/15684513/13487166/8310064a-e0cc-11e5-9351-2c1faab90eb8.png)

##API

- ``` put(key,value)```

Put the key value pair into the cache. If the cache is full, remove the least used item to make space. 

- ``` remove(key) ```

Remove and return the entry in the cache that associates with the given key. Return ```undefined``` if the key does not exist in the cache.

- ```removeAll() ```

Clear the cache by reseting it to be empty.

- ```get(key)```

Return and register recent use of the entry in the cache with the given key. If the key does not exist in the cache, return ``` undefined```





