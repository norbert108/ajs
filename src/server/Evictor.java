package server;

import Ice.Identity;

import java.util.HashMap;
import java.util.Map;

// TODO: implementacja add i evict normalnie
public class Evictor implements Ice.ServantLocator
{
    private class EvictorEntry{
        Ice.Object servant;
        java.lang.Object cookie;
        java.util.Iterator<Ice.Identity> queuePos;
        int useCount;
    }

    private LinkedList<Identity> _queue;
    private Map<Ice.Identity, EvictorEntry> _map;
    private int _queueSize;

    public Evictor(Integer size)
    {
        this._queueSize = size;

        _queue = new LinkedList<>();
        _map = new HashMap<>();
    }

    public Ice.Object locate(Ice.Current curr, Ice.LocalObjectHolder cookie) throws Ice.UserException
    {
        EvictorEntry entry = _map.get(curr.id);
        if (entry != null) {
            entry.queuePos.remove();
        } else {
            Ice.LocalObjectHolder cookieHolder = new Ice.LocalObjectHolder();

            entry = new EvictorEntry();
            entry.servant = add(curr, cookieHolder);
            if (entry.servant == null) {
                return null;
            }
            entry.cookie = cookieHolder.value;
            entry.useCount = 0;
            _map.put(curr.id, entry);
        }

        ++(entry.useCount);
        _queue.addFirst(curr.id);
        entry.queuePos = _queue.iterator();
        entry.queuePos.next();

        cookie.value = entry;
        return entry.servant;
    }

    public void finished(Ice.Current curr, Ice.Object servant, java.lang.Object cookie) throws Ice.UserException
    {
        EvictorEntry entry = (EvictorEntry)cookie;

        --(entry.useCount);
        evictServants();
    }

    public void deactivate(String category) {
        _queueSize = 0;
        evictServants();
    }

    private void evictServants(){
        java.util.Iterator<Ice.Identity> p = _queue.riterator();
        int excessEntries = _map.size() - _queueSize;
        for (int i = 0; i < excessEntries; ++i) {
            Ice.Identity id = p.next();
            EvictorEntry e = _map.get(id);
            if (e.useCount == 0) {
                evict(e.servant, e.cookie);
                e.queuePos.remove();
                _map.remove(id);
            }
        }
    }

    public Ice.Object add(Ice.Current curr, Ice.LocalObjectHolder cookie){
        return new AccountImpl();
    }

    public void evict(Ice.Object servant, java.lang.Object cookie){
        // nothin'
    }
}
