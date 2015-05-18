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

public class NoSuchAccount extends Ice.UserException
{
    public NoSuchAccount()
    {
    }

    public NoSuchAccount(Throwable __cause)
    {
        super(__cause);
    }

    public String
    ice_name()
    {
        return "Bank::NoSuchAccount";
    }

    protected void
    __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice("::Bank::NoSuchAccount", -1, true);
        __os.endWriteSlice();
    }

    protected void
    __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = -1162325300L;
}
