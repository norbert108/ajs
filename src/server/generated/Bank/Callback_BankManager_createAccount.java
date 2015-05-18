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

public abstract class Callback_BankManager_createAccount extends Ice.TwowayCallback
{
    public abstract void response(String accountID);
    public abstract void exception(Ice.UserException __ex);

    public final void __completed(Ice.AsyncResult __result)
    {
        BankManagerPrx __proxy = (BankManagerPrx)__result.getProxy();
        Ice.StringHolder accountID = new Ice.StringHolder();
        try
        {
            __proxy.end_createAccount(accountID, __result);
        }
        catch(Ice.UserException __ex)
        {
            exception(__ex);
            return;
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(accountID.value);
    }
}