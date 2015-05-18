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

public interface _AccountOperations
{
    int getBalance(Ice.Current __current);

    String getAccountNumber(Ice.Current __current);

    void transferMoney(String accountNumber, int amount, Ice.Current __current)
        throws IncorrectAccountNumber,
               IncorrectAmount;
}
