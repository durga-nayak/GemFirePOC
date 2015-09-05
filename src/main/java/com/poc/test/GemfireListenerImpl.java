/**
 * 
 */
package com.poc.test;

import org.springframework.stereotype.Component;

import com.gemstone.gemfire.cache.CacheListener;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.RegionEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;
import com.gemstone.gemfire.internal.cache.tier.sockets.CacheClientNotifier;
import com.springsource.vfabric.licensing.log.Logger;

/**
 * @author NAYAKDUR
 *
 */
@Component
public class GemfireListenerImpl implements  CacheListener{

    Logger log = Logger.getLogger(GemfireListenerImpl.class);

    public void print(EntryEvent event){
    	 final String regionName = event.getRegion().getName();
         final Object key = event.getKey();
         final Object newValue = event.getNewValue();
         System.out.println("In region [" + regionName + "] "+event.toString()+" key [" + key
             + "] value [" + newValue + "]");
    }
	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void afterCreate(EntryEvent paramEntryEvent) {
		// TODO Auto-generated method stub
		print(paramEntryEvent);
	}

	public void afterUpdate(EntryEvent paramEntryEvent) {
		// TODO Auto-generated method stub
		print(paramEntryEvent);
		
	}

	public void afterInvalidate(EntryEvent paramEntryEvent) {
		// TODO Auto-generated method stub
		print(paramEntryEvent);
		
	}

	public void afterDestroy(EntryEvent paramEntryEvent) {
		// TODO Auto-generated method stub
		print(paramEntryEvent);
		
	}

	public void afterRegionInvalidate(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
//		print(paramEntryEvent);
	}

	public void afterRegionDestroy(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		
	}

	public void afterRegionClear(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		System.out.println("paramRegionEvent");
	}

	public void afterRegionCreate(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		
	}

	public void afterRegionLive(RegionEvent paramRegionEvent) {
		// TODO Auto-generated method stub
		System.out.println("paramRegionEvent3");
		
	}

    
}