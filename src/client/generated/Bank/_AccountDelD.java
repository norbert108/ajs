// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `Bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package client.generated.Bank;

public final class _AccountDelD extends Ice._ObjectDelD implements _AccountDel
{
    public String getAccountNumber(java.util.Map<String, String> __ctx, Ice.Instrumentation.InvocationObserver __observer)
        throws IceInternal.LocalExceptionWrapper
    {
        final Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getAccountNumber", Ice.OperationMode.Normal, __ctx);
        final Ice.StringHolder __result = new Ice.StringHolder();
        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {
                public Ice.DispatchStatus run(Ice.Object __obj)
                {
                    Account __servant = null;
                    if(__obj == null || __obj instanceof Account)
                    {
                        __servant = (Account)__obj;
                    }
                    else
                    {
                        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
                    }
                    __result.value = __servant.getAccountNumber(__current);
                    return Ice.DispatchStatus.DispatchOK;
                }
            };
            try
            {
                Ice.DispatchStatus __status = __direct.getServant().__collocDispatch(__direct);
                if(__status == Ice.DispatchStatus.DispatchUserException)
                {
                    __direct.throwUserException();
                }
                assert __status == Ice.DispatchStatus.DispatchOK;
                return __result.value;
            }
            finally
            {
                __direct.destroy();
            }
        }
        catch(Ice.SystemException __ex)
        {
            throw __ex;
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwWrapper(__ex);
        }
        return __result.value;
    }

    public int getBalance(java.util.Map<String, String> __ctx, Ice.Instrumentation.InvocationObserver __observer)
        throws IceInternal.LocalExceptionWrapper
    {
        final Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getBalance", Ice.OperationMode.Normal, __ctx);
        final Ice.IntHolder __result = new Ice.IntHolder();
        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {
                public Ice.DispatchStatus run(Ice.Object __obj)
                {
                    Account __servant = null;
                    if(__obj == null || __obj instanceof Account)
                    {
                        __servant = (Account)__obj;
                    }
                    else
                    {
                        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
                    }
                    __result.value = __servant.getBalance(__current);
                    return Ice.DispatchStatus.DispatchOK;
                }
            };
            try
            {
                Ice.DispatchStatus __status = __direct.getServant().__collocDispatch(__direct);
                if(__status == Ice.DispatchStatus.DispatchUserException)
                {
                    __direct.throwUserException();
                }
                assert __status == Ice.DispatchStatus.DispatchOK;
                return __result.value;
            }
            finally
            {
                __direct.destroy();
            }
        }
        catch(Ice.SystemException __ex)
        {
            throw __ex;
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwWrapper(__ex);
        }
        return __result.value;
    }

    public void transferMoney(final String accountNumber, final int amount, java.util.Map<String, String> __ctx, Ice.Instrumentation.InvocationObserver __observer)
        throws IceInternal.LocalExceptionWrapper,
            IncorrectAccountNumber,
            IncorrectAmount
    {
        final Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "transferMoney", Ice.OperationMode.Normal, __ctx);
        IceInternal.Direct __direct = null;
        try
        {
            __direct = new IceInternal.Direct(__current)
            {
                public Ice.DispatchStatus run(Ice.Object __obj)
                {
                    Account __servant = null;
                    if(__obj == null || __obj instanceof Account)
                    {
                        __servant = (Account)__obj;
                    }
                    else
                    {
                        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
                    }
                    try
                    {
                        __servant.transferMoney(accountNumber, amount, __current);
                        return Ice.DispatchStatus.DispatchOK;
                    }
                    catch(Ice.UserException __ex)
                    {
                        setUserException(__ex);
                        return Ice.DispatchStatus.DispatchUserException;
                    }
                }
            };
            try
            {
                Ice.DispatchStatus __status = __direct.getServant().__collocDispatch(__direct);
                if(__status == Ice.DispatchStatus.DispatchUserException)
                {
                    __direct.throwUserException();
                }
                assert __status == Ice.DispatchStatus.DispatchOK;
            }
            finally
            {
                __direct.destroy();
            }
        }
        catch(IncorrectAccountNumber __ex)
        {
            throw __ex;
        }
        catch(IncorrectAmount __ex)
        {
            throw __ex;
        }
        catch(Ice.SystemException __ex)
        {
            throw __ex;
        }
        catch(Throwable __ex)
        {
            IceInternal.LocalExceptionWrapper.throwWrapper(__ex);
        }
    }
}
