/**
 * 
 */
package com.poc.test;

import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;
import com.springsource.vfabric.licensing.log.Logger;

/**
 * @author NAYAKDUR
 *
 */
@Component
public class GemfireListener extends CacheListenerAdapter {

    Logger log = Logger.getLogger(GemfireListener.class);

    @Override
    public void afterCreate(EntryEvent event) {
        final String regionName = event.getRegion().getName();
        final Object key = event.getKey();
        final Object newValue = event.getNewValue();
        System.out.println("In region [" + regionName + "] created key [" + key
            + "] value [" + newValue + "]");
    }

    @Override
    public void afterDestroy(EntryEvent event) {
        final String regionName = event.getRegion().getName();
        final Object key = event.getKey();
        System.out.println("In region [" + regionName + "] destroyed key [" + key
            + "]");
    }

    @Override
    public void afterUpdate(EntryEvent event) {
        final String regionName = event.getRegion().getName();
        final Object key = event.getKey();
        final Object newValue = event.getNewValue();
        final Object oldValue = event.getOldValue();
        System.out.println("In region [" + regionName + "] updated key [" + key
            + "] [oldValue [" + oldValue + "] new value [" + newValue + "]");
    }
}