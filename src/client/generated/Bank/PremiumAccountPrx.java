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

public interface PremiumAccountPrx extends AccountPrx
{
    public void calculateLoan(int amount, Currency curr, int period, Ice.FloatHolder interestRate, Ice.IntHolder totalCost)
        throws IncorrectData;

    public void calculateLoan(int amount, Currency curr, int period, Ice.FloatHolder interestRate, Ice.IntHolder totalCost, java.util.Map<String, String> __ctx)
        throws IncorrectData;

    public Ice.AsyncResult begin_calculateLoan(int amount, Currency curr, int period);

    public Ice.AsyncResult begin_calculateLoan(int amount, Currency curr, int period, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_calculateLoan(int amount, Currency curr, int period, Ice.Callback __cb);

    public Ice.AsyncResult begin_calculateLoan(int amount, Currency curr, int period, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_calculateLoan(int amount, Currency curr, int period, Callback_PremiumAccount_calculateLoan __cb);

    public Ice.AsyncResult begin_calculateLoan(int amount, Currency curr, int period, java.util.Map<String, String> __ctx, Callback_PremiumAccount_calculateLoan __cb);

    public void end_calculateLoan(Ice.FloatHolder interestRate, Ice.IntHolder totalCost, Ice.AsyncResult __result)
        throws IncorrectData;
}
