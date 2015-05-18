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

package server.generated.Bank;

public abstract class Callback_Account_getAccountNumber extends Ice.TwowayCallback
{
    public abstract void response(String __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        AccountPrx __proxy = (AccountPrx)__result.getProxy();
        String __ret = null;
        try
        {
            __ret = __proxy.end_getAccountNumber(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
