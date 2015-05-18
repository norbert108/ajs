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

public interface _BankManagerOperationsNC
{
    void createAccount(PersonalData data, accountType type, Ice.StringHolder accountID)
        throws IncorrectData,
               RequestRejected;

    void removeAccount(String accountID)
        throws IncorrectData,
            NoSuchAccount;
}
