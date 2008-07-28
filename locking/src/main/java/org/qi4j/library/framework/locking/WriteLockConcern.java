package org.qi4j.library.framework.locking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReadWriteLock;
import org.qi4j.composite.AppliesTo;
import org.qi4j.composite.ConcernOf;
import org.qi4j.injection.scope.This;

/**
 * Applies write-lock to Composite
 */
@AppliesTo( WriteLock.class )
public class WriteLockConcern extends ConcernOf<InvocationHandler>
    implements InvocationHandler
{
    private @This ReadWriteLock lock;

    public Object invoke( Object o, Method method, Object[] objects ) throws Throwable
    {
        lock.writeLock().lock();
        try
        {
            return next.invoke( o, method, objects );
        }
        finally
        {
            lock.writeLock().unlock();
        }
    }
}