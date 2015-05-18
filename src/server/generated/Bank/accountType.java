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

public enum accountType implements java.io.Serializable
{
    
    SILVER(0),
    
    PREMIUM(1);

    public int
    value()
    {
        return __value;
    }

    public static accountType
    valueOf(int __v)
    {
        switch(__v)
        {
        case 0:
            return SILVER;
        case 1:
            return PREMIUM;
        }
        return null;
    }

    private
    accountType(int __v)
    {
        __value = __v;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeEnum(value(), 1);
    }

    public static accountType
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readEnum(1);
        return __validate(__v);
    }

    private static accountType
    __validate(int __v)
    {
        final accountType __e = valueOf(__v);
        if(__e == null)
        {
            throw new Ice.MarshalException("enumerator value " + __v + " is out of range");
        }
        return __e;
    }

    private final int __value;
}
